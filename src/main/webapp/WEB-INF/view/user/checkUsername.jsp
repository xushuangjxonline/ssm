<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="<%=basePath%>js/bootstrap.js"></script>



<head>
    <title>找回密码</title>
</head>
<body>
    <form action="">
        <p>用户名:<input type="text" name="username" id="username"></p>
        <%-- 输入账户名 点击下一步 先判断该账户是否存在 如果存在 将该username带入下一个页面 查出问题  并且输入答案--%>
        <input type="button" value="下一步" onclick="isHaveUsername()">
    </form>
    <input type="button" value="返回首页" onclick="backHomePage()"/>
</body>

    <script type="text/javascript">

        function backHomePage() {
            window.location.href = "user/homePage";
        }

        function  isHaveUsername() {
            var val = $("#username").val();
            var param = {"username":val};
         $.ajax({
             url:"user/isHaveUsername",
             type:"get",
             data:param,
             success:function (data) {
                var jsonData = JSON.parse(data);
                if(jsonData.returnMap.username == 1){
                    window.location.href = "user/jumpAnswerPage?username=" + val;
                }else{
                    alert("该账号不存在")
                }
             },
             error:function () {
                alert("参数错误")
             }
         })
        }
    </script>
</html>
