package com.share.fast.common;

import lombok.Builder;
import lombok.Data;

/**
 * 统一返回值
 * @Author: chenghuan
 * @Date: 2020/9/21 21:11
 */
@Data
@Builder
public class ResponseResult<T> {

    /**
     * 是否成功
    */
    private Boolean success;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 构建buildResponseResult
    */
    public static ResponseResult buildResponseResult(final Boolean success,final Integer code,
                                                     final String msg,final Object data ){
        return ResponseResult.builder().code(code).msg(msg).success(success).data(data).build();
    }
}
