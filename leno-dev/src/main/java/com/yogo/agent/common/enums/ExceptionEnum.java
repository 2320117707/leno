package com.yogo.agent.common.enums;

import lombok.Getter;

/**
 * @Author Owen
 * @Description 异常枚举类
 */
@Getter
public enum ExceptionEnum {

    /**
     * 通用
     */
    INVALID_PARAM_ERROR(400, "无效的请求参数！"),
    INVALID_FILE_TYPE(400, "无效的文件类型！"),
    DATA_TRANSFER_ERROR(500, "数据转换异常！"),
    NOT_ALLOW(403, " "),
    FORBIDDEN(403, "没有此权限访问！"),
    INSERT_FAIL(500, "保存失败！"),
    UPDATE_FAIL(500, "更新失败！"),
    DELETE_FAIL(500, "删除失败！"),
    CREATE_LINK_FAILURE(500, "创建链接失败"),

    /**
     * 用户
     */
    USER_NAME_EXIST(401, "用户名已存在"),
    USER_PHONE_EXIST(420, "手机号已存在"),
    USER_ID_NOT_EXIST(403, "用户不存在"),
    USER_NOT_EXIST(400, "用户不存在"),
    INVALID_USERNAME_PASSWORD(400, "无效的用户名或密码不正确！"),
    USER_PASSWORD_ERROR(400, "密码错误"),
    USER_CHANGE_FAILURE(400, "修改失败"),
    USER_FREEZE(500, "冻结的用户"),
    UNAUTHORIZED(401, "登录失效或未登录！"),
    USER_WECHAT_EREPETITION_BINDING(502, "已是绑定状态"),
    USER_WECHAT_EXIST_BINDING(421, "手机号已被其他用户绑定"),
    USER_BINDING_FAILURE(501, "绑定失败"),
    USER_EMAIL_EXIST_DINDING(422, "邮箱已被其他用户绑定"),
    USER_VERIFY_CODE_OUT_TIME(410, "验证码已过期！"),
    INVALID_VERIFY_CODE(410, "验证码错误！"),
    USER_DONT_CHANGE_JURISDICTION(400, "用户没有修改权限"),
    USER_BINGING_OUT_TIME(430, "换绑超时"),
    USER_CHANGE_NAME_SAME(402, "修改的用户名和原名相同"),
    /**
     * 图片上传
     */
    IMAGE_CAN_NOT_BE_NULL(400, "请选择图片进行上传"),
    UPLOAD_FAIL(400, "图片上传失败"),
    IMAGE_TOO_BIG(400, "图片大小不能超过3M"),
    ;

    private int status;
    private String message;

    ExceptionEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
