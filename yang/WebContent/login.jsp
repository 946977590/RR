<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>登陆界面</title>
<!-- Custom Theme files -->
<link href="staticc/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<script type="text/javascript">
var n1=form2.username.value;
var n2=form2.password.value;

  if((n1.value)=="error" || (n2.value)=="error"){
      alert('用户不存在或密码不正确');
      }

 </script>

</head>
<body>
<div class="login">
	<h2>用画面记录生活每一刻</h2>
	<div class="login-top">
		<h1>欢迎登陆</h1>
		<form action="${pageContext.request.contextPath }/login" id="form2" method="post">
			<input type="text" name="username"  placeholder="请输入账号">
			<input type="password" name="password" placeholder="请输入密码">
			 <div class="forgot">
	    	<a href="#">忘记密码</a>
	    	<input type="submit" value="登录" >
	    </div>
	    </form>
	   
	</div>
	<div class="login-bottom">
		
		<h3>没有账号？ &nbsp;<a href="reg.jsp">注册</a>&nbsp 点这里</h3>
	
	</div>
</div>	



</body>
</html>