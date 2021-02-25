	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/customer_main.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/idFind.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/mypage/quitMember.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />

	<div class="ud">
		<div class="img_area">
			<img src="/mg/resources/image/Logo1.png">
		</div>
		<h1>
			모닝글로리 <strong>회원탈퇴</strong>
		</h1>

		<hr class="hr">
		<br>
		<h2 align="center" class="update">* 필수입력항목</h2>
		<form id="updateForm" action="" method="post">
			<div id="personInfo">
				<table align="center" class="person-tb">
					<tbody>
						<tr>
							<td width="200px" class="red">* 아이디</td>
							<td><input type="text" maxlength="13" name="memberId"
								id="memberId" class="a"
								value="${ sessionScope.loginMember.id }"></td>

						</tr>
						<tr>
							<td class="red">* 비밀번호</td>
							<td><input type="password" maxlength="13" name="memberPwd"
								id="memberPwd" class="a"></td>

						</tr>
						<tr>
							<td class="red">* 비밀번호 확인</td>
							<td><input type="password" maxlength="13" name="memberPwd2"
								class="a"></td>

						</tr>
					</tbody>
				</table>
				<br>
				<br>
				<div class="btns" align="center">
					<input type="submit" value="탈퇴하기" class="btn-or"
						onclick="${ pageContext.servletContext.contextPath }/mypage/quitMember"> <input
						type="reset" value="메인으로" class="btn-yg" id="goMain">
				</div>

			</div>
			<!-- 회원 정보 수정 영역 끝 -->
		</form>
		</div>


		<jsp:include page="../common/footer.jsp" />
</body>
</html>