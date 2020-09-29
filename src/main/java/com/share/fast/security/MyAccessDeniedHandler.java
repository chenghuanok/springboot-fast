package com.share.fast.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限不足拦截
 * @Author: chenghuan
 * @Date: 2020/9/29 20:59
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * Handles an access denied failure.
     *
     * @param request               that resulted in an <code>AccessDeniedException</code>
     * @param response              so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     * @throws IOException      in the event of an IOException
     * @throws ServletException in the event of a ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //响应状态
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setHeader("Content-Type","application/json;charset=utf-8");
        final PrintWriter writer = response.getWriter();
        writer.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员\"}");
        writer.flush();
        writer.close();
    }
}
