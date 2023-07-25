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
	<div class="container my-4">
		<h2 class="text-left mx-4 my-4">회원 목록</h2>
		<div style="padding-top: 50px"> 
			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<th>번호</th><th>아이디</th><th>이름</th><th>이메일</th><th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberList}" var="member" varStatus="i">
					<tr>
						<td class="text-center">${i.index}</td>
						<td class="text-center">${member.mid}</td>
						<td class="text-center">${member.mname}</td>
						<td class="text-center">${member.email}</td>
						<td class="text-center">${member.regDate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>