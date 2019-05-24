<%--
  Created by IntelliJ IDEA.
  User: monster
  Date: 2019-05-20
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script type="text/javascript">
        function updateUser() {
            $.ajax({
                url: "${pageContext.request.contextPath}/user/update",
                type: "post",
                dataType: "json",
                data: $("#updateForm").serialize(),
                success: function (result) {
                    if (result == true) {
                        alert("修改成功！");
                        location.href = "${pageContext.request.contextPath}/user/list";
                    } else {
                        alert("修改失败！");
                    }
                }
            });
        }
    </script>
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
                <li><a href="${pageContext.request.contextPath}/provider/getProviders">供应商管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/password">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/login">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form id="updateForm">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="hidden" name="id" value="${requestScope.user.id}"/>
                    <input type="text" name="uname" id="userName" value="${requestScope.user.uname}" placeholder=""/>
                    <span>*</span>
                </div>

                <div>
                    <label>用户性别：</label>
                    <select name="usex">
                        <option value="1" ${requestScope.user.usex=="1"?"selected":""}>男</option>
                        <option value="0" ${requestScope.user.usex=="0"?"selected":""}>女</option>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="ubirthday" id="data" value="<f:formatDate value="${requestScope.user.ubirthday}" pattern="yyyy-MM-dd" />"
                           placeholder="2016年2月1日"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="uphone" id="userphone" value="${requestScope.user.uphone}"
                           placeholder="13533667897"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="uaddress" value="${requestScope.user.uaddress}" id="userAddress"
                           placeholder="北京"/>
                </div>
                <div>
                    <label>用户类别：</label>
                    <input type="radio" name="utype" value="1" ${requestScope.user.utype==1?"checked":""}/>管理员
                    <input type="radio" name="utype" value="2" ${requestScope.user.utype==2?"checked":""}/>经理
                    <input type="radio" name="utype" value="3" ${requestScope.user.utype==3?"checked":""}/>普通用户

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="button" value="保存" onclick="updateUser()"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
