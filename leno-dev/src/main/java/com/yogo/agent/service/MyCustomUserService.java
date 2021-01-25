package com.yogo.agent.service;

import com.yogo.agent.common.enums.ExceptionEnum;
import com.yogo.agent.common.exceptions.YgException;
import com.yogo.agent.common.utils.BeanHelper;
import com.yogo.agent.entity.UserEntity;
import com.yogo.agent.mapper.UserMapper;
import com.yogo.agent.pojo.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 登录专用类,用户登陆时，通过这里查询数据库
 * 自定义类，实现了UserDetailsService接口，用户登录时调用的第一类
 *
 * @author cjrs
 * @date 2019年5月26日
 */
@Component
public class MyCustomUserService implements UserDetailsService {

    @Autowired
    private final UserMapper userMapper;

    public MyCustomUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 登陆验证时，通过username获取用户的所有权限信息
     * 并返回UserDetails放到spring的全局缓存SecurityContextHolder中，以供授权器使用
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userMapper.selByUserName(username);
        if (Objects.isNull(userEntity)){
            throw new YgException(ExceptionEnum.USER_NOT_EXIST);
        }
        MyUserDetails details = BeanHelper.copyProperties(userEntity, MyUserDetails.class);
        if (!username.equals(details.getUsername())) {
            throw new YgException(ExceptionEnum.USER_ID_NOT_EXIST);
        }
        return details;
    }
}