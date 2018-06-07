<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加会员</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript">
function check() {		
	var n1=form1.memName.value;
	var n2=form1.memPhone.value;
	var n3=form1.memAdress.value;
	var n4=form1.memLevel.value;
	if (n1==""){
		alert("请输入会员名称!");
		return false;
		}
		if (n2==""){
		alert("请输入联系电话!");
		return false;
		}
		if (n3==""){
		alert("请输入来源地址!");
		return false;
		}
		if (n4==""){
			alert("请输入会员等级!");
			return false;
			}
		return true;
		}
function validate(f){
	if(! ( /^\w{2,10}$/.test(f.memName.value)  )   ){
		alert("会员名必须是2~10位！");
		f.memName.focus();
		return false;
	}
	if(! ( /^\w{2,10}$/.test(f.memPhone.value)  )   ){
		alert("联系电话必须是2~10位！");
		f.memPhone.focus();
		return false;
	}
	if(! ( /^\w{2,10}$/.test(f.memAdress.value)  )   ){
		alert("来源地址必须是2~10位！");
		f.memAdress.focus();
		return false;
	}
	if(! ( /^\w{2,10}$/.test(f.memLevel.value)  )   ){
		alert("会员必须是2~10位！");
		f.memLevel.focus();
		return false;
	}
}		
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/addMember"	method="post" onsubmit="return validate(this)">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>当前位置：会员管理 &gt; 添加会员</TD>
					</TR>
					<TR>
						<TD height=2></TD>
					</TR>
				</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>									    
	<TR>
		<td>会员名称：</td>
		<td>
		<INPUT class=textbox type="text" style="WIDTH: 180px" maxLength=50 name="memName">
		</td>
		<td>会员级别 ：</td>
		<td>
		<INPUT class=textbox type="text" style="WIDTH: 180px" maxLength=50 name="memLevel">
		</td>
	</TR>
	
	
	<TR>																
		<td>联系方式 ：</td>
		<td>
		<INPUT class=textbox type="text" style="WIDTH: 180px" maxLength=50 name="memPhone">
		</td>
		<td>来源地址 ：</td>
		<td>
		<INPUT class=textbox type="text" style="WIDTH: 180px" maxLength=50 name="memAdress">
		</td>
	</TR>
		<tr><td rowspan=2>
		<INPUT  type=submit value=" 保存 " onClick="return check()">
		</td></tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
