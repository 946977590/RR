<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>会员添加--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<style type="text/css">
		.layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
		@media(max-width:1240px){
			.layui-form-item .layui-inline{ width:100%; float:none; }
		}
	</style>
</head>
<body class="childrenBody">
		
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn" href="${pageContext.request.contextPath }/newslist">返回列表</a>
		</div>
	<form class="layui-form" style="width:80%;" action="${pageContext.request.contextPath }/addMemberCategory"	method="post" >
		
		<div class="layui-form-item">
			<label class="layui-form-label">类型id</label>
			<div class="layui-input-block">
				<input type="text" name="memlid" class="layui-input userName"  placeholder="类型id">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">会员类型</label>
			<div class="layui-input-block">
				<input type="text" name="memType" class="layui-input userName"  placeholder="会员类型">
			</div>
		</div>
		
	
		<div class="layui-form-item">
			<div class="layui-input-block">
				<INPUT  type=submit class="layui-btn" lay-filter="addUser" value="立即提交">
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="addUser.js"></script>
</body>
</html>