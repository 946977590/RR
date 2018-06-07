<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<title>文章添加--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/font_eolqem241z66flxr.css" media="all" />

</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote news_search">
	
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn" href="${pageContext.request.contextPath }/newslist">返回列表</a>
		</div>
		
	</blockquote>																			 <!-- 	newsId=${值}和newsId="+变量	 -->
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/updateNewssubmit?newsId=${news.newsId}"	method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">文章标题</label>
			<div class="layui-input-block">
				<input value="${news.title}" type="text" class="layui-input newsName" name="title" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			
			<div class="layui-inline">		
				<label class="layui-form-label">文章作者</label>
				<div class="layui-input-inline">
					<input value="${news.author}" type="text" class="layui-input newsAuthor" name="author" lay-verify="required" >
				</div>
			</div>
		
			 
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章类型</label>
			<div class="layui-input-block">
				<input value="${news.keyword}" type="text" class="layui-input" name="keyword" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章内容</label>
			<div class="layui-input-block">
				<textarea  name="contentAbstract" class="layui-textarea">${news.contentAbstract}</textarea>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<INPUT  type=submit class="layui-btn" value="立即提交" >
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/newsAdd.js"></script>
</body>
</html>