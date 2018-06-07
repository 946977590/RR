<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function check() {		
	var n1=form1.memName.value;
	var n2=form1.memPhone.value;
	var n3=form1.memAdress.value;
	var n4=form1.memLevel.value;
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
		if (n4==""){
			alert("请输入确认密码!");
			return false;
			}
		return true;
		}
</script>
<body>
	<form action="${pageContext.request.contextPath }/addMember" id="form1"	method="post">
		会员名称<input type="text" name="memName">
		会员级别<input type="text" name="memLevel">
		联系方式 <input type="text" name="memPhone">
		来源地址<input type="text" name="memAdress">
		<input type="submit" value="提交 " onClick="return check()">
	</form>
</body>
</html>