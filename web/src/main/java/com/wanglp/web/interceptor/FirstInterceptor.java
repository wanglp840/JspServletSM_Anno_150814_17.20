package com.wanglp.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/5/13.
 */
public class FirstInterceptor extends HandlerInterceptorAdapter{
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handle) throws Exception{
        //不拦截，由dispatcher转发，
        return true;
        //拦截则返回false,dispatcher不再继续转发请求
    }
}
