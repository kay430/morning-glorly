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
	href="/mg/resources/css/mymapge/quitMember.css">
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
								id="memberId" class="a" readonly
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
						onclick="return movePath('deleteMember')"> <input
						type="reset" value="메인으로" class="btn-yg" id="goMain">
				</div>

			</div>
			<!-- 회원 정보 수정 영역 끝 -->
		</form>
		</div>

		<script
			src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
			const $searchZipCode = document.getElementById("searchZipCode");

			$searchZipCode.onclick = function() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								console.log(data.zonecode);
								console.log(data.address);

								document.getElementById("zipCode").value = data.zonecode;
								document.getElementById("address1").value = data.address;
								document.getElementById("address2").focus();
							}
						}).open();
			}
		</script>

		<script>
			//어떤의도로 눌럿는지 intent라는 변수를 하나 만든다
			function movePath(intent) {

				const $form = document.getElementById("updateForm");
				//비밀번호를 입력해야 회원수정이 되기위해서 비밀번호를 꼭 입력하라는 코드를 쓴다.
				//아이디가 memberPwd에 있는 value값을 const passwordValue 값에 넣는다
				const passwordValue = document.getElementById("memberPwd").value;

				//조건문으로 생성하여 비밀번호가없을떄 입력하라고하기위해서 코드작성
				if (!passwordValue || passwordValue === "") {
					alert("비밀번호를 입력해주세요");
					document.getElementById("memberPwd").focus();
				}
				//let requsetPath 초기화해준다
				let requestPath = "${ pageContext.servletContext.contextPath }";

				//swtich문을 이용해 변수 intent에 어떠한값이 들어가냐에따라 다르게 설정
				switch (intent) {
				case "updateMember":
					requestPath += "/member/update";
					break;
				case "deleteMember":
					requestPath += "/member/delete";
					break;
				}
				//위에 $form쪽에 아직 어떠한 행동을 하라는 action주지않기때문에 마지막에 action정보 제공
				//action을 할경우 경로 설정후 전달
				//버튼에 따라서 경로를 바꿔주는 방법
				// 아이디찾기나 비밀번호찾기도 이런걸 써야할거같다 참고하자
				$form.action = requestPath;
				$form.submit();
			}
		</script>

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<jsp:include page="../common/footer.jsp" />
</body>
</html>