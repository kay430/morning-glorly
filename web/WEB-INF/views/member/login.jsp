<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Morning Glory</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/mg/resources/css/MorningGloryMain.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/mg/resources/js/event.js"></script>
</head>
<body>
 	<jsp:include page="../common/header.jsp"/>

	<div class="container">
		<!-- 로그인 영역 -->
		<div class="login-area">
		
			<!-- 로그인이 필요한 경우 -->
			<c:if test="${ empty sessionScope.loginMember }">
				<form id="loginForm" action="${ pageContext.servletContext.contextPath }/member/login" method="post">
					<table>
						<tr>
							<td><label class="text">ID : </label></td>
							<td><input type="text" name="memberId"></td>
						</tr>
						<tr>
							<td><label class="text">PWD : </label></td>
							<td><input type="password" name="memberPwd"></td>
						</tr>
					</table>
					<div class="btns" align="right">
						<input type="button" class="btn btn-yg" value="회원가입" id="regist2">
						<input type="submit" class="btn btn-or" value="로그인" id="login2">
					</div>
				</form>
			</c:if>
			
			<!-- 로그인이 되어 있는 경우 -->
			<c:if test="${ !empty sessionScope.loginMember }">
				<h3><c:out value="${ sessionScope.loginMember.nickName }"/>님의 방문을 환영합니다</h3>
				<div class="btns">
						<input type="button" class="btn btn-yg" value="정보수정" id="update">
						<input type="submit" class="btn btn-or" value="로그아웃" id="logout">
					</div>
			</c:if>
		
		</div>	<!-- 로그인 영역 끝 -->
	</div>

	<jsp:include page="../common/footer.jsp"/> 
</body>
</html>