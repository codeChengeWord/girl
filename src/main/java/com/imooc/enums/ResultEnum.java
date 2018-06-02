package com.imooc.enums;

/**
 * 异常编号和消息的枚举
 */
public enum ResultEnum {
    UNKONW_ERROE(-1,"未知错误！！"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能还在上中学");
    //异常编码
    private  Integer code;
    //异常消息
    private  String  messge;

    ResultEnum(Integer code, String messge) {
        this.code = code;
        this.messge = messge;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessge() {
        return messge;
    }
}
