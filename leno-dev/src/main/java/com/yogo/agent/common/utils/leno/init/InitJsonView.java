package com.yogo.agent.common.utils.leno.init;


import com.yogo.agent.common.utils.leno.work.LenoJsonView;

/**
 * @Author owen
 * @Date 2020/11/9
 * @Description
 **/
public class InitJsonView {
    private Class source;

    public InitJsonView(Class source) {
        this.source = source;
    }

    public String ok() throws Exception {
        return LenoJsonView.classToJsonModel(source);
    }
}
