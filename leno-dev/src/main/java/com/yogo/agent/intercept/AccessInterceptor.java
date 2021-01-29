package com.yogo.agent.intercept;

import com.alibaba.fastjson.JSON;
import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

/**
 * 访问拦截器
 */
@Component
@Slf4j
public class AccessInterceptor implements HandlerInterceptor {

    /**
     * 请求访问拦截器
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理
     * @return boolean类型
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Principal principal = request.getUserPrincipal();
        String name = principal.getName();
        if (StringUtils.isNotBlank(name)) {
            return true;
        }
        log.error("401 未登录 无法访问！");
        response(response, ResultInfo.response(ResultEnum.NOT_LOGIN));
        return false;
    }

    /**
     * 生成响应信息
     *
     * @param response 响应
     * @param info     信息
     */
    private void response(HttpServletResponse response, ResultInfo info) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSON.toJSONString(info));
        } catch (IOException e) {
            log.error("拦截器输出流关闭异常" + e.getMessage());
        }
    }
}