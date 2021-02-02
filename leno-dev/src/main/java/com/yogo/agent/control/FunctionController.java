package com.yogo.agent.control;

import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.enums.ResultEnum;
import com.yogo.agent.common.exceptions.VerificationProcess;
import com.yogo.agent.common.utils.leno.pojo.BeanInfo;
import com.yogo.agent.dto.ModelDTO;
import com.yogo.agent.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author owen
 * @Date 2021/2/1 15:50
 * @Description lenoCommon
 **/
@Controller
@RequestMapping("/maker")
public class FunctionController {

    private final FunctionService functionService;

    private static Map<String, BeanInfo> map = new HashMap<>();

    @Autowired
    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }


    @PostMapping("/pojo")
    @ResponseBody
    public ResultInfo makeBean(
            @RequestBody @Valid ModelDTO modelDTO, BindingResult bindingResult, Principal principal
    ) throws Exception {
        VerificationProcess.revertMsg(bindingResult);
        BeanInfo beanInfo = functionService.pojoMaker(modelDTO, principal);
        map.put(principal.getName() + modelDTO.getTableName(), beanInfo);
        return ResultInfo.response(ResultEnum.OK, beanInfo);
    }


    @GetMapping("/get/bean")
    public String getBean(
            Principal principal, Model model, String tableName
    ) {
        BeanInfo info = map.get(principal.getName() + tableName);
        model.addAttribute("javaClass", info.getBeanContent());
        return "pojo :: classTxt";
    }

}
