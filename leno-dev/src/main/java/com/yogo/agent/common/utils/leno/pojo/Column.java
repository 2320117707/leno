package com.yogo.agent.common.utils.leno.pojo;

/**
 * @Author owen
 * @Date 2020/11/11
 * @Description 封装数据库的每一列
 **/
public class Column {
    /**
     * 字段
     */
    private String field;
    /**
     * 数据类型
     */
    private String datatype;
    /**
     * 是否是主键
     */
    private boolean isPrimary;
    /**
     * 备注
     */
    private String remark;

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}