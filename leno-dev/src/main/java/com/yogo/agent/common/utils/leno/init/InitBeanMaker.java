package com.yogo.agent.common.utils.leno.init;


import com.yogo.agent.common.utils.leno.config.Constant;
import com.yogo.agent.common.utils.leno.pojo.BeanInfo;
import com.yogo.agent.common.utils.leno.work.LenoBeanMaker;
import com.yogo.agent.common.utils.leno.work.LenoClassMaker;

/**
 * @Author owen
 * @Date 2020/11/9
 * @Description
 **/

public class InitBeanMaker {

    private Class guideClass;
    private String className;
    private String tableName;
    private Boolean isLombok = false;
    private Boolean frame = false;

    public InitBeanMaker(Class guideClass, String tableName) {
        this.guideClass = guideClass;
        this.tableName = tableName;
        this.className = LenoBeanMaker.underlineToHump(tableName).replaceFirst(Constant.START, String.valueOf(tableName.charAt(Constant.ZERO)).toUpperCase());
    }

    public InitBeanMaker lombok() {
        this.isLombok = true;
        return this;
    }

    public InitBeanMaker setClassName(String className) {
        this.className = className;
        return this;
    }

    public InitBeanMaker frame() {
        this.frame = true;
        return this;
    }

    public void ok() throws Exception {
        BeanInfo beanInfo = LenoBeanMaker.run(guideClass, className, tableName, isLombok);
        if (frame){
            LenoClassMaker.genericFrame(beanInfo.getBeanPath(), beanInfo.getGuideClass());
        }
        if (beanInfo.isCreated()) {
            System.out.println(Constant.SUCCESS);
        } else {
            System.out.println(Constant.FAIL);
        }
    }
}
