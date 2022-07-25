<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/7/18
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/day15/js/jquery-1.12.4.js"></script>
    <style>
        #btn{
            width: 120px;
            height: 30px;
            background-color: green;
            border-radius: 15px;
            text-align: center;
            line-height: 30px;
            position: absolute;
            left: 360px;
        }

    </style>
</head>
<body>
<div align="center">
    <form action="/day15/stu?method=findPages" method="post">
        姓名:<input type="text" name="name" value="${param.name}">
        性别:<select name="sex">
        <option value="-1" <c:if test="${param.sex=='-1'}">selected</c:if>>--请选择--</option>
        <option value="男" <c:if test="${param.sex=='男'}">selected</c:if>>男</option>
        <option value="女" <c:if test="${param.sex=='女'}">selected</c:if>>女</option>
    </select>
        <input type="submit" value="搜索">
    </form>
</div>
<table width="1200px" cellspacing="0px" align="center" border="1px">
    <tr>
        <th><input type="checkbox" name="all" onclick="fun1(checked)">全选/全不选</th>
        <th>学号</th>
        <th>姓名</th>
        <th>头像</th>
        <th>性别</th>
        <th>生日</th>
        <th>爱好</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <c:if test="${pb.list!=null}">
        <c:forEach items="${pb.list}" var="stu">
            <tr>
                <td><input type="checkbox" name="checkbox"  value="${stu.sid}"></td>
                <td>${stu.sid}</td>
                <td>${stu.name}</td>
                <td>
                    <img src="http://localhost/img/${stu.photo}" width="80px" height="80px">
                </td>
                <td>${stu.sex}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hobby}</td>
                <td>${stu.sdesc}</td>
                <td>
                    <a href="/day15/stu?method=findstudent&sid=${stu.sid}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<div align="center">
    <a href="/day15/stu?method=findPages&currentPage=1&pageSize=3&name=${param.name}&sex=${param.sex}">首页</a>&nbsp;&nbsp;
    <c:if test="${pb.currentPage==1}">
        <a href="#">上一页</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${pb.currentPage!=1}">
        <a href="/day15/stu?method=findPages&currentPage=${pb.currentPage-1}&pageSize=3&name=${param.name}&sex=${param.sex}">上一页</a>&nbsp;&nbsp;
    </c:if>

    <c:if test="${pb.currentPage==pb.totalPage}">
        <a href="#">下一页</a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${pb.currentPage!=pb.totalPage}">
        <a href="/day15/stu?method=findPages&currentPage=${pb.currentPage+1}&pageSize=3&name=${param.name}&sex=${param.sex}">下一页</a>&nbsp;&nbsp;
    </c:if>

    <a href="/day15/stu?method=findPages&currentPage=${pb.totalPage}&pageSize=3&name=${param.name}&sex=${param.sex}">尾页</a>&nbsp;&nbsp;
    一共是${pb.totalCount}条&nbsp;&nbsp;&nbsp;合计${pb.totalPage}页&nbsp;&nbsp;&nbsp; 当前是${pb.currentPage}页

</div>
<div id="btn" onclick="delAll()">批量删除</div>
</body>

<script>
    function fun1(f1) {
        //f1:全选框的选中状态
        $("input[name='checkbox']").prop("checked",f1)
    }
    function delAll() {
    //    获取除了了全选框外被选中所有的复选框
        var inputs = $("input[name='checkbox']:checked")
    //    组装sids
        var sids=""
        for (var i=0;i<inputs.length;i++){
            if (i==inputs.length-1){
                sids+=inputs[i].value
            }else {
                sids+=inputs[i].value+","
            }
        }
    //    发送请求携带sids
        location.href="/day15/stu?method=delAll&sids="+sids+"&currentPage=${pb.currentPage}"

    }
</script>
</html>
