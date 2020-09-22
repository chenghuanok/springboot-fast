package com.share.fast.advice;


import com.alibaba.fastjson.JSON;
import com.share.fast.common.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import java.util.Objects;

/**
 * 响应切面
 * @Author: chenghuan
 * @Date: 2020/9/21 21:23
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice{


    /**
     * Whether this component supports the given controller method return type
     * and the selected {@code HttpMessageConverter} type.
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * Invoked after an {@code HttpMessageConverter} is selected and just before
     * its write method is invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        //返回值为空
        if(Objects.isNull(body)){
            return ResponseResult.buildResponseResult(true,HttpStatus.OK.value(),"","");
        }

        //返回值为统一返回类型直接返回
        if(body instanceof ResponseResult){
            return body;
        }

        //因为handler处理类的返回类型是String，为了保证一致性，这里需要将ResponseResult转回去
        if(body instanceof String) {
            return JSON.toJSONString(ResponseResult.buildResponseResult(true,
                    HttpStatus.OK.value(),"",body));
        }

        return ResponseResult.buildResponseResult(true,HttpStatus.OK.value(),"",body);
    }
}
