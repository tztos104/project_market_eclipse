<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<%
				String error = request.getParameter("error");
				if(error != null){
					out.println("<div class='alert alert-danger'>");
					out.println("아이디와 비밀번호를 확인해 주세요");
					out.println("</div>");
				}
			%>
			<h3>Please Log In</h3>
			<form action="j_security_check" method="post">
				<div class="form-group my-3">
					<input type="text" name="j_username" class="form-control"
					       placeholder="ID" required autofocus>
				</div>
				<div class="form-group my-3">
					<input type="password" name="j_password" class="form-control"
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