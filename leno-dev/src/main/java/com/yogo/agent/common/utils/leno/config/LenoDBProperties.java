package com.yogo.agent.common.utils.leno.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author owen
 * @Date 2020/11/9
 * @Description todo 用户配置数据库信息区域(使用Leno之前请先配置此信息, 否则无效)
 **/
public class LenoDBProperties {
    protected final static Logger LOGGER = LoggerFactory.getLogger(LenoDBProperties.class);
    protected static final String DRIVER = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://39.105.153.98:3306/YoGo1.1?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "YoGoYun.com";
}
