package com.cxx.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/index.jsp")
public class FilterDemo01 implements Filter {
    /*
    * �����������ڽ�ִ��һ��
    * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("��������������ʱ�򴴽�");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("�㿴����index.jsp�е�����");
    }
    /*
     * �����������ڽ�ִ��һ��
     * */
    @Override
    public void destroy() {
        System.out.println("���������رյ�ʱ�򴴽�");
    }
}
