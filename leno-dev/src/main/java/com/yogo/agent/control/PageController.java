package com.yogo.agent.control;

import com.yogo.agent.service.ConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author owen
 */
@RestController
public class PageController {


    private final ConfService confService;

    @Autowired
    public PageController(ConfService confService) {
        this.confService = confService;
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

    @GetMapping("/register")
    public ModelAndView toRegister() {
        return new ModelAndView("register");
    }

}