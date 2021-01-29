package com.yogo.agent.common.enums;

import lombok.Getter;

/**
 * @Author owen
 * @Date 2020/9/19
 * @Description
 **/
@Getter
public enum ResultEnum {
    /**
     * 用户
     * 401 需要登录或者说没有通过认证
     * 403 没有权限，服务器受到请求但拒绝提供服务
     */
    NOT_LOGIN(401, "请登录后访问！"),
    USERNAME_EXISTS(401, "用户名已存在！"),
    ELSEWHERE(401, "您的账号已在别处登录!"),
    LOGIN_TOO_LONG(400, "长时间未操作,登录失效,请重新登录!"),
    LOGIN(200, "登录成功"),
    VERIFY_CODE_GOOD(200, "验证成功"),
    USER_NEGATION(400, "此手机号未注册"),
    USER_ALREADY_NEGATION(400, "此手机号已注册"),
    USER_CHANGE_PHONE_SUCCESS(200, "手机换绑成功"),
    REGISTER_SUCCESS(200, "注册成功"),
    VERIFY_FAILURE(400, "验证失效!"),
    LOGOUT(200, "退出成功"),
    CHANGE_PASSWORD_SUCCESS(200, "修改密码成功"),
    CREATE_LINK_SUCCESS(200, "创建链接成功"),
    LINK_LOSE_EFFICACY(400, "链接失效"),
    UNBOUND_HINT(200, "您已接受了其它代理商的邀请，请先解除绑定"),
    /**
     * 认证
     */
    FORBID(403, "权限不足无法访问！"),
    OK(200, "Success"),
    SERVER_ERROR(400, "服务异常！"),
    BECOME_PARTNER_FAIL(400, "提交申请失败,请确认信息是否有误!"),
    BECOME_PARTNER_SUCCESS(200, "提交申请成功,请耐心等待审核"),
    SAVE_OK(200, "添加成功"),
    CHOOSE_OK(200, "应用成功"),
    EDIT_OK(200, "编辑成功"),
    DEL_OK(200, "应用成功"),
    ;


    private int status;
    private String message;

    ResultEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
