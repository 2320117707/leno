package com.yogo.agent.control;

import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.exceptions.VerificationProcess;
import com.yogo.agent.entity.ConfEntity;
import com.yogo.agent.pattern.ResponseView;
import com.yogo.agent.service.ConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @Author owen
 * @Date 2021/1/27 9:22
 * @Description
 **/
@Controller
@RequestMapping("/conf")
public class ConfController {

    private final ConfService confService;

    private final ResponseView responseView;

    @Autowired
    public ConfController(ConfService confService, ResponseView responseView) {
        this.confService = confService;
        this.responseView = responseView;
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultInfo addConf(
            @RequestBody @Valid ConfEntity conf, BindingResult bindingResult, Principal principal
    ) {
        VerificationProcess.revertMsg(bindingResult);
        return confService.addConf(conf, principal);
    }

    @GetMapping("/get")
    public String selConf(
            Principal principal, Model model
    ) {
        ResultInfo info = confService.selConf(principal);
        model.addAttribute("conf", info.getData());
        //局部刷新的语法。前面是html页面，后面是th:fragment的值
        return "index :: confList";
    }

    @PostMapping("/choose")
    @ResponseBody
    public ResultInfo chooseConf(
            Long id
    ) {

        return confService.chooseConf(id);
    }

    @PostMapping("/del")
    @ResponseBody
    public ResultInfo delConf(
            Long id
    ) {
        return confService.delConf(id);
    }


//    @PostMapping("/upd")
//    public ResultInfo updConf(
//            @RequestBody @Valid ConfEntity conf, BindingResult bindingResult, Principal principal
//    ) {
//        VerificationProcess.revertMsg(bindingResult);
//        return confService.addConf(conf,principal);
//    }
}
