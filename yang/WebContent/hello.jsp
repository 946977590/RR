<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页</title>

<script src="staticc/js/jquery.min.js" type="text/javascript"></script>

</head>

<style type="text/css">
html *{padding:0;margin:0;font-family: Arial, Verdana, Helvetica, sans-serif;}
.nav{margin-top:10px;}
.nav *{text-decoration:none;font-size:9pt;}
.nav * a:hover{background-color:#82ce18;/* 鼠标经过时的红色背景，可自定义 */}
.menu{list-style:none;height:40px;width:100%;background-color:#333;margin-top:20px;}
.nav{list-style:none;height:40px;width:900px;margin:0 auto;background-color:#333;}
.nav li{float:left;border-left:1px solid #4a4a4a;border-right:1px solid #242424;border-top:1px solid #4a4a4a;border-bottom:1px solid #242424;position:relative;}
.nav li a{color:#fff;height:38px;line-height:38px;font-weight:bold;padding:0 20px;blr:expression(this.onFocus=this.close());blr:expression(this.onFocus=this.blur());display:inline-block;}
.nav li a:focus{-moz-outline-style: none; }
.nav li .sub-nav{position:absolute;top:39px;left:-1px;list-style:none;background-color:#333;display:none;}
.nav li .sub-nav li{text-align:center;clear:left;width:140px;height:35px;line-height:35px;position:relative;}
.nav li .sub-nav li a{height:34px;line-height:34px;width:138px;padding:0;display:inline-block;}
</style>

<script type="text/javascript">
	$(function(){
		$(".nav>li").hover(function(){
			$(this).children('ul').stop(true,true).show(300);
		},function(){
			$(this).children('ul').stop(true,true).hide(300);
		})
	})
</script>
<body>

<div id="content">
	
<!--DEMO start-->
	<div class="menu">
		<ul class="nav">
			<li><a href="#">jQuery特效</a>
				<ul class="sub-nav">
					<li><a href="#">Jquery插件</a></li>
					<li><a href="#">Jquery学堂</a></li>
					<li><a href="#">学习资料库</a></li>
					<li><a href="#">QQ群堂</a></li>
					<li><a href="#">TAGS标签</a></li>
					<li><a href="#">在线留言</a></li>
				</ul>
			</li>
			<li><a href="#">Jquery学堂</a>
				<ul class="sub-nav">
					<li><a href="#">Jquery插件</a></li>
					<li><a href="#">Jquery学堂</a></li>
					<li><a href="#">学习资料库</a></li>
					<li><a href="#">QQ群堂</a></li>
					<li><a href="#">TAGS标签</a></li>
					<li><a href="#">在线留言</a></li>
				</ul>
			</li>
			<li><a href="#">学习资料库</a>
				<ul class="sub-nav">
					<li><a href="#">Jquery插件</a></li>
					<li><a href="#">Jquery学堂</a></li>
					<li><a href="#">学习资料库</a></li>
					<li><a href="#">QQ群堂</a></li>
					<li><a href="#">TAGS标签</a></li>
					<li><a href="#">在线留言</a></li>
				</ul>
			</li>
			<li><a href="#">QQ群堂</a>
				<ul class="sub-nav">
					<li><a href="#">Jquery插件</a></li>
					<li><a href="#">Jquery学堂</a></li>
					<li><a href="#">学习资料库</a></li>
					<li><a href="#">QQ群堂</a></li>
					<li><a href="#">TAGS标签</a></li>
					<li><a href="#">在线留言</a></li>
				</ul>
			</li>
			<li><a href="#">TAGS标签</a>
				<ul class="sub-nav">
					<li><a href="#">Jquery插件</a></li>
					<li><a href="#">Jquery学堂</a></li>
					<li><a href="#">学习资料库</a></li>
					<li><a href="#">QQ群堂</a></li>
					<li><a href="#">TAGS标签</a></li>
					<li><a href="#">在线留言</a></li>
				</ul>
			</li>
			<li><a href="#">在线留言</a>
				<ul class="sub-nav">
					<li><a href="#">Jquery插件</a></li>
					<li><a href="#">Jquery学堂</a></li>
					<li><a href="#">学习资料库</a></li>
					<li><a href="#">QQ群堂</a></li>
					<li><a href="#">TAGS标签</a></li>
					<li><a href="#">在线留言</a></li>
				</ul>
			</li>
		</ul>
	</div>
<!--DEMO end-->

</div>

</body>
</html>