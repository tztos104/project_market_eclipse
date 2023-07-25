<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 편집</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-4">
		<h3 class="text-left mx-4 my-4">상품 편집</h3>
		<div class="row mx-5" align="center">
			<c:forEach items="${productList}" var="product">
			<div class="col-4">
			    <img src="./upload/${product.productImage}" style="width: 100%">
				<h3 class="my-2">${product.pname}</h3>
				<p>${product.description}</p>
				<p>${product.unitPrice}원</p>
				<p>
					<!-- edit이 update면 수정 버튼 -->
					<c:if test="${edit eq 'update'}">
						<a href="/updateProductForm.do?productId=${product.productId}"
						   class="btn btn-success">수정 &raquo;</a>
					</c:if>
					<!-- edit이 delete면 삭제 버튼 -->
					<c:if test="${edit eq 'delete'}">
						<a href="/deleteProduct.do?productId=${product.productId}&edit=${edit}"
						   class="btn btn-danger"
						   onclick="return confirm('정말로 삭제하시겠습니까?')">삭제 &raquo;</a>
					</c:if>
				</p>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>