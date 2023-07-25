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
		<h2 class="text-left mx-4 my-4">주문 완료</h2>
		<h2 class="alert alert-danger">주문해 주셔서 감사합니다.</h2>
		<p>주문은 ${shipping_shippingDate}일에 배송될 예정입니다.
		<p>주문번호: ${shipping_cartId}
		<p><a href="/productList.do" class="btn btn-secondary">&laquo; 상품 목록</a>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>