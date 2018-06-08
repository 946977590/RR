<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面测试</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/main.css" media="all" />
</head>
<body>
<p>你好！<span class="userName"><s:property value="#session.userName" /></span>, 欢迎登录</p>

<h3><a href="">个人资料</a></h3>
<h3><a href="">修改密码</a></h3>
<h3><a href="" onclick="logout();">注销</a></h3>


<script type="text/javascript">
	function logout(){
		if(window.confirm("您确定要退出吗？"))
		{
		location.href="${pageContext.request.contextPath }/loginout.action";
		 }else{
			 return false;
		 }
	}
		
</script>
</body>
</html>