<%--
  Created by IntelliJ IDEA.
  User: monster
  Date: 2019-05-22
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
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
        <p><span>下午好！</span><span style="color: #fff21b"> ${requestScope.name}</span> , 欢迎你！</p>
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
                <li id="active"><a href="${pageContext.request.contextPath}/bill/getBills">账单管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/provider/getProviders">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/password">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/login">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>订单编号：</strong><span>${requestScope.bill.bnumber}</span></p>
            <p><strong>商品名称：</strong><span>${requestScope.bill.bname}</span></p>
            <p><strong>金额：</strong><span>${requestScope.bill.bmoney}</span></p>
            <p><strong>供应商：</strong><span>${requestScope.bill.provider.pname}</span></p>
            <p><strong>是否付款：</strong><span>${requestScope.bill.bpay==1?"已付款":"未付款"}</span></p>

            <a href="${pageContext.request.contextPath}/bill/getBills">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
