package com.cxx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*
 *   DispatcherType
 *           REQUEST:ֻ�����ض���
 *           FORWARD:ֻ����ת��
 *   ������������ת�����ض���
 *
 * */
//@WebFilter(urlPatterns ="/*",dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("�ϵ�������");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
