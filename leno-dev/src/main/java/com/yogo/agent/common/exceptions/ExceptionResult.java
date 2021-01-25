package com.yogo.agent.common.exceptions;

import lombok.Getter;

import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class ExceptionResult {
    private int status;
    private String message;
    private String timestamp;

    public ExceptionResult(YgException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public ExceptionResult(ConstraintViolationException e) {
        this.status = 400;
        this.message = e.getMessage().split(":")[1];
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
