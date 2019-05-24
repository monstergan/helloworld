<%--
  Created by IntelliJ IDEA.
  User: monster
  Date: 2019-05-20
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.name}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/user/login">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/bill/getBills">账单管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/provider/getProviders">供应商管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/password">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/login">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${requestScope.user.uno}</span></p>
            <p><strong>用户头像：</strong><img src="${pageContext.request.contextPath}/${requestScope.user.uimage}" style="width: 400px
;height: 200px"></p>
            <p><strong>用户名称：</strong><span>${requestScope.user.uname}</span></p>
            <p><strong>用户性别：</strong><span>${requestScope.user.usex}</span></p>
            <p><strong>出生日期：</strong><span>${requestScope.user.ubirthday}</span></p>
            <p><strong>用户电话：</strong><span>${requestScope.user.uphone}</span></p>
            <p><strong>用户地址：</strong><span>${requestScope.user.uaddress}</span></p>
            <p><strong>用户类别：</strong><span>${requestScope.user.utype}</span></p>

            <a href="${pageContext.request.contextPath}/user/list">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
