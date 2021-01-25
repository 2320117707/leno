package com.yogo.agent.common.utils.leno.anno;

import com.yogo.agent.common.utils.leno.enums.FieldType;

import java.lang.annotation.*;

/**
 * @Author owen
 * @Date 2020/11/11
 * @Description
 **/
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LenoField {

    /**
     * 类型
     */
    FieldType type() default FieldType.BLANK;

    /**
     * 长度
     */
    String length() default "";

    /**
     * 是否主键
     */
    boolean isKey() default false;

    /**
     * 约束
     */
    LenoBind bind() default @LenoBind();

}
