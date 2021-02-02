package com.yogo.agent.common.utils.leno.work;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yogo.agent.common.utils.leno.config.Constant;
import com.yogo.agent.common.utils.leno.enums.ParaType;

import java.lang.reflect.Field;
import java.util.Iterator;


/**
 * @Author leno
 * @Date 2020/11/3
 * @Description 根据JavaObject的Class对象获取它的JSON模型.
 * 使用方法(填入Class后main方法启动) String model = LenoJsonView.classToJsonModel(TestObject.class);
 **/
public class LenoJsonView {
    /**
     * 获取两层JSON结构的方法
     *
     * @param c Class 类型
     * @return String 字符串
     */
    public static String classToJsonModel(Class c) throws Exception {

        StringBuilder sb = new StringBuilder(Constant.BRACE_OPEN);
        for (Field field : c.getDeclaredFields()) {
//          获取第一层的字段名称
            String name = field.getName();
            StringBuilder subSb = new StringBuilder(Constant.BRACKET_BRACE_OPEN);
//          判断此字段是否是List或它的子类.
            Class<?> type = field.getType();
//          获取此字段的泛型名 java.util.List<java.lang.Integer>.
            String typeName = field.getGenericType().getTypeName();
//            System.out.println(typeName);
            if (Iterable.class.isAssignableFrom(type)) {
                boolean flag = false;
                for (ParaType value : ParaType.values()) {
                    if (typeName.contains(value.getTypeName())) {
                        sb.append(Constant.SINGLE_QUOTES).append(name).append(Constant.END_IN_BRACKET);
                        flag = true;
                    }
                }
                if (flag) continue;
//              切割出来的全限定类名是  java.lang.Integer.
                String className = typeName.split(Constant.ANGLE_BRACKETS_OPEN)[Constant.ONE].split(Constant.ANGLE_BRACKETS_CLOSE)[Constant.ZERO];
//              获取第一层List中泛型的Class对象.
                Class<?> aClass = Class.forName(className);
//              处理第二层
                for (Field subField : aClass.getDeclaredFields()) {
                    String subFieldName = subField.getName();
                    Class<?> subFieldType = subField.getType();
                    String subFieldTypeName = subField.getGenericType().getTypeName();
                    if (Iterator.class.isAssignableFrom(subFieldType)) {
//                      当前仅支持两层嵌套对象
                        subSb.append(Constant.SINGLE_QUOTES).append(subFieldName).append(Constant.END_IN_BRACKET);
                    } else {
                        genericProcess(subFieldName, subFieldTypeName, subSb);
                    }
                }
                subSb.setCharAt(subSb.lastIndexOf(Constant.COMMA), Constant.BRACE_CLOSE_CHAR);
                subSb.append(Constant.BRACKET_CLOSE).append(Constant.COMMA);
                sb.append(Constant.SINGLE_QUOTES).append(name).append(Constant.SINGLE_QUOTES_WITH_COLON).append(subSb.toString());
            } else {
                genericProcess(name, typeName.split(Constant.ANGLE_BRACKETS_OPEN)[Constant.ZERO], sb);
            }
        }
//              处理结尾的 "," 换 "}" 操作.
        sb.setCharAt(sb.lastIndexOf(Constant.COMMA), Constant.BRACE_CLOSE_CHAR);
        return prettify(sb.toString());
    }

    /**
     * Field是正常情况下的处理
     *
     * @param name    TypeName 字段类型
     * @param builder 字符串拼接
     */
    private static void genericProcess(String name, String typeName, StringBuilder builder) {
        boolean fla = false;
        for (ParaType value : ParaType.values()) {
            if (typeName.contains(value.getTypeName())) {
                builder.append(Constant.SINGLE_QUOTES).append(name).append(value.getContent());
                fla = true;
            }
        }
        if (!fla) builder.append(Constant.SINGLE_QUOTES).append(name).append(Constant.END_IN_NULL);
    }


    /**
     * 美化JSON字符串
     *
     * @param model 参数是没经历格式化的JSON字符串
     * @return 美化后的字符串
     */
    private static String prettify(String model) {
        return JSON.toJSONString(JSONObject.parseObject(model), true);
    }
}

