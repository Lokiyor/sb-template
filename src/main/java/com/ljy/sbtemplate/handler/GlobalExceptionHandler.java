package com.ljy.sbtemplate.handler;


import com.ljy.sbtemplate.exception.BusinessException;
import com.ljy.sbtemplate.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lokiy
 * @date 2018/6/20
 * @description 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonResult globalException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ex.printStackTrace();

        return JsonResult.error("9999", "XXXX发生异常");


    }

//    @ExceptionHandler(value = HrException.class)
//    public void hrException(HttpServletRequest request, HttpServletResponse response, HrException ex){
//
//    }


    @ExceptionHandler(value = BusinessException.class)
    public JsonResult businessException(HttpServletRequest request, HttpServletResponse response, BusinessException ex) {
        return JsonResult.error(ex.getErrCode(), ex.getErrMsg());

    }


}
