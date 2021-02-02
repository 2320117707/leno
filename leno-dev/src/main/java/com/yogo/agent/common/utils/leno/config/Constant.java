package com.yogo.agent.common.utils.leno.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author owen
 * @Date 2020/11/10
 * @Description 常量池
 **/
public class Constant {
    //BeanMaker
    /**
     * 替换路径
     */
    public static final String TARGET_CLASSES = "target/classes";
    public static final String PACKAGE = "package ";
    public static final String MUST_PATH = "src/main/java";
    public static final String JAVA_GANG = "java/";
    /**
     * 生成的文件类型
     */
    public static final String TYPE = ".java";

    /**
     * 常用数字
     */
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int Three = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;

    /**
     * 符号-制表符
     */
    public static final String UNDERLINE = "_";
    public static final String SPACE = " ";
    public static final String BLANK = "";
    public static final String POINT = ".";
    public static final String GANG = "/";
    public static final String CUT_EACH_COLUMN = ",\n  ";
    public static final String BRACKETS_OPEN = "(";
    public static final String BRACKETS_CLOSE = ")";
    public static final String BRACKETS = "()";
    public static final String BRACE_OPEN = "{";
    public static final String SPACE_BRACE = " {";
    public static final String BRANCH = ";";
    public static final String EQUAL = " = ";
    public static final String NNT = "\n\n\t";
    public static final String NTS = "\n\t ";
    public static final String NN = "\n\n";
    public static final String NTT = "\n\t\t";
    public static final String NT = "\n\t";
    public static final String N = "\n";
    public static final String B = "\b";
    public static final String STAR = "*";
    public static final String BAR_STAR_STAR = "/**";
    public static final String STAR_BAR = "*/";
    public static final String BRACE_CLOSE = "}";
    public static final String START = "^.";
    public static final String END = ".$";

    /**
     * 关键词
     */
    public static final String PRIMARY_KEY = "PRIMARY KEY";
    public static final String KEY = "KEY";
    public static final String CONSTRAINT = "CONSTRAINT";
    public static final String UP_COMMENT = "COMMENT";
    public static final String STRING = "String";
    public static final String CLASS_HEADER = "public class ";
    public static final String INTERFACE_HEADER = "public interface ";
    public static final String LOMBOK_CLASS_HEADER = "@Data\npublic class ";
    public static final String PRIVATE = "private ";
    public static final String PUBLIC = "public ";
    public static final String GET = "get";
    public static final String RETURN = "return";
    public static final String SET_HEADER = "public void set";
    public static final String THIS_POINT = "this.";
    public static final String SQL_PREFIX = "show create table ";
    public static final String DECIMAL_JAR = "import java.math.BigDecimal;\n";
    public static final String DATE_JAR = "import java.util.Date;\n\n";
    public static final String LOMBOK_JAR = "import lombok.Data;\n\n";
    public static final String IMPORT = "import ";
    public static final String DATE_NAME = "Date";
    public static final String DECIMAL_NAME = "BigDecimal";

    /**
     * 提示语
     */
    public static final String NO_REMARK = "无备注";
    public static final String FAIL = "Java类存在或文件创建失败";
    public static final String SUCCESS = "创建完成";

    //JsonView
    /**
     * 符号
     */
    public static final String COMMA = ",";
    public static final String BRACKET_BRACE_OPEN = "[{";
    public static final char BRACE_CLOSE_CHAR = '}';
    public static final String BRACKET_CLOSE = "]";
    public static final String ANGLE_BRACKETS_OPEN = "<";
    public static final String ANGLE_BRACKETS_CLOSE = ">";
    public static final String SINGLE_QUOTES = "\"";
    public static final String SINGLE_QUOTES_WITH_COLON = "\":";
    /**
     * 填充参数
     */
    public static final String END_IN_BRACKET = "\":[],";
    public static final String END_IN_BRACE = "\":{},";
    public static final String END_IN_NULL = "\":null,";
    public static final String END_IN_STRING = "\":\"\",";
    public static final String END_IN_ZERO = "\":0,";
    public static final String END_IN_FALSE = "\":false,";
    public static final String END_IN_TIME = "\":\"" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\",";

    /**
     * 解决乱码
     */
    public static final String UTF8 = "utf-8";

    //ClassMaker
    public static String REMARK = "/**\n" +
            " * @Author \n" +
            " * @Date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n" +
            " * @Description\n" +
            " **/\n";
    public static final String MAPPER_CLASS_HEADER = "@Repository\npublic interface ";
    public static final String TK_MAPPER_JAR = "import tk.mybatis.mapper.common.Mapper;\nimport org.springframework.stereotype.Repository;\n\n";
    public static final String SERVICE_CLASS_HEADER = "@Service\npublic class ";
    public static final String CONTROLLER_CLASS_HEADER = "@Controller\npublic class ";
    public static final String SERVICE_JAR = "import org.springframework.stereotype.Service;\n\n";
    public static final String AUTOWIRED = "import org.springframework.beans.factory.annotation.Autowired;\n";
    public static final String CONTROLLER_JAR = "import org.springframework.stereotype.Controller;\n\n";
    public static final String EXTENDS = "extends";
    public static final String MAPPER = "Mapper";
    public static final String SERVICE = "Service";
    public static final String CONTROLLER = "Controller";
    public static final String ENTRY_LOW = "Entry";
    public static final String ENTRY_UP = "ENTRY";
    public static final String ENTITY_LOW = "Entity";
    public static final String ENTITY_UP = "ENTITY";
    public static final String DTO_LOW = "Dto";
    public static final String DTO_UP = "DTO";
    public static final String AUTOWIRED_REMARK = "@Autowired";

    //TableMaker
    public static final String UP_POINT = "`";
    public static final String VARCHAR = "VARCHAR";
    public static final String NOT_NULL = "NOT NULL ";
    public static final String UNIQUE = "UNIQUE ";
    public static final String DEFAULT = "DEFAULT ";
    public static final String NOT_NULL_AUTO_INCREMENT = "NOT NULL AUTO_INCREMENT ";
    public static final String FILE_NOT_FOUND = "判断文件或目录不存在";
    public static final String TABLE_HEADER = "CREATE TABLE ";
    public static final String TABLE_TAIL = ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

}
