<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!--引入JQuery-->
    <script>
        function queryUsers() {
            $("f1").submit();
        }

        function deleteUser(id) {
            if (confirm("确定要删除吗?")) {
                $.getJSON("${pageContext.request.contextPath}/user/delete/" + id, function (result) {
                    if (result == true) {
                        alert("删除成功！");
                        $("#tr_" + id).fadeOut(1000);
                    } else {
                        alert("删除失败！");
                    }
                });
            }
        }

        function deleteSome() {
            var ids = new Array();
            $("[name=child]:checked").each(function (index, element) {
                var id = $(element).val();
                ids.push(id);
            });
            if (ids.length > 0) {
                location.href = "${pageContext.request.contextPath}/user/deleteSome/" + ids;
            } else {
                alert("请选中要删除的数据！！");
            }
        }

        //修改跳转
        function toupdate(id) {
            location.href = "${pageContext.request.contextPath}/user/toupdate/" + id;
        }


        function exportExcel() {
            var ids = new Array();
            $("[name=child]:checked").each(function (index, element) {
                var id=$(element).val();
                ids.push(id);
            });
            if (ids.length>0){
                location.href="${pageContext.request.contextPath}/user/exportExcel/"+ids;
            } else {
                alert("请选中要导出的数据！");
            }
        }
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">${sessionScope.name}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/bill/getBills">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/provider/getProviders">供应商管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/userImport">用户导入</a> </li>
                <li><a href="${pageContext.request.contextPath}/page/password">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <form action="${pageContext.request.contextPath}/user/list" method="post" id="f1">
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名："/>
                <input type="button" value="查询" onclick="queryUsers();"/>

                <input type="button" value="批量导出" onclick="exportExcel();"/>

                <a href="javascript:deleteSome();">批量删除</a>
                <a href="${pageContext.request.contextPath}/page/userAdd">添加用户</a>
            </div>
        </form>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="5%">
                    <input type="checkbox" name="all" onclick="ckAll()"/>
                </th>
                <th width="10%">用户编码</th>
                <th width="10%">用户名称</th>
                <th width="10%">性别</th>
                <th width="20%">生日</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="250%">操作</th>
            </tr>
            <c:forEach items="${requestScope.user}" var="u">
                <tr id="tr_${u.id}">
                    <th width="5%">
                        <input type="checkbox" value="${u.id}" name="child"/>
                    </th>
                    <td>${u.uno}</td>
                    <td>${u.uname}</td>
                    <td>${u.usex==1?"男":"女"}</td>
                    <td>
                        <fmt:formatDate value="${u.ubirthday}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>${u.uphone}</td>
                    <td>
                        <c:if test="${u.utype==1}">
                            经理
                        </c:if>
                        <c:if test="${u.utype==2}">
                            管理员
                        </c:if>
                        <c:if test="${u.utype==3}">
                            员工
                        </c:if>
                    </td>
                    <td>
                        <a href="javascript:location.href='${pageContext.request.contextPath}/user/getById/'+${u.id}"><img
                                src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看"/></a>
                        <a href="javascript:toupdate(${u.id})"><img
                                src="${pageContext.request.contextPath}/img/xiugai.png" alt="修改"
                                title="修改"/></a>
                        <a href="javascript:deleteUser(${u.id})" class="removeUser"><img
                                src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</section>

<footer class="footer">
</footer>


<script src="../../js/js.js"></script>
<script src="../../js/time.js"></script>

</body>
</html>
