<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~ </title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/bootstrap.js"></script>

</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-3">
		<h1 class="alert-danger">요청하신 페이지를 찾을 수 없습니다.</h1>
		<p><%=request.getRequestURL()  %><%=request.getQueryString() %>
		<p><a href="/productList.do" class="btn btn-secondary">상품 목록</a>
	</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>