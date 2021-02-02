package com.yogo.agent.proxy;

import com.yogo.agent.common.utils.leno.util.LenoTownPortal;
import com.yogo.agent.common.utils.leno.work.LenoJsonView;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.net.URL;
import java.net.URLClassLoader;


public class Test {
    public static void main(String[] args) {
        try {

            String ftp = "D:/WorkSpace/Project/leno/leno-dev/src/main/java/com/yogo/agent/proxy/AgentGrade.java";

            // compile下面开始编译这个Store.java
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
                    null, null);

            Iterable units = fileMgr.getJavaFileObjects(ftp);
            CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,
                    units);
            t.call();
            fileMgr.close();

            // load into memory and create an instance
            URL[] urls = new URL[]{new URL("file:/"
                    + System.getProperty("user.dir") + "/src")};
            URLClassLoader ul = new URLClassLoader(urls);
            Class c = ul.loadClass("com.yogo.agent.proxy.AgentGrade");
            System.out.println(c);

            String s1 = LenoJsonView.classToJsonModel(c);
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String content = "import java.util.Date;\n" +
            "\n" +
            "/**\n" +
            " * @Author \n" +
            " * @Date 2021-02-01 18:31:23\n" +
            " * @Description\n" +
            " **/\n" +
            "public class AgentLicence {\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-执照id自增\n" +
            "\t */\n" +
            "\t private Integer licenceId;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-图片地址 建议尺寸600*800\n" +
            "\t */\n" +
            "\t private String licencePath;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-黑龙江沙果科技有限公司\n" +
            "\t */\n" +
            "\t private String licenceName;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-成立日期\n" +
            "\t */\n" +
            "\t private String licenceDateStart;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-法人\n" +
            "\t */\n" +
            "\t private String licenceLegal;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-营业执照号码\n" +
            "\t */\n" +
            "\t private String licenceNum;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-营业期限-至长期\n" +
            "\t */\n" +
            "\t private String licenceTerm;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-营业执照号码类型\n" +
            "\t */\n" +
            "\t private String licenceType;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 营业执照信息-企业所在地(公司注册省市)\n" +
            "\t */\n" +
            "\t private String licenceAddr;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-主营业务-软件开发\n" +
            "\t */\n" +
            "\t private String workMainCore;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-覆盖行业-零售/实体零售与批发\n" +
            "\t */\n" +
            "\t private String workCoverIndustry;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-覆盖区域\n" +
            "\t */\n" +
            "\t private String workCoverArea;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-申请来源\n" +
            "\t */\n" +
            "\t private String workApplyOrigin;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-业绩目标\n" +
            "\t */\n" +
            "\t private String workKPI;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-公司网址\n" +
            "\t */\n" +
            "\t private String workWebsite;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司业务信息-公司logo\n" +
            "\t */\n" +
            "\t private String workLogo;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司人员信息-公司在职人员人数\n" +
            "\t */\n" +
            "\t private Integer infoStaff;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司人员信息-联系人\n" +
            "\t */\n" +
            "\t private String infoContacts;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司人员信息-联系人邮箱\n" +
            "\t */\n" +
            "\t private String infoEmail;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司人员信息-联系人手机号\n" +
            "\t */\n" +
            "\t private String infoPhone;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 公司人员信息-公司技术团队人数\n" +
            "\t */\n" +
            "\t private String infoTeam;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 认证状态 0未认证 1已认证 2审核中 -1认证失败\n" +
            "\t */\n" +
            "\t private String status;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 代理id.agent_user.id\n" +
            "\t */\n" +
            "\t private Integer agentUid;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 申请时间\n" +
            "\t */\n" +
            "\t private Date createTime;\n" +
            "\n" +
            "\t/**\n" +
            "\t * 申请通过时间\n" +
            "\t */\n" +
            "\t private Date updateTime;\n" +
            "\n" +
            "\t\n" +
            "\n" +
            "\tpublic Integer getLicenceId() {\n" +
            "\t\treturn licenceId;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceId(Integer licenceId) {\n" +
            "\t\tthis.licenceId = licenceId;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicencePath() {\n" +
            "\t\treturn licencePath;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicencePath(String licencePath) {\n" +
            "\t\tthis.licencePath = licencePath;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceName() {\n" +
            "\t\treturn licenceName;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceName(String licenceName) {\n" +
            "\t\tthis.licenceName = licenceName;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceDateStart() {\n" +
            "\t\treturn licenceDateStart;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceDateStart(String licenceDateStart) {\n" +
            "\t\tthis.licenceDateStart = licenceDateStart;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceLegal() {\n" +
            "\t\treturn licenceLegal;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceLegal(String licenceLegal) {\n" +
            "\t\tthis.licenceLegal = licenceLegal;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceNum() {\n" +
            "\t\treturn licenceNum;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceNum(String licenceNum) {\n" +
            "\t\tthis.licenceNum = licenceNum;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceTerm() {\n" +
            "\t\treturn licenceTerm;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceTerm(String licenceTerm) {\n" +
            "\t\tthis.licenceTerm = licenceTerm;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceType() {\n" +
            "\t\treturn licenceType;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceType(String licenceType) {\n" +
            "\t\tthis.licenceType = licenceType;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getLicenceAddr() {\n" +
            "\t\treturn licenceAddr;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setLicenceAddr(String licenceAddr) {\n" +
            "\t\tthis.licenceAddr = licenceAddr;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkMainCore() {\n" +
            "\t\treturn workMainCore;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkMainCore(String workMainCore) {\n" +
            "\t\tthis.workMainCore = workMainCore;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkCoverIndustry() {\n" +
            "\t\treturn workCoverIndustry;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkCoverIndustry(String workCoverIndustry) {\n" +
            "\t\tthis.workCoverIndustry = workCoverIndustry;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkCoverArea() {\n" +
            "\t\treturn workCoverArea;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkCoverArea(String workCoverArea) {\n" +
            "\t\tthis.workCoverArea = workCoverArea;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkApplyOrigin() {\n" +
            "\t\treturn workApplyOrigin;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkApplyOrigin(String workApplyOrigin) {\n" +
            "\t\tthis.workApplyOrigin = workApplyOrigin;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkKPI() {\n" +
            "\t\treturn workKPI;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkKPI(String workKPI) {\n" +
            "\t\tthis.workKPI = workKPI;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkWebsite() {\n" +
            "\t\treturn workWebsite;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkWebsite(String workWebsite) {\n" +
            "\t\tthis.workWebsite = workWebsite;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getWorkLogo() {\n" +
            "\t\treturn workLogo;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setWorkLogo(String workLogo) {\n" +
            "\t\tthis.workLogo = workLogo;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic Integer getInfoStaff() {\n" +
            "\t\treturn infoStaff;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setInfoStaff(Integer infoStaff) {\n" +
            "\t\tthis.infoStaff = infoStaff;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getInfoContacts() {\n" +
            "\t\treturn infoContacts;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setInfoContacts(String infoContacts) {\n" +
            "\t\tthis.infoContacts = infoContacts;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getInfoEmail() {\n" +
            "\t\treturn infoEmail;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setInfoEmail(String infoEmail) {\n" +
            "\t\tthis.infoEmail = infoEmail;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getInfoPhone() {\n" +
            "\t\treturn infoPhone;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setInfoPhone(String infoPhone) {\n" +
            "\t\tthis.infoPhone = infoPhone;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getInfoTeam() {\n" +
            "\t\treturn infoTeam;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setInfoTeam(String infoTeam) {\n" +
            "\t\tthis.infoTeam = infoTeam;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic String getStatus() {\n" +
            "\t\treturn status;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setStatus(String status) {\n" +
            "\t\tthis.status = status;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic Integer getAgentUid() {\n" +
            "\t\treturn agentUid;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setAgentUid(Integer agentUid) {\n" +
            "\t\tthis.agentUid = agentUid;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic Date getCreateTime() {\n" +
            "\t\treturn createTime;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setCreateTime(Date createTime) {\n" +
            "\t\tthis.createTime = createTime;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic Date getUpdateTime() {\n" +
            "\t\treturn updateTime;\n" +
            "\t}\n" +
            "\n" +
            "\tpublic void setUpdateTime(Date updateTime) {\n" +
            "\t\tthis.updateTime = updateTime;\n" +
            "\t}\n" +
            "\n" +
            "}";
}