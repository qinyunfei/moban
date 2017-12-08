<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="${ctp}/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="Insdep1.5/themes/insdep/easyui.css" rel="stylesheet"
	type="text/css">
<link href="Insdep1.5/themes/insdep/easyui_animation.css"
	rel="stylesheet" type="text/css">
<link href="Insdep1.5/themes/insdep/easyui_plus.css" rel="stylesheet"
	type="text/css">
<link href="Insdep1.5/themes/insdep/insdep_theme_default.css"
	rel="stylesheet" type="text/css">
<link href="Insdep1.5/themes/insdep/icon.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript" src="Insdep1.5/jquery.min.js"></script>
<script type="text/javascript" src="Insdep1.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="Insdep1.5/themes/insdep/jquery.insdep-extend.min.js"></script>



</head>

<body class="easyui-layout">

	<div data-options="region:'west',title:'West',split:true"
		style="width: 150px;">
		<ul id="tt" class="easyui-tree"
			data-options="url:'sysresource/menus1/${id}'"></ul>
	</div>


	<div data-options="region:'center',title:'center'"
		style="padding: 5px; background: #eee;">
		<iframe name="content" src="tes1.jsp" id="iframeId" frameborder="0" onload="changeFrameHeight()"
			width="100%"></iframe>


	</div>
</body>

<script type="text/javascript">
	function changeFrameHeight() {
		var ifm = document.getElementById("iframeId");
		ifm.height = document.documentElement.clientHeight;

	}

	window.onresize = function() {
		changeFrameHeight();

	}

	$('#tt').tree({
		onClick : function(node) {
			var url = node.attributes.url;
			$("#iframeId").attr("src", "${ctp}/" + url);
		}
	});


</script>

</html>