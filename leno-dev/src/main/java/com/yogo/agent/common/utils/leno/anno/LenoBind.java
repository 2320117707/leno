package com.yogo.agent.common.utils.leno.anno;

import java.lang.annotation.*;

/**
 * @Author owen
 * @Date 2020/11/11
 * @Description
 **/
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LenoBind {

    /**
     * 是否自增
     */
    boolean isAuto() default false;

    /**
     * 是否可以为空 sql.add - >  NOT NULL
     */
    boolean isNull() default true;

    /**
     * 默认值 sql.add - > DEFAULT ""
     */
    String defaultValue() default "";

    /**
     * 是否唯一 sql.add - > UNIQUE
     */
    boolean isUnique() default false;
}
