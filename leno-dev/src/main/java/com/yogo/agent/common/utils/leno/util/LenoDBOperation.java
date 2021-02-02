package com.yogo.agent.common.utils.leno.util;


import com.yogo.agent.common.utils.leno.config.LenoDBProperties;
import com.yogo.agent.entity.ConfEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.*;


@Slf4j
@Component
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
    public static Connection getConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
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
     * @param sql  sql语句 "show create table mall_sku"
     * @param conf 数据库配置文件
     * @return String
     */
    public static String getTableStructure(String sql, ConfEntity conf) throws SQLException {
        String uri = conf.getUrl().trim();
        String url = "jdbc:mysql://" +  uri+ "/" + conf.getLib() + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        log.info("connection: " + url);
        Connection conn = getConnection(url, conf.getUsername(), conf.getPassword());
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


    public static boolean createTable(String sql) throws SQLException {
        Connection conn = getConnection(URL, USERNAME, PASSWORD);
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