<%@page import="com.gdglc.mybatis.bean.Pet"%>
<%@page import="com.gdglc.mybatis.servlet.PublicDemo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新宠物信息</title>
<%
	String path = request.getContextPath();
	//设置编码格式，解决post的乱码问题
	request.setCharacterEncoding("utf-8");
	//获取请求参数
	String idStr = request.getParameter("petId");

	//封装业务方法参数
	Integer id = Integer.parseInt(idStr);
	
	//调用业务方法，获取结果
	//按ID查找对象
	Pet info = PublicDemo.getPetService().selectByPrimaryKey(id);
	//跟进跳转方式及业务需要，把业务方法的返回结果设置到某个作用域
	request.setAttribute("info", info);
%>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<script type="text/javascript">
	/*登录验证*/
	function myUpdate(){
		var petName = $("#petName").val();
		var petBreed = $("#petBreed").val();
		var birthday = $("#birthday").val();
		if(!petName){
			alert("昵称不能为空!");
			document.getElementById("petName").focus();
			return;
		}
		if(!petBreed){
			alert("请选择品种!");
			document.getElementById("petBreed").focus();
			return;
		}
		if(!birthday){
			alert("出生日期不能为空!");
			document.getElementById("birthday").focus();
			return;
		}
		//日期格式的
		<%--var reg = /^\d{4}-\d{2}-\d{2}$/;--%>
		
		var reg = /^((19\d{2})|(20\d{2}))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
		if(!reg.test(birthday)){
			alert("日期格式不正确");
			document.getElementById("birthday").focus();
			return;
		}
		$('#updateForm').submit();
	}
	
	/*重置*/
	function myReset(){					
		document.getElementById("petName").value="";
		document.getElementById("petBreed").value="";
		document.getElementById("birthday").value="";
		document.getElementById("description").value="";
		
		//如何设置单选框为默认值？
		document.getElementById("petSex").value="";
		
	}
	
	
	/*设置种类的下拉框的值*/
	$(function(){
		$('#petBreed').val('${info.petBreed}');		
	});


</script>

<script type="text/javascript">
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if>
</script>
<body>
	<c:remove var="message" scope="session"/>
	<div align="center"><h2>宠物的基本信息</h2></div>
	<div align="center">
		<form id="updateForm" action="update" method="post">
			<div>
				<table>
					<tr>
						<input type="hidden" name="petId" value="${info.petId }">
						<td align="right">昵称：</td>
						<td><input type="text" value="${info.petName }"name="petName" id="petName"/></td>
					<tr>
					<tr>
						<td align="right">品种：</td>
						<td>
							<select name="petBreed" id="petBreed">
							<option value="">请选择</option>
							<option value="狗">狗</option>
							<option value="猫">猫</option>
							<option value="鸟">鸟</option>
							<option value="猪">猪</option>
						</select>
						</td>
					<tr>
					<tr>
						<td align="right">性别：</td>
						<td>
							<c:if test="${info.petSex =='雄'}">
								<input type="radio" name="petSex" checked="checked" value="雄"/>雄 
								<input type="radio" name="petSex" value="雌"/>雌 
							</c:if>
							<c:if test="${info.petSex =='雌'}">
								<input type="radio" name="petSex"  value="雄"/>雄 
								<input type="radio" name="petSex" checked="checked" value="雌"/>雌 
							</c:if>
						</td>
					<tr>
					<tr>
						<td align="right">出生日期：</td>
						<td><input type="text" value="${info.birthday}" name="birthday" id="birthday"/>yyyy-mm-dd</td>
					<tr>
					<tr>
						<td align="right">宠物描述：</td>
						<td>
							<textarea rows="3" cols="40" name="description" id="description">${info.description}</textarea>
						</td>
					<tr>
					<tr>
						<td></td>
						<td>
							<input type="button" value="提交" onclick = "myUpdate();"/>
							<input type="reset" value="重置" />
						</td>
					<tr>
				</table>
			</div>
		</form>
	</div>
	
</body>
</html>