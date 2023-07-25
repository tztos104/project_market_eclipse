<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-4">
		<h2 class="alert alert-danger">주문이 취소되었습니다.</h2>
		
		<p><a href="/productList.do" class="btn btn-secondary">&laquo; 상품 목록</a>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>