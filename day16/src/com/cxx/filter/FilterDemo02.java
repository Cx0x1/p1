package com.cxx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*
 *   DispatcherType
 *           REQUEST:只拦截重定向
 *           FORWARD:只拦截转发
 *   配置拦截请求转发和重定向
 *
 * */
//@WebFilter(urlPatterns ="/*",dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("老弟拦截你");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
