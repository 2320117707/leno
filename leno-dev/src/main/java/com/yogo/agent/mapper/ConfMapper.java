package com.yogo.agent.mapper;

import com.yogo.agent.common.mapper.YgBaseMapper;
import com.yogo.agent.entity.ConfEntity;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author owen
 * @Date 2021/1/25 14:18
 * @Description
 **/
@Repository
public interface ConfMapper extends YgBaseMapper<ConfEntity> {

    @Select("select * from conf where user = #{name} order by create_time asc")
    List<ConfEntity> selByUser(String name);

    @Update("update conf set enable = 0 where user =#{user} and enable = #{i}")
    void cancelUse(String user, int i);

    @Update("update conf set enable = 1 where id = #{id}")
    void chooseUse(Long id);
}
