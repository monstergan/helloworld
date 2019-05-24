<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script>
        function deleteP(id) {
            if (confirm("确定要删除吗？")) {
                $.getJSON("${pageContext.request.contextPath}/provider/deletep/" + id, function (result) {
                    if (result == true) {
                        alert("删除成功!");
                        $("#tp_" + id).fadeOut(1000);
                    } else {
                        alert("删除失败！");
                    }
                });
            }
        }

        function toupdatep(pid) {
            location.href="${pageContext.request.contextPath}/provider/toupdatep/"+pid;
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
                <li id="active"><a href="${pageContext.request.contextPath}/provider/getProviders">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
                <li><a href="password.html">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/login">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <span>供应商名称：</span>
            <input type="text" placeholder="请输入供应商的名称"/>
            <input type="button" value="查询"/>
            <a href="${pageContext.request.contextPath}/page/providerAdd">添加供应商</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${requestScope.provider}" var="p">
                <tr id="tp_${p.pid}">
                    <td>${p.pno}</td>
                    <td>${p.pname}</td>
                    <td>${p.plinkman}</td>
                    <td>${p.pphone}</td>
                    <td>${p.pfax}</td>
                    <td>
                        <fmt:formatDate value="${p.pcreatedate}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <a href="javascript:location.href='${pageContext.request.contextPath}/provider/getByIdp/' +${p.pid}"><img
                                src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看"/></a>
                        <a href="javascript:toupdatep(${p.pid})"><img src="${pageContext.request.contextPath}/img/xiugai.png"
                                                           alt="修改" title="修改"/></a>
                        <a href="javascript:deleteP(${p.pid})" class="removeProvider"><img
                                src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</section>

<%--<!--点击删除按钮后弹出的页面-->--%>
<%--<div class="zhezhao"></div>--%>
<%--<div class="remove" id="removeProv">--%>
<%--    <div class="removerChid">--%>
<%--        <h2>提示</h2>--%>
<%--        <div class="removeMain" >--%>
<%--            <p>你确定要删除该供应商吗？</p>--%>
<%--            <a href="#" id="yes">确定</a>--%>
<%--            <a href="#" id="no">取消</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<footer class="footer">
</footer>


<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>