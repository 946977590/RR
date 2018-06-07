<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/main.css" media="all" />
</head>
<body class="main_body">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main">
				<a href="#" class="logo">乐享系统后台管理</a>
				
			  
			    <!-- 顶部右侧菜单 -->
			    <ul class="layui-nav top_menu">
			    	<li class="layui-nav-item showNotice" id="showNotice" pc>
						<a href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
					</li>
			    	
					<li class="layui-nav-item" pc>
						<a href="javascript:;">
							<img src="images/face.jpg" class="layui-circle" width="35" height="35">
							<cite><s:property value="#session.userName" /></cite>
						</a>
						<dl class="layui-nav-child">
							<dd><a href="admin/user/userinfo.jsp" data-url="admin/user/userinfo.jsp"><i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a></dd>
							<dd><a href="javascript:;" data-url="<%=request.getContextPath()%>admin/user/changePwd.html"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a></dd>
							<dd><a href="javascript:;"  onclick="logout();"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd>
						</dl> 
					</li>
					
					<li class="layui-nav-item lockcms" pc>
						<a href="javascript:;"><i class="iconfont icon-lock1"></i><cite>锁屏</cite></a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<div class="user-photo">
				<a class="img" title="我的头像" ><img src="images/face.jpg"></a>
				<p>你好！<span class="userName"><s:property value="#session.userName" /></span>, 欢迎登录</p>
			</div>
			<div class="navBar layui-side-scroll"></div>
		</div>
		
		
		
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab marg0" lay-filter="bodyTab" >
				<ul class="layui-tab-title top_tab" >
					<li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>后台首页</cite></li>
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show">
						<iframe src="${pageContext.request.contextPath }/newslist"></iframe>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 锁屏 -->
	<div class="admin-header-lock" id="lock-box" style="display: none;">
		<div class="admin-header-lock-img"><img src="images/face.jpg"/></div>
		<div class="admin-header-lock-name" id="lockUserName">请叫我马哥</div>
		<div class="input_btn">
			<input type="password" class="admin-header-lock-input layui-input" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />
			<button class="layui-btn" id="unlock">解锁</button>
		</div>
		<p>请输入“123456”，否则不会解锁成功哦！！！</p>
	</div>
		
		<!-- 底部 -->
		<div class="layui-footer footer">
			<p>copyright @2018 乐享系统</a>　　<a onclick="donation()" class="layui-btn layui-btn-danger l·ayui-btn-small">联系作者</a></p>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/staticc/js/nav.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/staticc/js/leftNav.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/staticc/js/index.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/staticc/js/bodyTab.js"></script>
	
	<script type="text/javascript">
	function logout(){
		if(window.confirm("您确定要退出吗？"))
		{
		   location.href="${pageContext.request.contextPath }/logout.action";
		 }else{
			 return false;
		 }
	}
		
	</script>
</body>
</html>