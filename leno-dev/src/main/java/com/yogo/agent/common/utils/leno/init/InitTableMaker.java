package com.yogo.agent.common.utils.leno.init;


import com.yogo.agent.common.utils.leno.work.LenoTableMaker;

/**
 * @Author owen
 * @Date 2020/11/9
 * @Description
 **/
public class InitTableMaker {

    private Class source;
    private String tableName;
    private boolean clearLeno;

    public InitTableMaker(Class source) {
        this.source = source;
    }

    public InitTableMaker setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public InitTableMaker clearLeno() {
        this.clearLeno = true;
        return this;
    }

    public void ok() throws Exception {
        LenoTableMaker.run(source, tableName, clearLeno);
    }
}
