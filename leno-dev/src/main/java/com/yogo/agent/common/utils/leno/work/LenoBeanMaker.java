package com.yogo.agent.common.utils.leno.work;


import com.yogo.agent.common.utils.leno.config.Constant;
import com.yogo.agent.common.utils.leno.enums.DT;
import com.yogo.agent.common.utils.leno.pojo.BeanInfo;
import com.yogo.agent.common.utils.leno.pojo.Column;
import com.yogo.agent.common.utils.leno.util.LenoDBOperation;
import com.yogo.agent.common.utils.leno.util.LenoTownPortal;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author owen
 * @Date 2020/11/6
 * @Description run
 **/
public class LenoBeanMaker {


    /**
     * 主方法生成.java实体类文件
     *
     * @param guideClass 同包下的类Class,表示在 "guideClass" 同文件夹下创建
     * @param className  类名
     * @param tableName  表名
     * @param isLombok   是否开启Lombok注解
     * @return 返回创建结果和类对象
     */
    public static BeanInfo run(Class guideClass, String className, String tableName, Boolean isLombok) throws Exception {
        String tableStructure = LenoDBOperation.getTableStructure(Constant.SQL_PREFIX + tableName);
        String result = beanView(className, tableStructure, isLombok);
        String beanPath = LenoTownPortal.start(guideClass, result);
        BeanInfo beanInfo = new BeanInfo(beanPath, result, guideClass);
        if (StringUtils.isEmpty(beanPath)) {
            beanInfo.setCreated(false);
        } else {
            beanInfo.setCreated(true);
        }
        return beanInfo;
    }

    /**
     * 表结构生成实体类映射的方法
     *
     * @param tableStructure 表结构
     * @return Bean
     */
    private static String beanView(String className, String tableStructure, Boolean isLombok) {
        List<Column> columns = collectField(tableStructure);
        StringBuilder builder = new StringBuilder(Constant.REMARK);
        builder.append(isLombok ? Constant.LOMBOK_CLASS_HEADER : Constant.CLASS_HEADER).append(className).append(Constant.SPACE).append(Constant.BRACE_OPEN).append(Constant.NNT);
        boolean havDate = false;
        boolean havDecimal = false;
        for (int i = Constant.ZERO; i < columns.size(); i++) {
            Column column = columns.get(i);
            String datatype = column.getDatatype();
            if (datatype.equals(Constant.DATE_NAME)) havDate = true;
            if (datatype.equals(Constant.DECIMAL_NAME)) havDecimal = true;
            String field = column.getField();
            builder.append(Constant.BAR_STAR_STAR).append(Constant.NTS).append(Constant.STAR).append(Constant.SPACE).append(column.getRemark()).append(Constant.NTS).append(Constant.STAR_BAR);
            builder.append(Constant.NTS).append(Constant.PRIVATE).append(datatype).append(Constant.SPACE).append(field).append(Constant.BRANCH);
            if (i == columns.size() - Constant.ONE) {
                builder.append(isLombok ? Constant.N : Constant.NNT);
            } else {
                builder.append(Constant.NNT);
            }
        }
        if (isLombok) builder.insert(Constant.ZERO, Constant.LOMBOK_JAR);
        if (havDate) builder.insert(Constant.ZERO, Constant.DATE_JAR);
        if (havDecimal) builder.insert(Constant.ZERO, Constant.DECIMAL_JAR);
//      如果不是lombok,生成GetterAndSetter
        if (!isLombok) {
            for (Column column : columns) {
                String datatype = column.getDatatype();
                String field = column.getField();
                String gsName = field.replaceFirst(Constant.START, String.valueOf(field.charAt(Constant.ZERO)).toUpperCase());
                //getter
                builder.append(Constant.NNT).append(Constant.PUBLIC).append(datatype)
                        .append(Constant.SPACE).append(Constant.GET).append(gsName).append(Constant.BRACKETS).append(Constant.SPACE_BRACE)
                        .append(Constant.NTT).append(Constant.RETURN).append(Constant.SPACE).append(field).append(Constant.BRANCH)
                        .append(Constant.NT).append(Constant.BRACE_CLOSE);
                //setter
                builder.append(Constant.NNT).append(Constant.SET_HEADER).append(gsName).append(Constant.BRACKETS_OPEN).append(datatype).append(Constant.SPACE).append(field).append(Constant.BRACKETS_CLOSE).append(Constant.SPACE_BRACE)
                        .append(Constant.NTT).append(Constant.THIS_POINT).append(field).append(Constant.EQUAL).append(field).append(Constant.BRANCH)
                        .append(Constant.NT).append(Constant.BRACE_CLOSE);
            }
            builder.append(Constant.NN);
        }

        builder.append(Constant.BRACE_CLOSE);

        return builder.toString();
    }

