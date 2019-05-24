<%--
  Created by IntelliJ IDEA.
  User: monster
  Date: 2019-05-22
  Time: 16:45
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script type="text/javascript">
        //加载下拉框
        $(function () {
            $.getJSON("${pageContext.request.contextPath}/bill/pro", function (result) {
                $("[name=providerId]").append("<option value='-1'>--请选择--</option>");
                for (var i = 0; i < result.length; i++) {
                    $("[name=providerId]").append("<option value='" + result[i].pid + "'>" + result[i].pname + "</option>");
                }
                $("[name=providerId]").val(${requestScope.bill.provider.pid});
            })
        });

        function updateBill() {
            $.ajax({
                url: "${pageContext.request.contextPath}/bill/update",
                type: "post",
                data: $("#updateF1").serialize(),
                dataType: "json",
                success: function (result) {
                    alert(result);
                    if (result == "true") {
                        alert("修改成功！");
                        location.href = "${pageContext.request.contextPath}/bill/getBills";
                    } else {
                        alert("修改失败");
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
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
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
                <li><a href="${pageContext.request.contextPath}/provider/getProviders">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user/list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/password">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/user/login">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId">订单编码：</label>
                    <input type="text" name="bnumber" id="providerId" value="${requestScope.bill.bnumber}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="providerName">商品名称：</label>
                    <input type="text" name="bname" id="providerName" value="${requestScope.bill.bname}"
                           placeholder="123"/>
                    <span>*</span>
                </div>

                <div>
                    <label for="address">金额：</label>
                    <input type="text" name="bmoney" id="address" value="${requestScope.bill.bmoney}"
                           placeholder="200"/>
                    <span>*</span>
                </div>
                <div>
                    <label>供应商：</label>
                    <select name="providerId" id="providerId">

                    </select>
                    <span>*</span>
                </div>
                <div>
                    <label>是否付款：</label>
                    <input type="radio" name="bpay" ${requestScope.bill.bpay==0?"checked":""}/>未付款
                    <input type="radio" name="bpay" ${requestScope.bill.bpay==1?"checked":""}/>已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.html">返回</a>-->
                    <input type="button" value="保存" onclick="updateBill()"/>
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
