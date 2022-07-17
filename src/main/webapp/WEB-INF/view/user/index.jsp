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
    <title>测试页面</title>
</head>
<body>
<button type="button" class="btn btn-success">（成功!!）Success</button>

</body>
</html>
