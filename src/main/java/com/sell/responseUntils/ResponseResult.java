package com.sell.responseUntils;

import com.sell.responseobject.Response;

/**
 * 统一的返回格式
 */
public class ResponseResult {

    /**
     * 返回成功
     * @param object
     * @return
     */
    public static Response success(Object object){
        Response response = new Response();
        response.setCode(0);
        response.setMessage("success");
        response.setData(object);

        return  response;
    }

    /**
     * 返回失败
     * @param code
     * @param message
     * @return
     */
    public static Response fail(Integer code,String message){
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        response.setData(null);

        return response;
    }
}
