package com.yogo.agent.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author owen
 * @Date 2021/2/1 15:54
 * @Description 生成实体类时接受前端参数
 **/
@Data
public class ModelDTO {
    @NotBlank(message = "请选择数据表名！")
    private String tableName;
    private String className;
    private Boolean isLombok;
}
