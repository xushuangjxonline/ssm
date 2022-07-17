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
    <title>欢迎登录</title>
</head>
<body>
        <p>用户名:<input type="text" name="username" id="username"></p>
        <p>密码:<input type="password" name="password" id="password"></p>
        <p><input type="button" value="登录" onclick = login();>
            <input type="button" value="忘记密码" onclick="jumpFindPassword()">
        </p>
</body>

    <script type="text/javascript">
        function login() {
            var username = $("#username").val();
            var password = $("#password").val();
            var param = {"username":username,"password":password};
            $.ajax({
                url:"user/doLogin",
                type:"post",
                data:JSON.stringify(param),
                dataType:"text",
                contentType:"application/json",
                success:function (data) {
                    var jsonData = JSON.parse(data);
                    if(jsonData.returnMap.isAllow == 1){
                        window.location.href = "user/jumpMainPage"
                    }else{
                        alert("账号或密码错误!")
                    }
                }
            })
        }

        function jumpFindPassword(){
            window.location.href = "user/jumpFindPassword"
        }

    </script>

</html>
