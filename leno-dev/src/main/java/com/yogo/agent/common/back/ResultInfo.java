package com.yogo.agent.common.back;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yogo.agent.common.enums.ResultEnum;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @Author Owen
 * @Date 2018/8/29
 * @description 返回结果VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResultInfo<T> implements Serializable {

    private Integer status;

    private String message;

    private ResultEnum info;

    private T data;

    private String timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");

     private ResultInfo(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private ResultInfo(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private ResultInfo(ResultEnum info, T data) {
        this.status = info.getStatus();
        this.message = info.getMessage();
        this.data = data;
    }

    public static <T> ResultInfo response(ResultEnum info, T data) {
        return new ResultInfo(info, data);
    }

    public static <T> ResultInfo response(ResultEnum info) {
        return new ResultInfo(info.getStatus(), info.getMessage());
    }

    /**
     * 请求成功  状态码 1
     *
     * @param message 返回信息
     * @param <T> 类型
     * @return ResultInfo
     */
    public static <T> ResultInfo getSuccess(String message) {
        return new ResultInfo(200, message);
    }

    /**
     * 请求成功  状态码 1
     *
     * @param message  返回信息
     * @param data 返回对象
     * @param <T>  类型
     * @return ResultInfo
     */
    public static <T> ResultInfo getSuccess(String message, T data) {
        return new ResultInfo(200, message, data);
    }



    /**
     * 请求失败   状态码 0
     *
     * @param message 返回信息
     * @return ResultInfo
     */
    public static ResultInfo getFailed(String message) {
        return new ResultInfo(400, message);
    }

    /**
     * 请求失败  状态 0
     *
     * @param message  返回信息
     * @param data 返回数据
     * @param <T>  类型
     * @return ResultInfo
     */
    public static <T> ResultInfo getFailed(String message, T data) {
        return new ResultInfo(400, message, data);
    }


}