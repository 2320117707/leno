package com.yogo.agent.service;

import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.enums.ResultEnum;
import com.yogo.agent.entity.UserEntity;
import com.yogo.agent.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author owen
 * @Date 2021/1/25 14:19
 * @Description
 **/
@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ResultInfo register(String username, String password) {
        if (userMapper.selCountByUserName(username) > 0) {
            return ResultInfo.response(ResultEnum.USERNAME_EXISTS);
        }
        UserEntity user = new UserEntity();
        user.setPassword(password);
        user.setUsername(username);
        int i = userMapper.insertSelective(user);
        return i > 0 ? ResultInfo.response(ResultEnum.REGISTER_SUCCESS) : ResultInfo.response(ResultEnum.BECOME_PARTNER_FAIL);
    }
}
