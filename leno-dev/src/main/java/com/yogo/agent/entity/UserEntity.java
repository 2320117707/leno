package com.yogo.agent.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author 董乙辰
 * @Date 2021/1/25 14:11
 * @Description
 **/
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String id;
    private String username;
    private String password;
    private String phone;
    private String create_time;
    private String update_time;
}
