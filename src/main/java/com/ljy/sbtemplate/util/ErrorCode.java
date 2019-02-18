package com.ljy.sbtemplate.util;

/**
 * 全局异常码
 */
public enum ErrorCode {

    /**
     * 前端确认code
     * 用于用户确认操作
     */
    CONFIRM_MESSAGE("10086","你确认执行此操作?"),

    ERROR_SERVER("WFW0001","服务异常"),

    PROMPT_MESSAGE("KP8888","错误提示信息"),

    /*
    系统级错误
     */
    SUCCESS("KP0001","请求成功"),
    FAILURE("KP0002","操作失败"),
    UNKNOWN_ERROR("KP0003","未知错误"),
    PARAMETER_ERROR("KP0004","参数错误"),
    OBJECT_IS_NULL("KP0005","对象为空"),
    OBJECT_REFERENCE("KP0006","对象已被引用"),
    OBJECT_UNIQUE("KP0007", "对象已存在"),
    EXCLUDE_UPDATE("KP0009","数据已被他人更新，请重新获取数据。"),
    DUPLICATE_SAVE("KP0010","数据库已存在数据"),
    CHECK_FAILURE("KP0021","校验失败"),
    /** 共同 **/
    DATA_NO_FOUND("KP0011","没有找到相关数据"),
    DATA_FIELD_IS_NULL("KP0012", "数据非空字段为空"),
    SYSTEM_ERROR("KP9999","系统错误"),
    COMMON_ERROR("KP0000",""),

    ADD_FAIL("KP0101","新增失败"),
    UPDATE_FAIL("KP0102", "修改失败"),
    DELETE_FAIL("KP0103", "删除失败"),


    /** k2引擎 **/
    CREATE_FORM_ERRPR("KP_K2001","打开申请表单错误"),
    CREATE_NUMBER_ERRPR("KP_K2002","K2生成Code"),
    START_FLOW_ERRPR("KP_K2003","第一次提交表单错误"),



    /** 流程Message **/
    CALLBACK_ERROR("KP1001","流程回调失败"),


    ;




    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg(){
        return msg;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.msg;
    }

}
