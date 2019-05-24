<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script type="text/javascript">
        //看不清
        function changeOic() {
            $("#pic").prop("src","${pageContext.request.contextPath}/code/createCode?date="+new Date());
        }
    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市账单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath}/user/login" method="post">
            <span style="color: red">${requestScope.msg}</span>
            <div class="inputbox">
                <label for="user">用户名：</label>
                <input id="user" type="text" name="uno" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label for="mima">密码：</label>
                <input id="mima" type="password" name="upass" placeholder="请输入密码" required/>
            </div>
            <div class="inputbox">
                <tr><td>验证码：</td><td><input type="text" name="usercode" value="" style="width:80px;"/>
                    <img src="${pageContext.request.contextPath}/code/createCode" id="pic"/> <a href="javascript:changePic();">看不清</a> </td></tr>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>

        </form>
    </section>
</section>

</body>
</html>
