package com.ljy.sbtemplate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lokiy
 * @date 2019/2/15
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends Exception {

    private String errMsg;

    private String errCode;

    public BaseException(String errMsg){
        this.errCode = "-1";
        this.errMsg = errMsg;
    }

    @Override
    public String getMessage() {
        return this.errMsg;
    }
}
