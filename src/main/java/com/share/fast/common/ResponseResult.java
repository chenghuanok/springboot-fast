package com.share.fast.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

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
     * 成功
     * @param data
     * @return ResponseResult
    */
    public static ResponseResult success(final Object data){
        return ResponseResult.builder().code(HttpStatus.OK.value()).msg("").success(true).data(data).build();
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return ResponseResult
     */
    public static ResponseResult fail(final Integer code,final String msg){
        return ResponseResult.builder().code(code).msg(msg).success(false).data("").build();
    }
}
