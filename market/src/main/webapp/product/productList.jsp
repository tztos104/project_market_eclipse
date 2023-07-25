<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-4">
		<h2 class="text-left mx-4 my-4">상품 목록</h2>
		<div class="row mx-5" align="center">
			<c:forEach items="${productList}" var="product">
			<div class="col-4">
				<c:if test="${not empty product.productImage}">
					<img src="upload/${product.productImage}" style="width:100%">
					<h3>${product.pname}</h3>
					<p>${product.description}
					<p>${product.unitPrice}
				</c:if>
				<c:if test="${empty product.productImage}">
					<h3>${product.pname}</h3>
					<p>${product.description}
					<p>${product.unitPrice}
				</c:if>
				<p><a href="/productInfo.do?productId=${product.productId}" 
				   class="btn btn-secondary" role="button">상세 정보 &raquo;</a>
			</div>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>