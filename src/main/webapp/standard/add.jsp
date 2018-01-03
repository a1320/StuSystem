<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增标准信息</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<style>
td {
	border: solid 1px;
}

</style>

<script type="text/javascript">
 

	function myAdd(){
		
		/* 
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
		var reg = /^\d{4}-\d{2}-\d{2}$/;
		reg = /^((19\d{2})|(20\d{2}))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
		if(!reg.test(birthday)){
			alert("日期格式不正确");
			document.getElementById("birthday").focus();
			return;
		}
		
		*/
		$('#addForm').submit();
	}
	
	
	

</script>

<script type="text/javascript">
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if>
</script>
<body>
	<c:remove var="message" scope="session" />
	<div align="center">
		<h2>新增标准信息</h2>
	</div>
	<div align="center">
		<form id="addForm" action="AddServlet" method="post" enctype="multipart/form-data">
			<div>
				<table>
					<tr>
						<td align="right">* 标准号：</td>
						<td><input type="text" name="stdNum" id="stdNum" size="50"/></td>
					<tr>
					<tr>
						<td align="right">* 中文名称：</td>
						<td><input type="text" name="zhname" id="zhname" /></td>
					<tr>
					<tr>
						<td align="right">* 版本：</td>
						<td><input type="text" name="version" id="version" /></td>
					<tr>
					<tr>
						<td align="right">* 关键词：</td>
						<td><input type="text" name="keys" id="keys" /></td>
					<tr>
					<tr>
						<td align="right">* 发布日期(yyyy-MM-dd)：</td>
						<td><input type="text" name="releaseDate" id="releaseDate" /></td>
					<tr>
					<tr>
						<td align="right">* 实施日期(yyyy-MM-dd)：</td>
						<td><input type="text" name="implDate" id="implDate" /></td>
					<tr>
					<tr>
						<td align="right">* 附件：</td>
						<td>
						<label>附件1：</label>
						<input type="file" name="uploadFile" />
						<!-- 
							<label >附件2：</label>
							<input type="file" name="uploadFile" />
						 -->
						</td>
					<tr>
					<tr>
						<td></td>
						<td><input type="button" value="保存" onclick="myAdd();" /> <input
							type="reset" value="取消" /></td>
					<tr>
				</table>
			</div>
		</form>
	</div>

</body>
</html>