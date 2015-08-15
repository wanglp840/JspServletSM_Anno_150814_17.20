package com.wanglp.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2015/5/16.
 */
public class EncodeFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=UTF-8");


        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
