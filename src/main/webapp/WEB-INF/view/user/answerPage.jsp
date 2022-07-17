<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/bootstrap.js"></script>
<head>
    <title>答案页面</title>
</head>
<body>
<%-- 填写答案提示页面 判断超管权限 如果是超管账号  没有答案填写框  按钮变成返回到首页 --%>
    <div>
        <td>${userModel.question}</td>
    </div>
        <C:if test="${userModel.power == 1}">
            <form>
                <p><input type="text" name="answer" id="answer"></p>
                <input type="button" value="提交" onclick="submitAnswer()">
            </form>
        </C:if>
        <input type="button" value="返回首页" onclick="backHomePage()"/>

</body>
    <script type="text/javascript">

        function backHomePage() {
            window.location.href = "user/homePage";
        }

        function submitAnswer() {
            var username ="${userModel.username}";
            if("${userModel.answer}" == $("#answer").val().trim()){
                window.location.href = "user/jumpUpdatePassword?username=" + username
            }else {
                alert("答案错误")
            }


        }


    </script>
</html>
