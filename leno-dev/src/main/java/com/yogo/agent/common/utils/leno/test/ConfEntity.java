package com.yogo.agent.common.utils.leno.test;

import java.util.Date;

import lombok.Data;

/**
 * @Author 
 * @Date 2021-02-01 11:17:31
 * @Description
 **/
@Data
public class ConfEntity {

	/**
	 * 主键
	 */
	 private Integer id;

	/**
	 * 用户
	 */
	 private String user;

	/**
	 * 数据库名称
	 */
	 private String lib;

	/**
	 * 数据库链接路径
	 */
	 private String url;

	/**
	 * 数据库用户名
	 */
	 private String username;

	/**
	 * 数据库密码
	 */
	 private String password;

	/**
	 * 应用状态
	 */
	 private Integer enable;

	/**
	 * 创建时间
	 */
	 private Date createTime;

	/**
	 * 更新时间
	 */
	 private Date updateTime;
}