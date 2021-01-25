package com.yogo.agent.common.utils.leno.test;


import com.yogo.agent.common.utils.leno.control.LenoControl;

/**
 * @Author owen
 * @Date 2020/11/10
 * @Description
 **/
public class LenoTest {
    public static void main(String[] args) throws Exception {
//        LenoControl.tableMaker(MallUser.class)
//                .setTableName("agent_user")
//                .clearLeno()
//                .ok();
        LenoControl.beanMaker(MallUser.class, "yg_user")
                .setClassName("ConsoleUser")
                .lombok()
                .ok();
    }


}
