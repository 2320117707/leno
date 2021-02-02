package com.yogo.agent.common.utils.leno.util;


import com.yogo.agent.common.utils.leno.config.Constant;

import java.io.File;
import java.io.FileWriter;
import java.net.URLDecoder;

/**
 * @Author dong
 * @Date 2020/11/10
 * @Description
 **/
public class LenoTownPortal {

    /**
     * 在aClass同文件下创建
     *
     * @param aClass
     * @param txt
     * @return
     * @throws Exception
     */
    public static String start(Class aClass, String txt) throws Exception {
        String className = parseFileName(txt);
        StringBuilder content = new StringBuilder(Constant.PACKAGE);
        String initFile = aClass.getResource(Constant.BLANK).getFile().substring(Constant.ONE).replaceFirst(Constant.TARGET_CLASSES, Constant.MUST_PATH);
        String packagePath = initFile.substring(initFile.indexOf(Constant.JAVA_GANG) + Constant.FIVE, initFile.length() - Constant.ONE);
        content.append(String.join(Constant.POINT, packagePath.split(Constant.GANG))).append(Constant.BRANCH).append(Constant.NN);
        content.append(txt);
        boolean isCreate = create(URLDecoder.decode(initFile, Constant.UTF8) + className, content.toString());
        String path = String.join(Constant.POINT, packagePath.split(Constant.GANG)) + Constant.POINT + className.split("\\.")[Constant.ZERO];
        return isCreate ? path : Constant.BLANK;
    }

    /**
     * 解析文件名称
     *
     * @param txt
     * @return
     */
    private static String parseFileName(String txt) {
        String result = null;
        String[] split = txt.split("\n");
        for (String section : split) {
            if (section.contains(Constant.CLASS_HEADER) || section.contains(Constant.INTERFACE_HEADER)) {
                result = section.split(Constant.SPACE)[Constant.TWO];
            }
        }
        return result + Constant.TYPE;
    }

    /**
     * 创建类
     *
     * @param validFile
     * @param txt
     * @return
     * @throws Exception
     */
    private static boolean create(String validFile, String txt) throws Exception {
        System.out.println("创建类的路径是: "+validFile);
        boolean result = false;
        File file = new File(validFile);
        if (!file.exists()) {
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(file);
                writer.write(txt);
                writer.close();
                result = true;
            }
        }
        return result;
    }

    public static String getPathByClass(Class c) {
        String className = c.getSimpleName() + Constant.TYPE;
        return (c.getResource(Constant.BLANK).getPath() + className).substring(Constant.ONE).replaceFirst(Constant.TARGET_CLASSES, Constant.MUST_PATH);
    }

    public static boolean delFile(String path) {
        File file = new File(path);
        return file.exists() && file.isFile() && file.delete();
    }

}
