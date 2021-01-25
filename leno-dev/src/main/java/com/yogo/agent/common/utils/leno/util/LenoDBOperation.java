package com.yogo.agent.common.utils.leno.util;


import com.yogo.agent.common.utils.leno.config.LenoDBProperties;

import java.sql.*;


public class LenoDBOperation extends LenoDBProperties {

    private static final String TABLE_STRUCTURE_INFO_NAME = "Create Table";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    private static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }


    /**
     * 获取表结构数据根据sql语句
     *
     * @param sql sql语句 "show create table mall_sku"
     * @return String
     */
    public static String getTableStructure(String sql) {
        Connection conn = getConnection();
        Statement statement = null;
        String result = "";
        try {
            statement = conn.createStatement();
            //结果集元数据
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = rs.getString(TABLE_STRUCTURE_INFO_NAME);
            } else {
                LOGGER.error("拉取数据库表结构信息失败");
            }
        } catch (SQLException e) {
            LOGGER.error("拉取数据库表结构信息失败", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("关闭数据库连接失败", e);
                }
            }
        }
        return result;
    }

    public static boolean createTable(String sql) {
        Connection conn = getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            //结构
            statement.execute(sql);
            LOGGER.info("创建成功");
            return true;
        } catch (Exception e) {
            LOGGER.error("创建失败-->原因:" + e.getMessage());
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("关闭数据库连接失败", e);
                }
            }
        }
    }
}