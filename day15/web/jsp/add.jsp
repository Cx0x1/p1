<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/7/18
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/day15/stu?method=add" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td align="right">姓名:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td align="right">性别:</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td align="right">爱好:</td>
            <td>
                <input type="checkbox" name="hobby" value="吃">吃
                <input type="checkbox" name="hobby" value="喝">喝
                <input type="checkbox" name="hobby" value="嫖">嫖
                <input type="checkbox" name="hobby" value="赌">赌
            </td>
        </tr>
        <tr>
            <td align="right">出生日期:</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td align="right">描述:</td>
            <td><textarea name="sdesc" cols="30" rows="5"></textarea> </td>
        </tr>
        <tr>
            <td align="right">头像:</td>
            <td><input type="file" name="photo"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
