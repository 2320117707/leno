package com.yogo.agent.control;

import com.yogo.agent.common.back.ResultInfo;
import com.yogo.agent.common.enums.ResultEnum;
import com.yogo.agent.common.exceptions.VerificationProcess;
import com.yogo.agent.common.utils.leno.pojo.BeanInfo;
import com.yogo.agent.common.utils.leno.util.LenoTownPortal;
import com.yogo.agent.common.utils.leno.work.LenoJsonView;
import com.yogo.agent.dto.ModelDTO;
import com.yogo.agent.proxy.Test;
import com.yogo.agent.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.validation.Valid;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.split;

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
    private static Map<String, String> jsonMap = new HashMap<>();

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

    @PostMapping("/json")
    @ResponseBody
    public ResultInfo makeJson(
            Principal principal, String classTxt
    ) throws Exception {
        System.out.println("得到的参数值是：" + classTxt);
        String ftp = (LenoTownPortal.start(Test.class, classTxt)) + ".java";
        if (ftp.equals(".java")) {
            ftp = jsonMap.get(principal.getName());
        }
        jsonMap.put(principal.getName(), ftp);
        return ResultInfo.response(ResultEnum.OK, ftp);
    }

    @GetMapping("/get/json")
    public String getJson(
            Principal principal, Model model
    ) {
        String ftp = jsonMap.get(principal.getName());
        String s1 = null;
        try {
            System.out.println("截取前是：" + ftp);
            String[] split = ftp.split("\\.");
            String s = split[split.length - 2];
            System.out.println("截取的name值是:" + s);
            String un = "D:/WorkSpace/Project/leno/leno-dev/src/main/java/com/yogo/agent/proxy/" + s + ".java";
            System.out.println("un : " + un);

            // compile下面开始编译这个Store.java
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            int result = compiler.run(null, null, null, un);
            System.out.println(result==0?"成功":"失败");
            URL[] urls = new URL[]{new URL("file:/"+ System.getProperty("user.dir") + "/leno-dev/src/main/java/com/yogo/agent/proxy/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class<?> aClass = loader.loadClass(s);
            System.out.println("class:"+aClass);
//            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
//
//            Iterable units = fileMgr.getJavaFileObjects(un);
//
//            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,
//                    units);
//
//            t.call();
//
//            fileMgr.close();
//            // load into memory and create an instance
//            URL[] urls = new URL[]{new URL("file:/"
//                    + System.getProperty("user.dir") + "/leno-dev/src")};
//            URLClassLoader ul = new URLClassLoader(urls);
//            Class c = ul.loadClass("com.yogo.agent.proxy." + s);
//            System.out.println(c);
//
//            s1 = LenoJsonView.classToJsonModel(c);
//            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("jsonTxt", s1);
        return "json :: jsonTxt";
    }

}
