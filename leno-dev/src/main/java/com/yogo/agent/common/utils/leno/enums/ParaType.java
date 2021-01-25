package com.yogo.agent.common.utils.leno.enums;

import com.yogo.agent.common.utils.leno.config.Constant;

/**
 * 枚举内部类
 */

public enum ParaType {
    /**
     * 包装类
     */
    P_INTEGER("java.lang.Integer", Constant.END_IN_ZERO),
    P_LONG("java.lang.Long", Constant.END_IN_ZERO),
    P_DOUBLE("java.lang.Double", Constant.END_IN_ZERO),
    P_BOOLEAN("java.lang.Boolean", Constant.END_IN_FALSE),
    P_BYTE("java.lang.Byte", Constant.END_IN_ZERO),
    P_SHORT("java.lang.Short", Constant.END_IN_ZERO),
    P_FLOAT("java.lang.Float", Constant.END_IN_ZERO),
    P_CHARACTER("java.lang.Character", Constant.END_IN_STRING),

    /**
     * 基本数据类型
     */
    B_BYTE("byte", Constant.END_IN_ZERO),
    B_SHORT("short", Constant.END_IN_ZERO),
    B_INT("int", Constant.END_IN_ZERO),
    B_LONG("long", Constant.END_IN_ZERO),
    B_FLOAT("float", Constant.END_IN_ZERO),
    B_DOUBLE("double", Constant.END_IN_ZERO),
    B_BOOLEAN("boolean", Constant.END_IN_FALSE),
    B_CHAR("char", Constant.END_IN_NULL),

    /**
     * 其它
     */
    DATE("java.util.Date", Constant.END_IN_TIME),
    STRING("java.lang.String", Constant.END_IN_STRING),
    BIG_DECIMAL("java.math.BigDecimal", Constant.END_IN_STRING),
    BIG_INTEGER("java.math.BigInteger", Constant.END_IN_STRING),
    MAP("java.util.Map", Constant.END_IN_BRACE);

    public String typeName;
    public String content;

    ParaType(String typeName, String content) {
        this.typeName = typeName;
        this.content = content;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getContent() {
        return content;
    }
}