    /**
     * 字段下划线变驼峰的方法
     *
     * @param field 下划线字段
     * @return String
     */
    public static String underlineToHump(String field) {
        if (!field.contains(Constant.UNDERLINE)) return field;
        String[] fArr = field.split(Constant.UNDERLINE);
        StringBuilder builder = new StringBuilder(fArr[Constant.ZERO]);
//        int magic = shape ? ONE : ZERO;
        for (int i = Constant.ONE; i < fArr.length; i++) {
            String c = fArr[i];
            String head = String.valueOf(c.charAt(Constant.ZERO));
            builder.append(c.replaceFirst(head, head.toUpperCase()));
        }
        return builder.toString();
    }


    /**
     * 封装每一列
     *
     * @param originTable 表结构
     * @return 返回集合
     */
    private static List<Column> collectField(String originTable) {
//      处理``符号和''符号以及表结构的头尾部分.
        String tb = processPunctuation(originTable);
        String columns = tb.substring(tb.indexOf(Constant.BRACKETS_OPEN) + Constant.FOUR, tb.lastIndexOf(Constant.BRACKETS_CLOSE) - Constant.ONE);
//      整理每一行为单独的字符串 ->  order_id varchar(100) NOT NULL COMMENT 订单号,
        String[] columnList = columns.split(Constant.CUT_EACH_COLUMN);
//      创建一个集合作为容器放置最终数据 里面是每一列的对象.
        ArrayList<Column> vos = new ArrayList<>();
        for (String li : columnList) {
            Column column = new Column();
            if (li.equals(Constant.BLANK) || li.startsWith(Constant.PRIMARY_KEY) || li.startsWith(Constant.KEY) || li.startsWith(Constant.CONSTRAINT) || li.startsWith(Constant.UNIQUE))
                continue;
            String field = processField(li);
            String remark = processRemark(li);
            String dataType = processDataType(li);
            column.setField(underlineToHump(field));
            column.setRemark(remark.trim());
            column.setDatatype(dataType);
            vos.add(column);
        }
        return vos;
    }

    /**
     * 处理备注返回备注
     *
     * @return 备注
     */
    private static String processRemark(String columns) {
        String aCase = columns.toUpperCase();
        return aCase.contains(Constant.UP_COMMENT) ? aCase.split(Constant.UP_COMMENT)[Constant.ONE].toLowerCase() : Constant.NO_REMARK;
    }


    /**
     * 处理字段名称
     *
     * @param columns 列
     * @return String
     */
    private static String processField(String columns) {
        return columns.split(Constant.SPACE)[Constant.ZERO];
    }

    /**
     * 处理标点 ` `
     *
     * @param element 元素
     * @return String
     */
    private static String processPunctuation(String element) {
        return element.replaceAll("['、`]", Constant.BLANK);
    }

    /**
     * 处理数据类型
     * `
     *
     * @param columns 列
     * @return String
     */
    private static String processDataType(String columns) {
        String s = columns.toUpperCase().split(Constant.SPACE)[Constant.ONE].replaceAll("[^A-Z]", Constant.BLANK);
        for (DT en : DT.values()) {
            if (en.dbType.equals(s)) {
                return en.beanType;
            }
        }
        return Constant.STRING;
    }
}


