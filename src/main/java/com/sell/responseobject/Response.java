package com.sell.responseobject;

import lombok.Data;

/**
 * HTTP 返回的格式
 */
@Data
public class Response<T> {

    /** 错误码 */
    private Integer code;

    /** 错误信息 */
    private String message;

    /** 返回的具体数据信息 */
    private T data;
}
