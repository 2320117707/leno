package com.yogo.agent.common.exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.stream.Collectors;

/**
 * @Author owen
 * @Date 2020/8/4
 * @Description 校验后返回错误信息
 **/
public class VerificationProcess {

    public static void revertMsg(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining("|"));
            throw new YgException(400, message);
        }
    }
}
