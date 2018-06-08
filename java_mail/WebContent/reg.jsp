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

</head>
<script type="text/javascript"> 
function check()
{
	var n1=form1.username.value;
	var n2=form1.password.value;
	var n3=form1.repassword.value;
if (n1==""){
alert("请输入登录账号!");
return false;
}
if (n2==""){
alert("请输入登录密码!");
return false;
}
if (n3==""){
alert("请输入确认密码!");
return false;
}
if (n2!=n3){
alert("对不起!确认密码不等于登录密码");
return false;
}
 	 
return true; 
}
function validate(f){
	if(! ( /^\w{4,10}$/.test(f.username.value)  )   ){
		alert("账号必须是4~10位！");
		f.username.focus();
		return false;
	}
	if(! ( /^\w{4,10}$/.test(f.password.value)  )   ){
		alert("密码必须是4~10位！");
		f.password.focus();
		return false;
	}
}
</script> 



<body>
<div class="login">
	<h2>用画面记录生活每一刻</h2>
	<div class="login-top">
		<h1>Register</h1>
		<form action="register" id="form1" method="post" onsubmit="return validate(this)">
			<input type="text" name="username"  placeholder="请输入账号">
			<input type="password" name="password" placeholder="请输入密码">
			<input type="password" name="repassword" placeholder="确认密码">
			 <div class="forgot">
	    	<input type="submit"  value="开始注册" onClick="return check()">
	    </div>
	    </form>
	   
	</div>
	<div class="login-bottom">
		<h3>已有账号 &nbsp;<a href="login.jsp">登陆</a>&nbsp 点这里</h3>
	</div>
</div>
<%-- <script type="text/javascript" src="<%=basePath%>/staticc/js/jquery.min.js"></script>
 --%>
 </body>
</html>