package com.yogo.agent.service;

import com.alibaba.fastjson.JSON;
import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.enums.ResultEnum;
import com.yogo.agent.entity.ConfEntity;
import com.yogo.agent.mapper.ConfMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

/**
 * @Author owen
 * @Date 2021/1/25 14:19
 * @Description
 **/
@Slf4j
@Service
public class ConfService {

    private final ConfMapper confMapper;

    @Autowired
    public ConfService(ConfMapper confMapper) {
        this.confMapper = confMapper;
    }

    public ResultInfo addConf(ConfEntity conf, Principal principal) {
        conf.setUser(principal.getName());
        confMapper.insertSelective(conf);
        return ResultInfo.response(ResultEnum.SAVE_OK);
    }

    public ResultInfo editConf(ConfEntity conf, Principal principal) {
        conf.setUser(principal.getName());
        confMapper.updateByPrimaryKeySelective(conf);
        return ResultInfo.response(ResultEnum.EDIT_OK);
    }

    public ResultInfo selConf(Principal principal) {
        String name = principal.getName();
        List<ConfEntity> list = confMapper.selByUser(name);
        return ResultInfo.response(ResultEnum.OK, list);
    }


    public ResultInfo chooseConf(Long id) {
        synchronized (id.toString().intern()) {
            ConfEntity conf = confMapper.selectByPrimaryKey(id);
            String user = conf.getUser();
            confMapper.cancelUse(user, 1);
        }
        confMapper.chooseUse(id);
        return ResultInfo.response(ResultEnum.CHOOSE_OK);
    }

    public ResultInfo delConf(Long id) {
        confMapper.deleteByPrimaryKey(id);
        return ResultInfo.response(ResultEnum.DEL_OK);
    }


}
