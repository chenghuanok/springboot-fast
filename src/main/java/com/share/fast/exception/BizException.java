package com.share.fast.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义业务异常
 * @Author: chenghuan
 * @Date: 2020/9/23 20:48
 */
public class BizException extends RuntimeException{

    /**
     * 信息
    */
    private String msg;

    /**
     * 异常码
     */
    private Integer code = HttpStatus.EXPECTATION_FAILED.value();

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BizException(Integer code,String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BizException(Integer code,String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
