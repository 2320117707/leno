package com.yogo.agent.common.utils.leno.pojo;

/**
 * @Author owen
 * @Date 2020/11/11
 * @Description 数据库数据模型
 **/
public class DataModel {
    /**
     * 字段名称
     */
    private String name;
    /**
     * 数据类型
     */
    private String type;
    /**
     * 约束内容
     */
    private String bind;
    /**
     * 是否是主键
     */
    private boolean isKey;
    /**
     * 数据长度
     */
    private String length;
    /**
     * 注解
     */
    private String remark;


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

}
