package com.yogo.agent.common.exceptions;


import com.yogo.agent.common.enums.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YgException extends RuntimeException {
    private int status;

    public YgException(int status, String message){
        super(message);
        this.status = status;
    }
    public YgException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
    }


}
