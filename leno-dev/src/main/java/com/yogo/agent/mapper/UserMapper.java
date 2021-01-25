package com.yogo.agent.mapper;

import com.yogo.agent.common.mapper.YgBaseMapper;
import com.yogo.agent.entity.UserEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author owen
 * @Date 2021/1/25 14:18
 * @Description
 **/
@Repository
public interface UserMapper extends YgBaseMapper<UserEntity> {
    @Select("select count(id) from user where username = #{username}")
    Integer selCountByUserName(String username);

    @Select("select * from user where username = #{username}")
    UserEntity selByUserName(String username);
}
