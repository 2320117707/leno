package com.yogo.agent.common.utils.leno.control;


import com.yogo.agent.common.utils.leno.init.InitBeanMaker;
import com.yogo.agent.common.utils.leno.init.InitJsonView;
import com.yogo.agent.common.utils.leno.init.InitTableMaker;

/**
 * @Author owen
 * @Date 2020/11/9
 * @Description Leno入口
 **/
public class LenoControl {

    /**
     * 创建bean实体
     *
     * @param guideClass    引导类
     * @param tableName     表名
     */
    public static InitBeanMaker beanMaker(Class guideClass, String tableName) {
        return new InitBeanMaker(guideClass,tableName);
    }

    /**
     * 创建json参数
     *
     * @param source    指定类
     */
    public static InitJsonView jsonView(Class source) {
        return new InitJsonView(source);
    }

    /**
     * 创建数据库表
     *
     * @param source    指定类
     */
    public static InitTableMaker tableMaker(Class source) {
        return new InitTableMaker(source);
    }

}
