package com.responseUntils;

import com.responseobject.Response;

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
}
