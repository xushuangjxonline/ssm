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
    <title>修改密码页面</title>
</head>
<body>
        <p>请输入新密码:<input type="text" name="password" id="newPassword"></p>
        <p>请确认新密码:<input type="text" name="password" id="newPassword1"></p>
        <p><input type="button" value="提交" onclick="doUpdatePassword()">
        <input type="button" value="返回首页" onclick="backHomePage()"/></p>
</body>
    <script type="text/javascript">
            function backHomePage() {
                window.location.href = "user/homePage";
            }

            function doUpdatePassword() {
                var username = "${username}";
                var password = $("#newPassword").val().trim();
                var password1 = $("#newPassword1").val().trim();
                var param = {"username":username,"password":password};
                if(password !== password1){
                    alert("两次输入的密码不一致")
                }else{
                    $.ajax({
                        url:"user/doPasswordUpdate",
                        type:"post",
                        data:JSON.stringify(param),
                        contentType:"application/json",
                        success:function (data) {
                            var jsonData = JSON.parse(data)
                            if(jsonData.code == 100){
                                alert("修改成功,请重新登陆");
                                window.location.href = "user/homePage"
                            }else {
                                alert("修改失败 玩蛋去")
                            }
                        },
                        error:function () {
                            alert("修改失败 你也玩蛋去")
                        }
                    })
                }

            }

    </script>
</html>
