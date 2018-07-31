package com.sell.exception;import com.sell.enums.ResponseEnum;/** * 自定义异常 */public class SellException extends RuntimeException {    private Integer code;     public SellException(ResponseEnum responseEnum){        super(responseEnum.getMessage());        this.code = responseEnum.getCode();     }     public SellException(Integer code,String message){         super(message);         this.code = code;     }}