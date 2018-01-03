<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--如果集合为空，则跳转到查询数据页面，再回来 --%>
<c:if test="${empty standardList }">
	<c:redirect url="DoSelectServlet"></c:redirect>
</c:if>
<%
	//取根目录
	String path = request.getContextPath();
	request.setAttribute("path", path);	
	request.setCharacterEncoding("utf-8");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>标准信息列表</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <link href="css/styles.css" rel="stylesheet">
  </head>
  	<script type="text/javascript">
		<c:if test="${!empty message}">
			alert('${message}');
		</c:if>
		
		/*设置种类的下拉框的值，搜索之后不变*/
		$(function(){
			$('#zhname').val('${param.zhname}');
		});
		
		
	</script>
	
	<%--移除增加成功的信息--%>
	<c:remove var="message" scope="session"/>
  
  <body>
  <div style="text-align:center;">标准信息列表</div>
		<table border="1">
			<form action="DoSelectServlet" method="post" name="form1">
			
			<caption>	
			<div style="text-align:right;">
				<input type="text" name="zhname" id="zhname"/>						
				<input type="submit" value="提交检索" id="find"/>&nbsp;&nbsp;
				<span><a href="add.jsp">新增标准</a></span>
				<span><a href="">删除标准</a></span>
			</div>
			</caption>
			</form>
			
				<thead>
					<tr>
						<th style="width:50px;">选择</th>
						<th>标准号</th>
						<th>中文名称</th>
						<th>版本</th>
						<th>发布日期</th>
						<th>实施日期</th>
						<th style="width:100px;">操作</th>
					</tr>
				</thead>
			
			<form action="DoDeleteServlet" method="post" name="form2">
				
				<tbody>
					
					<c:forEach items="${standardList }" var="item" varStatus="status">
						<tr class='${status.index%2==0?"light":"" }'>
							<td><input name="del" type="checkbox" value="${item.id }"></td>
							<td>${item.stdNum }</td>
							<td>${item.zhname }</td>
							<td>${item.version }</td>
							<td>${item.releaseDate }</td>
							<td>${item.implDate}</td>
							<td>
								<a href="${path }/update.jsp?petId=${item.id}">下载</a>&nbsp;					
								<a href="javaScript:void();" onclick="myDel('${item.id}');">修改</a>							
									
							</td>							
						</tr>
					</c:forEach>
					<c:remove var="Data" scope="session"/>
					<tr><td colspan = 7 style="text-align:right;"><input type="submit" id="delete" value="-删除多条数据-"></td></tr>
				</tbody>
				
			</form>
		</table>
		
<div id="page">


总条数：${pageInfo.total}条 &nbsp;&nbsp;
<%--当前页/总页数 --%>
当前页【${pageInfo.pageNum}/${pageInfo.pages}】
<c:choose>
	<%--当前页面是第一页时 --%>
	<c:when test="${pageInfo.pageNum==1}">
		首页
               上一页 
	</c:when>
	<c:otherwise>
		<a href="${path}/standard/DoSelectServlet?currentPage=1&zhname=${param.zhname}">首页</a> 
		<a href="${path}/standard/DoSelectServlet?currentPage=${pageInfo.pageNum-1}&zhname=${param.zhname}">上一页 </a>
	</c:otherwise>
</c:choose>

<c:choose>
	<%--当前页面是最后一页的时候 --%>
	<c:when test="${pageInfo.pageNum==pageInfo.pages}">
		下一页
		末页
	</c:when>
	<c:otherwise>			
		
		<a href="${path}/standard/DoSelectServlet?currentPage=${pageInfo.pageNum+1}&zhname=${param.zhname}">下一页 </a>		
		<a href="${path}/standard/DoSelectServlet?currentPage=${pageInfo.pages}&zhname=${param.zhname}">末页</a>
		
	</c:otherwise>
</c:choose>
</div>
						
	<script>
		$(function(){
			// 点击“删除”，提交表单的时候
			$("form[name='form2']").submit(function(){
							
				// 获取当前勾选的checkbox
				var ckbox = $("table tbody input[type=checkbox]:checked");
				
				// 如果没有选中项
				if(ckbox.length<=0){
					alert("请选择需要删除的标准");
					return false;
				}
				
				return confirm("您确定要删除标准吗？");
				
			});
				
			
		});
		
		
		
	</script>

  </body>
</html>




