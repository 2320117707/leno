package com.yogo.agent.service;

import com.alibaba.fastjson.JSON;
import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.enums.ResultEnum;
import com.yogo.agent.common.utils.leno.util.LenoDBOperation;
import com.yogo.agent.entity.ConfEntity;
import com.yogo.agent.mapper.ConfMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author owen
 * @Date 2021/1/25 14:19
 * @Description
 **/
@Slf4j
@Service
public class ConfService extends LenoDBOperation {

    private final ConfMapper confMapper;

    @Autowired
    public ConfService(ConfMapper confMapper) {
        this.confMapper = confMapper;
    }

    public ResultInfo addConf(ConfEntity conf, Principal principal) {
        String name = principal.getName();
        List<ConfEntity> list = confMapper.selByUser(name);
        if (list.isEmpty()) {
            conf.setEnable(1);
        }
        conf.setUser(name);
        confMapper.insertSelective(conf);
        return ResultInfo.response(ResultEnum.SAVE_OK);
    }

    public ResultInfo editConf(ConfEntity conf, Principal principal) {
        conf.setUser(principal.getName());
        confMapper.updateByPrimaryKeySelective(conf);
        return ResultInfo.response(ResultEnum.EDIT_OK);
    }

    public ResultInfo testConf(ConfEntity conf) {
        try {
            synchronized (conf.getId()) {
                String uri = conf.getUrl().trim();
                String url = "jdbc:mysql://" +  uri+ "/" + conf.getLib() + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
                log.info("connection: " + url);
                getConnection(url, conf.getUsername(), conf.getPassword());
            }
            return ResultInfo.response(ResultEnum.CONN_OK);
        } catch (Exception e) {
            log.info("连接失败" + e.getMessage());
            return ResultInfo.response(ResultEnum.CONN_ERROR);
        }
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
        ConfEntity config = confMapper.selectByPrimaryKey(id);
        Integer status = config.getEnable();
        if (status == 1) {
            return ResultInfo.response(ResultEnum.CAN_NOT_DELETE);
        }
        confMapper.deleteByPrimaryKey(id);
        return ResultInfo.response(ResultEnum.DEL_OK);
    }


    public List<String> getTable(ConfEntity conf) {
        if (Objects.isNull(conf)) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        synchronized (conf.getId()) {
            String uri = conf.getUrl().trim();
            String url = "jdbc:mysql://" +  uri+ "/" + conf.getLib() + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            log.info("connection: " + url);
            try (Connection conn = getConnection(url, conf.getUsername(), conf.getPassword())) {
                ResultSet rs = conn.getMetaData().getTables(conn.getCatalog(), conf.getLib(), "%", new String[]{"TABLE"});
                while (rs.next()) {
                    String table = rs.getString("TABLE_NAME");
                    list.add(table);
                }
                return list;
            } catch (Exception e) {
                log.error(e.getMessage());
                return new ArrayList<>();
            }
        }
    }

}
