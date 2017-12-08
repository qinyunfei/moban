<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>管理平台</title>

<link type="text/css" rel="stylesheet" href="windou/css/css.css" />

<link type="text/css" rel="stylesheet" href="windou/css/jquery.tool.css" />

<link type="text/css" rel="stylesheet" href="windou/css/smartMenu.css" />

<script type="text/javascript" src="windou/js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" src="windou/js/jquery.tool.js"></script>

<script type="text/javascript" src="windou/js/shortcut.js"></script>

<script type="text/javascript" src="windou/js/templates.js"></script>

<script type="text/javascript" src="windou/js/jquery-smartMenu.js"></script>

<script type="text/javascript" src="windou/js/core.js"></script>

<script type="text/javascript" src="windou/js/quanping.js"></script>


<script type="text/javascript">
var shortcut;
	

	
	$.ajax({ url: "${ctp}/sysresource/cons",async: false,success: function(data){
		shortcut=data;
	}});

	
	$().ready(function() {
		//IE下禁止选中
		document.body.onselectstart = document.body.ondrag = function() {
			return false;
		}

		Core.init();

	});


	

</script>



</head>

<body id="lxcn"
	style="background: url(windou/images/background.jpg) repeat right bottom transparent;">

	<div id="task-bar">

		<ul class="task-window">

		</ul>

		<ul class="task-panel">

			<li class="sys" title="系统设定" id="view-fullscreen"><b class="">系统设定</b></li>
			
		</ul>

	</div>

	<div id="desk">
		<ul></ul>
	</div>


</body>

</html>