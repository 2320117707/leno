package com.yogo.agent.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author cjrs
 * @date 2019年6月8日
 */
@RestController
public class PageController {
    
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }
    /**
     * 自定义登录页面
     * @param error 错误信息显示标识
     * @return page
     *
     */
    @GetMapping("/login")
    public ModelAndView login(String error){
         ModelAndView modelAndView =  new ModelAndView("/login");
         modelAndView.addObject("error", error);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView toRegister(){
        return new ModelAndView("/register");
    }

}