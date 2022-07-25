<%@ page import="com.cxx.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/7/14
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--创建实体类对象--%>
<jsp:useBean id="stu" class="com.cxx.entity.Student">
</jsp:useBean>
<%--实体类对象中赋值--%>

<jsp:setProperty name="stu" property="id" value="1001"></jsp:setProperty>
<jsp:setProperty name="stu" property="name" value="蔡依林"></jsp:setProperty>
<jsp:setProperty name="stu" property="age" value="33"></jsp:setProperty>
<%--获取对象中的属性--%>
<jsp:getProperty name="stu" property="id"/>
<jsp:getProperty name="stu" property="name"/>
<jsp:getProperty name="stu" property="age"/>
<%

    request.setAttribute("msg1","热的我全身出汗");
    System.out.println(request.getAttribute("msg1"));

    session.setAttribute("msg2","心境自然凉");
    System.out.println(session.getAttribute("msg2"));

    application.setAttribute("msg3","我永你们同在");
    System.out.println(application.getAttribute("msg3"));
%>
</body>
</html>
