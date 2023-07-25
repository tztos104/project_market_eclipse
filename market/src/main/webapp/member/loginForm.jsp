<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-3" align="center">
			<div class="col-4">
				<h3>Please Log In</h3>
				<c:if test="${not empty error}">
					<div class='alert alert-danger'>
						<span>${error}</span>
					</div>
				</c:if>
				<form action="/processLogin.do" method="post">
					<div class="form-group my-3">
						<input type="text" name="mid" class="form-control"
						       placeholder="ID" required autofocus>
					</div>
					<div class="form-group my-3">
						<input type="password" name="passwd" class="form-control"
						       placeholder="Password" required>
					</div>
					<div class="d-grid">
					  <button class="btn btn-success" type="submit">로그인</button>
					</div>
				</form>
			</div>
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>