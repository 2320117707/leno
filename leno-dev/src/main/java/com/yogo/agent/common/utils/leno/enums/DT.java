package com.yogo.agent.common.utils.leno.enums;

/**
* 数据类型枚举
*/
public enum DT {
        SMALLINT("Integer", "SMALLINT"),//整数值（没有小数点）。精度 5。
        INTEGER("Integer", "INTEGER"),//整数值（没有小数点）。精度 10。
        BIGINT("Integer", "BIGINT"),//整数值（没有小数点）。精度 19。
        DECIMAL("BigDecimal", "DECIMAL"),//精确数值，精度 p，小数点后位数 s。例如：decimal(5,2) 是一个小数点前有 3 位数，小数点后有 2 位数的数字。
        NUMERIC("String", "NUMERIC"),//精确数值，精度 p，小数点后位数 s。（与 DECIMAL 相同）
        REAL("Float", "REAL"),      //近似数值，尾数精度 7。
        FLOAT("Float", "FLOAT"),     //	近似数值，尾数精度 16。
        Double("Double", "DOUBLE PRECISION"),    //	PRECISION	近似数值，尾数精度 16。
        DATE("Date", "DATE"),      //存储年、月、日的值。
        Time("Time", "TIME"),      //存储小时、分、秒的值。
        YEAR("Date", "YEAR"),      //java.sql.Date
        TIMESTAMP("Date", "TIMESTAMP"), //	存储年、月、日、小时、分、秒的值。
        INTERVAL("String", "INTERVAL"),  //由一些整数字段组成，代表一段时间，取决于区间的类型。
        ARRAY("List", "ARRAY"),     //	元素的固定长度的有序集合
        MULTISET("Set", "MULTISET"),  //元素的可变长度的无序集合
        XML("String", "XML"),       //	存储 XML 数据
        VARCHAR("String", "VARCHAR"),       //	字符串
        CHARACTER("String", "CHARACTER"),       //	字符/字符串。固定长度 n。
        CHARACTER_VARYING("String", "CHARACTER VARYING"),       //	可变长度。最大长度
        TINYINT("Boolean", "TINYINT"),       //	tinyint
        BOOLEAN("Boolean", "BOOLEAN"),       //	boolean
        CHAR("Character", "CHAR"),       //	char
        BLOB("byte[]", "BLOB"),       //	BLOB
        TEXT("String", "TEXT"),       //	TEXT
        INT("Integer", "INT");


        DT(String beanType, String dbType) {
            this.beanType = beanType;
            this.dbType = dbType;
        }

        public String beanType;
        public String dbType;
    }