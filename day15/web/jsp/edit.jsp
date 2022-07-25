<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/7/19
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/day15/stu?method=edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="sid" value="${stu.sid}">
    <input type="hidden" name="oldFileName" value="${stu.photo}">
    <table>
        <tr>
            <td align="right">姓名:</td>
            <td>
                <input type="text" name="name" value="${stu.name}">
            </td>
        </tr>
        <tr>
            <td align="right">性别:</td>
            <td>

                <input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男'}">checked</c:if>>男
                <input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td align="right">爱好:</td>
            <td>

                <input type="checkbox" name="hobby" value="吃" <c:if test="${fn:contains(stu.hobby, '吃')}">checked</c:if>>吃
                <input type="checkbox" name="hobby" value="喝" <c:if test="${fn:contains(stu.hobby, '喝')}">checked</c:if>>喝
                <input type="checkbox" name="hobby" value="玩" <c:if test="${fn:contains(stu.hobby, '玩')}">checked</c:if>>玩
                <input type="checkbox" name="hobby" value="乐" <c:if test="${fn:contains(stu.hobby, '乐')}">checked</c:if>>乐
            </td>
        </tr>
        <tr>
            <td align="right">出生日期:</td>
            <td>
                <input type="date" name="birthday" value="${stu.birthday}">
            </td>
        </tr>
        <tr>
            <td align="right">描述:</td>
            <td>
                <textarea name="sdesc" cols="30" rows="5">${stu.sdesc}</textarea>
            </td>
        </tr>
        <tr>
            <td align="right">头像:</td>
            <td>
                <input type="file" name="photo">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>

</form>
</body>
</html>