package com.yogo.agent.common.utils.leno.work;


import com.yogo.agent.common.utils.leno.anno.LenoBind;
import com.yogo.agent.common.utils.leno.anno.LenoField;
import com.yogo.agent.common.utils.leno.config.Constant;
import com.yogo.agent.common.utils.leno.enums.DTR;
import com.yogo.agent.common.utils.leno.pojo.DataModel;
import com.yogo.agent.common.utils.leno.util.LenoDBOperation;
import com.yogo.agent.common.utils.leno.util.LenoTownPortal;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author owen
 * @Date 2020/11/11
 * @Description
 **/
public class LenoTableMaker {

    /**
     * 擦除Leno注解
     *
     * @param c Class
     * @throws Exception
     */
    public static void clearLeno(Class c) throws Exception {
        String content = getClassContent(c, false);
        String path = LenoTownPortal.getPathByClass(c);
        if (!LenoTownPortal.delFile(path)) System.out.println("文件不存在!" + path);
        LenoTownPortal.start(c, content);
    }


    /**
     * 处理注解
     *
     * @param rmHeader 去掉class头后的内容 Dog { ...
     * @param modelMap map
     * @return
     */
    public static LinkedHashMap<String, DataModel> processRemark(String[] rmHeader, LinkedHashMap<String, DataModel> modelMap) {
        modelMap.forEach((fieldName, model) -> {
            String regex = "/\\*\\*([\\s\\S]*)" + fieldName + Constant.BRANCH;
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(rmHeader[Constant.ZERO]);
            if (!matcher.find()) {
                model.setRemark("COMMENT ''," + Constant.NT);
            } else {
                String substring = rmHeader[Constant.ZERO].substring(matcher.start(), matcher.end());
                String remark = substring.split("\\*/")[Constant.ZERO].replaceAll("[/*]", Constant.BLANK).trim();
                String residue = rmHeader[Constant.ZERO].replaceFirst(regex, Constant.BLANK);
                rmHeader[Constant.ZERO] = residue;
                model.setRemark("COMMENT '" + remark + "'," + Constant.NT);
            }
        });
        return modelMap;
    }

    public static void run(Class c, String tableName, boolean clearLeno) throws Exception {
//        获取类的内容
        String content = getClassContent(c, true);
//        收集字段名称,数据类型,约束
        LinkedHashMap<String, DataModel> modelMap = collectField(c);
//        将类的内容掐头去尾
        final String[] rmHeader = {content.split(Constant.CLASS_HEADER)[Constant.ONE].split(Constant.BRACE_CLOSE)[Constant.ZERO].split(Constant.RETURN)[Constant.ZERO]};
//        处理注解
        LinkedHashMap<String, DataModel> resultMap = processRemark(rmHeader, modelMap);
//        拼接sql语句
        String sql = joinTable(org.apache.commons.lang3.StringUtils.isNotEmpty(tableName) ? tableName : getTableName(rmHeader), resultMap);
//        判断sql是否为空
        if (!sql.equals("")) {
//        执行sql语句,判断是否调用擦除Leno
            System.out.println("sql如下:\n" + sql);
            if ((LenoDBOperation.createTable(sql) && clearLeno)) {
                clearLeno(c);
            }
        } else {
            System.out.println("sql语句是空的");
        }
    }

    private static String joinTable(String tableName, LinkedHashMap<String, DataModel> resultMap) {
        String header = Constant.TABLE_HEADER + tableName + Constant.SPACE + Constant.BRACKETS_OPEN + Constant.NT;
        AtomicReference<StringBuilder> builder = new AtomicReference<>(new StringBuilder());
        ArrayList<String> keys = new ArrayList<>();
        resultMap.values().forEach((md) -> {
            if (md.isKey()) keys.add(md.getName());
            builder.get().append(md.getName()).append(Constant.SPACE).append(md.getType()).append(md.getLength()).append(md.getBind()).append(md.getRemark());
        });
        String body;
        String primaryKey = Constant.BLANK;
        if (keys.isEmpty()) {
            StringBuilder bd = builder.get();
            body = bd.deleteCharAt(bd.length() - Constant.Three).deleteCharAt(bd.length() - Constant.ONE).toString();
        } else {
            body = builder.get().toString();
            primaryKey = Constant.PRIMARY_KEY + Constant.SPACE + addBrackets(String.join(Constant.COMMA, keys)) + Constant.N;
        }
        String tail = Constant.TABLE_TAIL;
        return header + body + primaryKey + tail;
    }

