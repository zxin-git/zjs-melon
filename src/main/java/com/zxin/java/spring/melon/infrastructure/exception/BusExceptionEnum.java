package com.zxin.java.spring.melon.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务异常枚举
 */
@Getter
@AllArgsConstructor
public enum BusExceptionEnum {

    A0001("A0001", 1, "用户端错误"),
    B0001("B0001", 1, "系统执行出错"),
    C0001("C0001", 1, "调用第三方服务出错"),


    A0100("A0100", 2, "用户注册错误"),
    A0200("A0200", 2, "用户登录异常"),
    A0300("A0300", 2, "访问权限异常"),
    A0400("A0400", 2, "用户请求参数错误"),
    A0500("A0500", 2, "用户请求服务异常"),
    A0600("A0600", 2, "用户资源异常"),
    A0700("A0700", 2, "用户上传文件异常"),
    A0800("A0800", 2, "用户当前版本异常"),
    A0900("A0900", 2, "用户隐私未授权"),
    A1000("A1000", 2, "用户设备异常"),

    B0100("B0100", 2, "系统执行超时"),
    B0200("B0200", 2, "系统容灾功能被触发"),
    B0300("B0300", 2, "系统资源异常"),

    C0100("C0100", 2, "中间件服务出错"),
    C0200("C0200", 2, "第三方系统执行超时"),
    C0300("C0300", 2, "数据库服务出错"),
    C0400("C0400", 2, "第三方容灾系统被触发"),
    C0500("C0500", 2, "通知服务出错"),


    ;
    private String code;

    private Integer level;

    private String message;

    public BusinessException busException(){
        return new BusinessException(code, message);
    }

    public BusinessException busException(String message){
        return new BusinessException(code, message);
    }

}
