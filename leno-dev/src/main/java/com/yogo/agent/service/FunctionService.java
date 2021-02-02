package com.yogo.agent.service;

import com.yogo.agent.common.utils.leno.config.Constant;
import com.yogo.agent.common.utils.leno.pojo.BeanInfo;
import com.yogo.agent.common.utils.leno.work.LenoBeanMaker;
import com.yogo.agent.dto.ModelDTO;
import com.yogo.agent.entity.ConfEntity;
import com.yogo.agent.mapper.ConfMapper;
import com.yogo.agent.odp.WangXiaoSong232;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * @Author owen
 * @Date 2021/2/1 15:57
 * @Description
 **/
@Slf4j
@Service
public class FunctionService {

    private final ConfMapper confMapper;

    @Autowired
    public FunctionService(ConfMapper confMapper) {
        this.confMapper = confMapper;
    }

    public BeanInfo pojoMaker(ModelDTO modelDTO, Principal principal) throws Exception {
        String name = principal.getName();
        BeanInfo info;
        synchronized (name.intern()) {
            ConfEntity config = confMapper.selMyConf(name);
            String tableName = modelDTO.getTableName();
            String className = modelDTO.getClassName();
            if (StringUtils.isBlank(className)) {
                className = LenoBeanMaker.underlineToHump(tableName).replaceFirst(Constant.START, String.valueOf(tableName.charAt(Constant.ZERO)).toUpperCase());
            }
            info = LenoBeanMaker.run(WangXiaoSong232.class, className, tableName, modelDTO.getIsLombok(), config);
        }
        return info;
    }
}
