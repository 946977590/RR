<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>用户总数--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/staticc/css/css/user.css" media="all" />
</head>
<body class="childrenBody">
<form action="${pageContext.request.contextPath }/listmember" id="newsListForm" name="ff" method="post"> 
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn" href="${pageContext.request.contextPath }/newslist">返回列表</a>
		</div>
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal usersAdd_btn" href="${pageContext.request.contextPath }/admin/member/memberAdd.jsp">添加用户</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux">　本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
		</div>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="42">
				<col width="20%">
				<col width="20%">
				<col width="14%">
				<col width="20%">
				<col width="17%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>会员昵称</th>
					<th>邮箱账户</th>
					<th>性别</th>
					<th>会员等级</th>
					<th>操作</th>
				</tr>
				<s:iterator value="#request.listmember" id="member">
	<TR
		style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
		<td>
			
		</td>
		<TD>
			<s:property value="#member.memName"/>
		</TD>
		<TD>
			<s:property value="#member.memAccount"/>
		</TD>
		<TD>
			<s:property value="#member.memSex"/>
		</TD>
		<TD>
			<s:property value="#member.memberCategory.memwid"/>
		</TD>
		
		<TD>
			<a href='${pageContext.request.contextPath }/editnews.action?newsId=<s:property value="newsId"/>'>拉黑</a> &nbsp;|&nbsp;
			<a href='#' onclick="del(<s:property value="newsId"/>)">删除</a>
		</TD>
	</TR>
	</s:iterator>
			<%-- <tr>
					<td colspan="7" align="center">
					<div class="pagination">					
					第<s:property value="pb2.currentPage" />页
						&nbsp;&nbsp; 共<s:property value="pb2.totalPage" /> 页
						&nbsp;&nbsp; 共<s:property value="pb2.count" />条信息
					 <div style="height:10px;"></div>
					 <s:if test="pb2.currentPage == 1"> 首页&nbsp;&nbsp;上一页 </s:if>
						<s:else>
							<a href='#' onclick="fy(1)">首页</a> 
							<a href='#' onclick="fy(<s:property value="pb2.currentPage - 1"/>)">上一页</a>
						</s:else> 
						<s:if test="pb2.currentPage != pb2.totalPage">
							<a href='#'
								onclick="fy(<s:property value="pb2.currentPage + 1"/>)">下一页</a>
								<a	href='#' onclick="fy(<s:property value="pb2.totalPage"/>)">尾页</a>
						</s:if> 
						<s:else>下一页&nbsp;&nbsp;尾页</s:else> &nbsp;&nbsp;

						跳转至 <input type="text" style="height:22px;border: 1px solid #888;width:30px;border-radius: 0.2rem;" name="page" id="page"> 页 <a
						href='#' onclick="validate()">跳转</a>
					
				</div>
					</td>
					</tr> --%>
		    </thead>
		    <tbody class="users_content"></tbody>
		</table>
	</div>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="allUsers.js"></script>
	 <script type="text/javascript">
		
		 function fy(page)
        {
			 var form=document.getElementById("newsListForm");
			 form.action="${pageContext.request.contextPath}/newslist.action?currentPage=" + page ;
			 form.submit();
 		   //window.document.location.href = "${pageContext.request.contextPath}/admin/findInfosByPage.action?currentPage=" + page 		  
        }
		function validate()
        {
            var page = document.getElementById("page").value;
            if(page > <s:property value="#request.pb.totalPage"/> || page <= 0 )
            {
                alert("你输入的页数大于最大页数或小于最小页面，页面将跳转到首页！");
                fy(1)
             }else{
            	fy(page)
           }
        }
	</script>
	</script>
	   <script type="text/javascript">
		function del(newsId){
			if(window.confirm("您确定要删除吗？"))
			{
			   location.href="${pageContext.request.contextPath }/deletenews.action?newsId="+newsId;
			 }
		}
	</script>
</body>
</html>