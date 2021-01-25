package com.yogo.agent.pattern;

import com.yogo.agent.common.back.ResultInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * @Author owen
 * @Date 2021/1/25 16:09
 * @Description
 **/
@Component
public class ResponseView {

    public ModelAndView build(ResultInfo info, String url) {
        ModelAndView mv = new ModelAndView(url);
        mv.addObject("message", info.getMessage());
        mv.addObject("status", info.getStatus());
        mv.addObject("timestamp", info.getStatus());
        Object data = info.getData();
        if (Objects.nonNull(data)) {
            mv.addObject("data", data);
        }
        return mv;
    }
}
