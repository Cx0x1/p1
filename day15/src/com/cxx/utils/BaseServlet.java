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
        //获取具体要执行的业务方法名
        String method = req.getParameter("method");
        //获取调用者的字节码文件
        Class<? extends BaseServlet> claz = this.getClass();
        try {
            //根据参数类型和方法名去字节码文件中获取到该方法
            Method m = claz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            m.invoke(claz.newInstance(),req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
