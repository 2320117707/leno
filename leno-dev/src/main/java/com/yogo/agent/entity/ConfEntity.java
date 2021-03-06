package com.yogo.agent.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @Author omg
 * @Date 2021-01-27 09:25:45
 * @Description 数据库配置实体
 **/
@Data
@Table(name = "conf")
public class ConfEntity {

    /**
     * 用户id
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    /**
     * 用户ID
     */
    private String user;

    /**
     * 数据库驱动
     */
    private String lib;

    /**
     * 数据库链接路径
     */
    @NotBlank(message = "请输入数据库连接")
    private String url;

    /**
     * 数据库用户名
     */
    @NotBlank(message = "请输入数据库用户名")
    private String username;

    /**
     * 数据库密码
     */
    @NotBlank(message = "请输入数据库密码")
    private String password;

    /**
     * 配置的应用状态
     */
    private Integer enable;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}