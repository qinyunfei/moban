<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="${pageContext.request.contextPath}/school">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Insdep1.5/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
<link href="Insdep1.5/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
<link href="Insdep1.5/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
<link href="Insdep1.5/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
<link href="Insdep1.5/themes/insdep/icon.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="Insdep1.5/jquery.min.js"></script>
<script type="text/javascript" src="Insdep1.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="Insdep1.5/themes/insdep/jquery.insdep-extend.min.js"></script>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	color: #666;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>


</head>

<body>
用户名：${name}
</body>


</html>