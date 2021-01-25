package com.yogo.agent.common.utils.leno.work;


import com.yogo.agent.common.utils.leno.config.Constant;
import com.yogo.agent.common.utils.leno.util.LenoTownPortal;

/**
 * @Author owen & dong
 * @Date 2020/11/10
 * @Description
 **/
public class LenoClassMaker {

    /**
     * 生成tkMapper的方法
     *
     * @param beanPath   实体类导包路径
     * @param guideClass 引导类(放在哪里)
     * @return
     * @throws Exception
     */
    public static void genericFrame(String beanPath, Class guideClass) throws Exception {
        String[] split = beanPath.split("\\.");
        String className = split[split.length - Constant.ONE];
        String name = classNameFilter(className);

        //拼接Mapper类
        String mapperName = name + Constant.MAPPER;
        String mapper = Constant.IMPORT + beanPath + Constant.BRANCH + Constant.N + Constant.TK_MAPPER_JAR
                + Constant.REMARK + Constant.MAPPER_CLASS_HEADER
                + mapperName + Constant.SPACE + Constant.EXTENDS + Constant.SPACE
                + Constant.MAPPER + Constant.ANGLE_BRACKETS_OPEN + className + Constant.ANGLE_BRACKETS_CLOSE
                + Constant.SPACE_BRACE + Constant.NN + Constant.BRACE_CLOSE;
        String mapperPath = LenoTownPortal.start(guideClass, mapper);
        System.out.println("mapper的路径" + mapperPath);

        //拼接Service类
        String serviceName = name + Constant.SERVICE;
        String service = Constant.AUTOWIRED + Constant.SERVICE_JAR + Constant.REMARK + Constant.SERVICE_CLASS_HEADER
                + serviceName + Constant.SPACE_BRACE + Constant.NNT
                + Constant.AUTOWIRED_REMARK + Constant.NT
                + Constant.PRIVATE + mapperName + Constant.SPACE + firstLetterToLow(mapperName) + Constant.BRANCH
                + Constant.NN + Constant.BRACE_CLOSE;
        String servicePath = LenoTownPortal.start(guideClass, service);
        System.out.println("service的路径" + servicePath);

        //拼接Controller类
        String controller = Constant.AUTOWIRED + Constant.CONTROLLER_JAR + Constant.REMARK + Constant.CONTROLLER_CLASS_HEADER
                + name + Constant.CONTROLLER + Constant.SPACE_BRACE + Constant.NNT
                + Constant.AUTOWIRED_REMARK + Constant.NT
                + Constant.PRIVATE + serviceName + Constant.SPACE + firstLetterToLow(serviceName) + Constant.BRANCH
                + Constant.NN + Constant.BRACE_CLOSE;
        String controllerPath = LenoTownPortal.start(guideClass, controller);
        System.out.println("service的路径" + controllerPath);
    }

    /**
     * 处理名字后面的Entity,Entry,DTO
     *
     * @param className
     * @return
     */
    private static String classNameFilter(String className) {
        String receive = className;
        if (className.toUpperCase().endsWith(Constant.ENTRY_UP)) {
            receive = className.split(Constant.ENTRY_LOW)[Constant.ZERO];
        }
        if (className.toUpperCase().endsWith(Constant.DTO_UP)) {
            String[] split = className.split(Constant.DTO_UP);
            receive = split[Constant.ZERO];
            if (split.length == Constant.ONE) {
                receive = className.split(Constant.DTO_LOW)[Constant.ZERO];
            }
        }
        if (className.toUpperCase().endsWith(Constant.ENTITY_UP)) {
            receive = className.split(Constant.ENTITY_LOW)[Constant.ZERO];
        }
        return receive;
    }

    /**
     * 首字母小写
     *
     * @return
     */
    public static String firstLetterToLow(String name) {
        return name.replaceFirst(Constant.START, name.substring(Constant.ZERO, Constant.ONE).toLowerCase());
    }

}
