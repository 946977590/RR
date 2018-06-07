<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>

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
	<form class="layui-form" style="width:80%;" action="${pageContext.request.contextPath }/addMember"	method="post" >
		<div class="layui-form-item">
			<label class="layui-form-label">会员昵称</label>
			<div class="layui-input-block">
				<input type="text" name="memName" class="layui-input userName" lay-verify="required" placeholder="请输入登录名">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱账号</label>
			<div class="layui-input-block">
				<input type="text" name="memAccount" class="layui-input userEmail" lay-verify="email" placeholder="请输入账号">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="password" name="memPassword" class="layui-input userEmail" lay-verify="required" placeholder="请输入密码">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" name="memPassword" class="layui-input userEmail" lay-verify="required" placeholder="请输入密码">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
			    <label class="layui-form-label" >性别</label>
			    <div class="layui-input-block userSex">
			      	<input type="radio" name="memSex" value="男" title="男" checked>
			      	<input type="radio" name="memSex" value="女" title="女">
			      	<input type="radio" name="memSex" value="保密" title="保密">
			    </div>
		    </div>
		 <div class="layui-inline">
			    <label class="layui-form-label">会员等级</label>
				<div class="layui-input-block">
					   <%-- <select name="memberCategory.memwid" class="userGrade" >
				     <c:forEach items="${listMemberCategory }" var="c">
							<option value="${c.memwid }">${c.memType }</option>
						</c:forEach>
				    </select>    --%>
				  <input type="text"  class="layui-input userName"  name="memCategory.memwid" class="userGrade" > 
				</div>
		</div> 
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">个性签名</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入个性签名" class="layui-textarea linksDesc" name="memSign"></textarea>
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
</script>
		<%-- <script type="text/javascript"> 
		$(document).ready(function () {  
            var url = "${pageContext.request.contextPath }/listMemberCategory.action";  
            $.ajax({  
                type:'get',  
                url:url,  
                dataType: 'json',  
                success:function(data){  
                    $.each(data,function(i,listMemberCategory){  
                    	$("#memwid").append("<option value='"+listMemberCategory.memwid+"'>"+listMemberCategory.memType+"</option>");
                    })  
                }  
            })
        })  
    </script>  --%>
</body>
</html>