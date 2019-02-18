package com.ljy.sbtemplate.util;

import com.ljy.sbtemplate.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;


/**
 * 业务异常类
 */
public abstract class Assert {

    /**
     * 断言对象不为空,若对象为空则报异常
     * @param obj 待校验对象
     * @param message 异常信息
     */
    public static void notNull(Object obj,String message) throws BusinessException {
        if(obj == null){
            throw new BusinessException(ErrorCode.OBJECT_IS_NULL.getCode(),message);
        }
    }
    
    /**
     * 断言对象不为空,若对象为空则报异常
     * @param obj 待校验对象
     */
    public static void notNull(Object obj) throws BusinessException {
        Assert.notNull(obj, "The Object can't null");
    }
    
    /**
     * 断言数字不能为零，若数字为零则报异常
     * @param num 待校验数字
     * @param message 异常信息
     */
    public static void notZero(Integer num,String message) throws BusinessException {
        Assert.notNull(num);
        if(num.intValue() == 0){
            throw new BusinessException(message);
        }
    }
    
    /**
     * 断言数字不能为零，若数字为零则报异常
     * @param num 待校验数字
     */
    public static void notZero(Integer num) throws BusinessException {
        Assert.notZero(num,"The number can't equals zero");
    }
    
    /**
     * 断言字符串不能为空，若字符串为空则报异常
     * @param string 待校验字符串
     * @param message 异常信息
     */
    public static void notEmpty(String string,String message) throws BusinessException {
        if(StringUtils.isEmpty(string)) {
            throw new BusinessException(ErrorCode.DATA_NO_FOUND.getCode(), message);
        }
    }
    
    /**
     * 断言字符串不能为空，若字符串为空则报异常
     * @param string 待校验字符串
     */
    public static void notEmpty(String string) throws BusinessException {
        Assert.notEmpty(string,"The string can't empty");
    }
    
    /**
     * 断言该布尔值为true，若为false则抛异常
     * @param expression 待校验布尔值
     * @param message  异常信息
     */
    public static void isTrue(boolean expression,String message) throws BusinessException {
        if(!expression) {
            throw new BusinessException(ErrorCode.DATA_NO_FOUND.getCode(),  message);
        }
    }

    /**
     * 断言该布尔值为true，若为false则抛异常 并给出一个异常码
     * @param expression 待校验布尔值
     * @param message  异常信息
     */
    public static void isTrue(boolean expression,String errorCode,String message) throws BusinessException {
        if(!expression) {
            throw new BusinessException(errorCode,message);
        }
    }
    
    /**
     * 断言该布尔值为true，若为false则抛异常
     * @param expression 待校验布尔值
     */
    public static void isTrue(boolean expression) throws BusinessException {
        Assert.isTrue(expression,"The expression not true");
    }
}