package com.yogo.agent.common.utils.leno.enums;

/**
 * 数据类型枚举   用于Bean对应数据库的
 */
public enum DTR {
    BIGINT("Integer", "BIGINT","255"),//整数值（没有小数点）。精度 19。
    INT("int", "INT","255"),//整数值（没有小数点）。精度 19。
    LONG("Long", "BIGINT","255"),//整数值（没有小数点）。精度 19。
    B_LONG("long", "BIGINT","255"),//整数值（没有小数点）。精度 19。
    DECIMAL("BigDecimal", "DECIMAL","5,2"),//精确数值，精度 p，小数点后位数 s。例如：decimal(5,2) 是一个小数点前有 3 位数，小数点后有 2 位数的数字。
    VARCHAR("String", "VARCHAR","255"),       //	字符串
    FLOAT("Float", "FLOAT","255,2"),     //	近似数值，尾数精度 16。
    Double("Double", "DOUBLE PRECISION","255,2"),    //	PRECISION	近似数值，尾数精度 16。
    Time("Time", "TIME","6"),      //存储小时、分、秒的值。
    TIMESTAMP("Date", "TIMESTAMP","6"), //	存储年、月、日、小时、分、秒的值。
    ARRAY("List", "ARRAY",""),     //	元素的固定长度的有序集合
    MULTISET("Set", "MULTISET",""),  //元素的可变长度的无序集合
    TINYINT("Boolean", "TINYINT","1"),       //	tinyint
    BOOLEAN("boolean", "TINYINT","1"),       //	boolean
    CHARACTER("Character", "CHAR","255"),       //	char
    CHAR("char", "CHAR","255"),           //	char
    BLOB("byte[]", "BLOB","")          //	BLOB
    ;

    DTR(String beanType, String dbType,String length) {
        this.beanType = beanType;
        this.dbType = dbType;
        this.length = length;
    }

    public String beanType;
    public String dbType;
    public String length;
}