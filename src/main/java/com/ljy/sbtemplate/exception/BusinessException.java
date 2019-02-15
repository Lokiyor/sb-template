package com.ljy.sbtemplate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * @author Lokiy
 * @date 2019/2/15
 * @description  业务级异常 继承自运行时异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private String errMsg;

    private String errCode;

    public BusinessException(String errMsg){
        this.errCode = "-1";
        this.errMsg = errMsg;
    }

    public BusinessException(String errorCode, MessageSource messageSource, Object... params) {
        this.errCode = errorCode;
        String errorMsg = messageSource.getMessage(errorCode, params, errorCode, Locale.SIMPLIFIED_CHINESE);
    }

    public BusinessException(String flowCreateFormError, Object obj) {
        super(obj.toString());
    }

    @Override
    public String getMessage() {
        return this.errMsg;
    }
}
