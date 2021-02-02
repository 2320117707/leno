package com.yogo.agent.odp;

import com.yogo.agent.common.utils.leno.util.LenoTownPortal;
import com.yogo.agent.proxy.Test;

/**
 * @Author owen
 * @Date 2021/2/1 16:01
 * @Description
 **/
public class WangXiaoSong232 {

    public static void main(String[] args) throws Exception {
        String path = LenoTownPortal.start(Test.class, Test.content);
        String ftp = (path + ".java");
        System.out.println(ftp);
    }
}
