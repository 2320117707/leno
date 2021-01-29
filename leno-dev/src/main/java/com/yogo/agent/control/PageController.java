package com.yogo.agent.control;

import com.yogo.agent.entity.ConfEntity;
import com.yogo.agent.mapper.ConfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * @author owen
 */
@RestController
public class PageController {

    private final ConfMapper confMapper;

    @Autowired
    public PageController(ConfMapper confMapper) {
        this.confMapper = confMapper;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 自定义登录页面
     *
     * @param error 错误信息显示标识
     * @return page
     */
    @GetMapping("/login")
    public ModelAndView login(String error) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", error);
        return modelAndView;
    }

    /**
     * 跳转到pojo页面
     *
     * @return
     */
    @GetMapping("/pojo")
    public ModelAndView toPojo(Principal principal) {
        ConfEntity conf = new ConfEntity();
        String name = principal.getName();
        conf.setUser(name);
        conf.setEnable(1);
        ConfEntity config = confMapper.selectOne(conf);
        ModelAndView modelAndView = new ModelAndView("pojo");
        modelAndView.addObject("conf", config);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView toRegister() {
        return new ModelAndView("register");
    }

}