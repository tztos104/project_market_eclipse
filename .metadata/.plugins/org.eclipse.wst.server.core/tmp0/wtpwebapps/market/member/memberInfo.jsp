<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/validation.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container my-4">
		<h2 class="text-left mx-4 my-4">나의 정보</h2>
		<div class="row mx-5">
			<form action="/addMember.do" method="post">
				<div class="form-group row">
					<label class="col-sm-2">아이디</label>
					<div class="col-sm-3 my-2">
						<input type="text" name="mid" id="mid" readonly
						       class="form-control" value="${member.mid}" >
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">비밀번호</label>
					<div class="col-sm-3 my-2">
						<input type="password" name="passwd1" id="passwd1" readonly
							   class="form-control" value="${member.passwd}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">비밀번호 확인</label>
					<div class="col-sm-3 my-2">
						<input type="password" name="passwd2" id="passwd2" readonly
						       class="form-control" value="${member.passwd}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">성명</label>
					<div class="col-sm-3 my-2">
						<input type="text" name="mname" id="mname" readonly
						       class="form-control" value="${member.mname}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">성별</label>
					<div class="col-sm-5 my-2">
					<c:if test="${member.gender eq 'male'}">
						<label><input type="radio" name="gender" value="male" checked>남</label>
						<label><input type="radio" name="gender" value="female">여</label>
					</c:if>
					<c:if test="${member.gender eq 'female'}">
						<label><input type="radio" name="gender" value="male">남</label>
						<label><input type="radio" name="gender" value="female" checked>여</label>
					</c:if>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">생일</label>
					<div class="col-sm-3 my-2">
						<input type="text" name="birth" id="birth" readonly
							   class="form-control" value="${member.birth}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">전화번호</label>
					<div class="col-sm-3 my-2">
						<input type="text" name="phone" id="phone" readonly
						       class="form-control" value="${member.phone}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">이메일</label>
					<div class="col-sm-3 my-2">
						<input type="text" name="email" id="email" readonly
						       class="form-control" value="${member.email}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">주소</label>
					<div class="col-sm-3 my-2">
						<input type="text" name="address" id="address" readonly
						       class="form-control" value="${member.address}">
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>