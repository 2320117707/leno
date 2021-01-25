package com.yogo.agent.common.utils.leno.pojo;

/**
 * @Author owen
 * @Date 2020/11/10
 * @Description 用于封装实体类信息
 **/
public class BeanInfo {

    /**
     * 实体类创建的路径 com.owen.utils.UserEntry
     */
    private String beanPath;

    /**
     * 是否完成创建
     */
    private boolean isCreated;
    /**
     * 实体内容
     */
    private String beanContent;
    /**
     * 指引类
     */
    private Class guideClass;


    public BeanInfo(String beanPath, String beanContent, Class guideClass) {
        this.beanPath = beanPath;
        this.beanContent = beanContent;
        this.guideClass = guideClass;
    }

    public BeanInfo() {
    }

    public Class getGuideClass() {
        return guideClass;
    }

    public void setGuideClass(Class guideClass) {
        this.guideClass = guideClass;
    }

    public String getBeanPath() {
        return beanPath;
    }

    public void setBeanPath(String beanPath) {
        this.beanPath = beanPath;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }

    public String getBeanContent() {
        return beanContent;
    }

    public void setBeanContent(String beanContent) {
        this.beanContent = beanContent;
    }

    @Override
    public String toString() {
        return "BeanInfo{" +
                "beanPath='" + beanPath + '\'' +
                ", isCreated=" + isCreated +
                ", beanContent='" + beanContent + '\'' +
                '}';
    }
}
