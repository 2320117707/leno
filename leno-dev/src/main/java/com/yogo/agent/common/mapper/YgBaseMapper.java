package com.yogo.agent.common.mapper;


import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;


public interface YgBaseMapper<T> extends Mapper<T>, IdsMapper, IdListMapper<T,Long>, InsertListMapper<T> {

}
