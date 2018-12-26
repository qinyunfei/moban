<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html>
<html>
<head>
<base href="${ctp}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UEditor</title>
    <script type="text/javascript" charset="utf-8" src="static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="static/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="static/ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<div>
    <h1>完整demo</h1>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<script type="text/javascript">
    //实例化编辑器
    UE.getEditor('editor');
</script>
</body>
</html>