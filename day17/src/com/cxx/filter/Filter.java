package com.cxx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // ��ʹ��*���Զ������������������Я��CookieʱʧЧ
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        System.out.println(111);
        // ����Ӧ�����Զ���ͷ
        String headers = request.getHeader("Access-Control-Request-Headers");
        response.setHeader("Access-Control-Allow-Headers", headers);
        response.setHeader("Access-Control-Expose-Headers", headers);

        // �����������󷽷�����
        response.setHeader("Access-Control-Allow-Methods", "*");
        // Ԥ�����OPTIONS������ʱ�䣬��λ����
        response.setHeader("Access-Control-Max-Age", "3600");
        // ��ȷ��ɿͻ��˷���Cookie��������ɾ���ֶμ���
        response.setHeader("Access-Control-Allow-Credentials", "true");

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
