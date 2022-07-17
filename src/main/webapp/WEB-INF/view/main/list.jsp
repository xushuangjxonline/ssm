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
    <title>list</title>
</head>
<body>
    ${sessionScope.userModel.username}
    ${sessionScope.userModel.password}
    ${sessionScope.userModel.question}
    ${sessionScope.userModel.answer}
    ${sessionScope.userModel.power}
</body>
</html>
