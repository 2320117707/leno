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

import javax.tools.*;
import javax.validation.Valid;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Principal;
import java.util.*;

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
        String ftp = (LenoTownPortal.start(Test.class, classTxt)) + ".java";
        if (ftp.equals(".java")) {
            ftp = jsonMap.get(principal.getName());
        }
        String[] split = ftp.split("\\.");
        String name = split[split.length - 2];
        String classPath = "D:\\project\\leno\\leno\\leno-dev\\target\\classes\\com\\yogo\\agent\\proxy\\";
        complie(classTxt, name, classPath);
        Class aClass = loadClass(new File(classPath));
        if (Objects.isNull(aClass)) {
            return ResultInfo.response(ResultEnum.SERVER_ERROR, null);
        }
        String result = LenoJsonView.classToJsonModel(aClass);
        jsonMap.put(principal.getName(), result);
        System.out.println("结果:" + result);
        return ResultInfo.response(ResultEnum.OK, result);
    }

    @GetMapping("/get/json")
    public String getJson(
            Principal principal, Model model
    ) {
        String txt = jsonMap.get(principal.getName());
        jsonMap.remove(principal.getName());
        model.addAttribute("jsonTxt", txt);

        return "json :: jsonTxt";
    }


    /**
     * @throws
     * @Title: complie
     * @Description: 动态编译java类成成class文件放入指定目录
     * @param: @param expr
     * @param: @param classPath
     * @param: @return
     * @param: @throws Exception
     */
    public static boolean complie(String source, String className, String classPath) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        StringSourceJavaObject sourceObject = null;
        try {
            Iterable<String> options = Arrays.asList("-d", classPath);
            sourceObject = new FunctionController.StringSourceJavaObject(className, source);
            Iterable<? extends JavaFileObject> fileObjects = Collections.singletonList(sourceObject);
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
            boolean result = task.call();
            return result;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static class StringSourceJavaObject extends SimpleJavaFileObject {

        private String content = null;

        public StringSourceJavaObject(String name, String content) throws URISyntaxException {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.content = content;
        }

        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return content;
        }
    }

    /**
     * @throws
     * @Title: loadClass
     * @Description: 动态加载class文件
     * @param: @param clazzPath
     * @param: @throws Exception
     * @return: void
     */
    public static Class loadClass(File clazzPath) throws Exception {
        // 设置class文件所在根路径
        // 例如/usr/java/classes下有一个test.App类，则/usr/java/classes即这个类的根路径，而.class文件的实际位置是/usr/java/classes/test/App.class
//		File clazzPath = new File(class文件所在根路径);

        // 记录加载.class文件的数量
        int clazzCount = 0;
        //only handle the folder
        if (clazzPath.isFile()) {
            clazzPath = clazzPath.getParentFile();
        }

        if (clazzPath.exists() && clazzPath.isDirectory()) {
            // 获取路径长度
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;

            Stack<File> stack = new Stack<>();
            stack.push(clazzPath);

            // 遍历类路径
            while (stack.isEmpty() == false) {
                File path = stack.pop();
                File[] classFiles = path.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith(".class"));
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        stack.push(subFile);
                    } else {
                        if (clazzCount++ == 0) {
                            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            boolean accessible = method.isAccessible();
                            try {
                                if (!accessible) {
                                    method.setAccessible(true);
                                }
                                // 设置类加载器
                                URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                                // 将当前类路径加入到类加载器中
                                method.invoke(classLoader, clazzPath.toURI().toURL());
                            } finally {
                                method.setAccessible(accessible);
                            }
                        }
                        // 文件名称
                        String className = subFile.getAbsolutePath();
                        className = className.substring(clazzPathLen, className.length() - 6);
                        className = className.replace(File.separatorChar, '.');
                        // 加载Class类
                        System.out.println(String.format("读取应用程序类文件[class=%s]", className));
                        return Class.forName(className);
                    }
                }
            }
        }
        return null;
    }
}