    private static String getTableName(String[] rmHeader) {
        String tableName = rmHeader[Constant.ZERO].split(" \\{")[Constant.ZERO];
        return humpToUnderFiled(tableName).replaceFirst(Constant.UP_POINT, "`tb");
    }


    /**
     * 将Class内容读出来
     *
     * @param c    Class类
     * @param flag true读所有 false读除了@Leno注解之外
     * @return
     * @throws Exception
     */
    public static String getClassContent(Class c, boolean flag) throws Exception {
        String path = LenoTownPortal.getPathByClass(c);
        File f = new File(path);
//      判断文件或目录是否存在
        StringBuilder result = new StringBuilder();
        if (f.exists()) {
            if (f.isFile()) {
//              该缓冲流有一个readLine()独有方法
                BufferedReader br = new BufferedReader(new FileReader(path));
                String s;
//              readLine()每次读取一行
                while ((s = br.readLine()) != null) {
                    if (flag) {
                        result.append(s).append(Constant.N);
                    } else {
                        if (!s.contains("@Leno") && !s.startsWith("    )") && !s.startsWith("package") && !s.contains("leno"))
                            result.append(s).append(Constant.N);
                    }
                }
                br.close();
            }
        } else System.out.println(Constant.FILE_NOT_FOUND);
        return result.toString();
    }


    /**
     * 将Bean封装成Map 字段名为Key，value为类型
     *
     * @param c 类
     */
    public static LinkedHashMap<String, DataModel> collectField(Class c) {
        LinkedHashMap<String, DataModel> map = new LinkedHashMap<>();
        for (Field field : c.getDeclaredFields()) {
            DataModel model = new DataModel();
            String fieldName = field.getName();
            model.setName(humpToUnderFiled(fieldName));
            for (DTR value : DTR.values()) {
                String fieldTypeName = field.getType().getName();
                if (fieldTypeName.contains(value.beanType)) {
                    model.setType(value.dbType);
                    model.setLength(addBrackets(value.length) + Constant.SPACE);
                }
            }
//          获取注解
            LenoField lenoField = field.getDeclaredAnnotation(LenoField.class);
            String constraint = Constant.BLANK;
            if (Objects.nonNull(lenoField)) {
//              是否是主键
                if (lenoField.isKey()) model.setKey(true);
                LenoBind bind = lenoField.bind();
//              是否允许为Null
                constraint = !bind.isNull() ? Constant.NOT_NULL : Constant.BLANK;
//              是否唯一
                constraint += bind.isUnique() ? Constant.UNIQUE : Constant.BLANK;
//              是否有默认值
                String value = bind.defaultValue();
                constraint += !StringUtils.isEmpty(value) ? Constant.DEFAULT + addMark("\"", value) + Constant.SPACE : Constant.BLANK;
//              是否自增
                constraint = bind.isAuto() ? Constant.NOT_NULL_AUTO_INCREMENT : constraint;
//              处理类型
                String type = lenoField.type().type;
                if (!StringUtils.isEmpty(type)) model.setType(type);
//              处理数据长度
                String length = lenoField.length();
                if (!StringUtils.isEmpty(length)) model.setLength(addBrackets(length) + Constant.SPACE);
            }
            model.setBind(constraint);
            map.put(fieldName, model);
        }
        return map;
    }

    /**
     * 驼峰转下划线 -> 字段
     *
     * @return
     */
    private static String humpToUnderFiled(String field) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = field.toCharArray();
        for (char c : chars) {
            String aChar = String.valueOf(c);
            if (aChar.matches("[A-Z]")) {
                list.add(Constant.UNDERLINE + aChar.toLowerCase());
            } else {
                list.add(aChar);
            }
        }
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return addMark(Constant.UP_POINT, builder.toString());
    }

    private static String addBrackets(String length) {
        return Constant.BRACKETS_OPEN + length + Constant.BRACKETS_CLOSE;
    }

    private static String addMark(String mark, String value) {
        return mark + value + mark;
    }
}
