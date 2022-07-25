package com.cxx.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/index.jsp")
public class FilterDemo01 implements Filter {
    /*
    * 整个生命周期仅执行一次
    * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("当服务器开启的时候创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("你看不到index.jsp中的内容");
    }
    /*
     * 整个生命周期仅执行一次
     * */
    @Override
    public void destroy() {
        System.out.println("当服务器关闭的时候创建");
    }
}
