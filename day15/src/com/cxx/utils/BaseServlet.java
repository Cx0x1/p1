package com.cxx.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //��ȡ����Ҫִ�е�ҵ�񷽷���
        String method = req.getParameter("method");
        //��ȡ�����ߵ��ֽ����ļ�
        Class<? extends BaseServlet> claz = this.getClass();
        try {
            //���ݲ������ͺͷ�����ȥ�ֽ����ļ��л�ȡ���÷���
            Method m = claz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //ִ�з���
            m.invoke(claz.newInstance(),req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
