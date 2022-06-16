<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<script src="http://localhost:8080/Book_City/jquery-1.7.2.js"></script>
		<script type="text/javascript" >
		$(function () {
			//给删除a标签绑定单机事件
			$(".deleteClass").click(function () {
				//返回ture就是确认，false就是取消
				return confirm("你确定要删除【 "+ $(this).parent().parent().find("td:first").text()  +" 】吗？");//this对象就是当然响应事件的dom对象
				// 因为：return false 就是阻止元素的默认行为=不提交
			})
		})

	</script>
<meta charset="UTF-8">
<title>图书管理</title>
	<link type="text/css" rel="stylesheet" href="http://localhost:8080/Book_City/static/css/style.css" >

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="http://localhost:8080/Book_City/static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="book_manager.jsp">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="../../index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="http://localhost:8080/Book_City/manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
					<td><a class="deleteClass" href="http://localhost:8080/Book_City/manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>

			</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="http://localhost:8080/Book_City/pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>

		<div id="page_nav">
			<%--大于第一页才显示首页和上一页--%>
			<c:if test="${requestScope.page.pageNo > 1}">
				<a href="http://localhost:8080/Book_City/manager/bookServlet?action=page&pageNo=1">首页</a>
				<a href="http://localhost:8080/Book_City/manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
			<a href="#">3</a>
			【${requestScope.page.pageNo}】
			<a href="#">5</a>
				<%--最后一页不显示--%>
			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal }">
				<a href="http://localhost:8080/Book_City/manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="http://localhost:8080/Book_City/manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>
			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="4" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">
				<script type="text/javascript">

					$(function () {
						$("#searchPageBtn").click(function (){
							var pageNo = $("#pn_input").val();
							/*跳转*/
							location.href = "http://localhost:8080/Book_City/manager/bookServlet?action=page&pageNo=" + pageNo;
						})
					})


				</script>

		</div>

	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>