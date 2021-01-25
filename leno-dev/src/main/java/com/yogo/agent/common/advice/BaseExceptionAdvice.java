package com.yogo.agent.common.advice;


import com.yogo.agent.common.exceptions.ExceptionResult;
import com.yogo.agent.common.exceptions.YgException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * 所有的Controller都会进入到这个类
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionAdvice {
    //指定处理的异常类型
    @ExceptionHandler(YgException.class)
    public ResponseEntity<ExceptionResult> handleException(YgException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResult(e));
    }

    //指定处理的异常类型
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResult> handleException(ConstraintViolationException e) {
        log.info("校验ver异常被捕获" + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResult(e));
    }

}
