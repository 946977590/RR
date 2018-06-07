<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

 
 

</head>
<body class="main_body">
	 <!-- <li><label style="width:150px;">图片：</label><input id="file1" name="file" type="file"  onchange="fileUpload();"/><i></i></li>
<script type="text/javascript">
	function fileUpload() {
		var files = ['file1'];  //将上传三个文件 ID 分别为file2,file2,file3
		$.ajaxFileUpload( {
			url : 'fileUploadAction',     //用于文件上传的服务器端请求地址  
			secureuri : false,            //一般设置为false  
			fileElementId : files,        //文件上传空间的id属性  <input type="file" id="file" name="file" />  
			dataType : 'json',            //返回值类型 一般设置为json  
			success : function(data, status) {
				var fileNames = data.fileFileName; //返回的文件名 
				var filePaths = data.filePath;     //返回的文件地址 
				for(var i=0;i<data.fileFileName.length;i++){
					//将上传后的文件 添加到页面中 以进行下载											
					$("#pic").attr("src","${path }attached/"+filePaths[i]);	
					$("#picPath").val("attached/"+filePaths[i]);	
				}
			}
		})
	}
</script> -->



</body>
</html>