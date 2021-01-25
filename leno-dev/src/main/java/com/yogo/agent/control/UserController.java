package com.yogo.agent.control;

import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.pattern.ResponseView;
import com.yogo.agent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotBlank;

/**
 * @author cjrs
 * @date 2019年6月8日
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final ResponseView responseView;

    @Autowired
    public UserController(UserService userService, ResponseView responseView) {
        this.userService = userService;
        this.responseView = responseView;
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam @NotBlank(message = "请输入用户名") String username,
            @RequestParam @NotBlank(message = "请输入密码") String password
    ) {
        return responseView.build(userService.register(username, password), "/register");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    /**
     * 自定义登录页面
     *
     * @param error 错误信息显示标识
     * @return page
     */
    @GetMapping("/login")
    public ModelAndView login(String error) {
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("error", error);
        return modelAndView;
    }


}