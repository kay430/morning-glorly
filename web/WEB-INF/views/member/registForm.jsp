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
</head>
<body>
 	<jsp:include page="../common/header.jsp"/>

	<div class="container">
			<!-- 회원 가입 양식 영역 -->
	<div class="outer outer-member-insert">
		<br>
		<h2 align="center">회원가입</h2>
		<form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
			<table align="center">
				<tr>
					<td width="200px">* 이름</td>
					<td><input type="text" maxlength="5" name="memberName" id="memberName" required></td>
					 <td><label id="nameresult"></label></td>
				</tr>
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="memberId" id="memberId" required></td>
					<td width="100px"><input type="button" value="중복확인" class="btn btn-or" id="duplicationCheck"></td>
				</tr>
				<tr>
					<td width="150px">* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd" id="memberPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td width="150px">* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2" id="memberPwd2"></td>
                	<td><label id="pwdresult"></label></td>
				</tr>
				<tr>
					<td width="200px">생년월일(ex.990909)</td>
					<td><input type="text" name="memberPno"></td>
					<td></td>
				</tr>
					<tr>
						<td width="200px">성별</td>
						<td><select name="gender">
								<option value="남자">남자</option>
								<option value="여자">여자</option>
							</select></td>
						<td></td>
					</tr>
				<tr>
					<td width="200px">우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" readonly></td>
					<td><input type="button" value="검색" class="btn btn-yg" id="searchZipCode"></td>
				</tr>
				<tr>
					<td width="200px">주소</td>
					<td><input type="text" name="address1" id="address1" readonly></td>
					<td></td>
				</tr>
				<tr>
					<td width="200px">상세주소</td>
					<td><input type="text" name="address2" id="address2"></td>
					<td></td>
				</tr>
				<tr>
					<td width="200px">이메일</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
					<tr>
					<td width="200px">휴대폰</td>
					<td><input type="tel" name="phone"></td>
					<td></td>
				</tr>
			</table>
			<br>
			<div class="btns" align="center">
				<input type="reset" value="메인으로" class="btn btn-yg" id="goMain">
				<input type="submit" value="가입하기" class="btn btn-or" id="insert">
			</div>
		</form>

	
	</div> <!-- 회원 가입 양식 영역 끝-- -->
    <script>
        $(function() {
        	
        	$("#memberName").change(function() {
        	
        	var regExp = /[가-힣]/g;
        	
        	if(!regExp.test($(this).val())) {
        		$("#nameresult").html("잘못입력").css("color", "red");
        	} else {
        		$("#nameresult").html("정상입력").css("color", "green");
        	}
        		
        	});
        	
        	$("#memberPwd2").change(function() {
            	if($("#memberPwd").val() !== $(this).val()) {
            		$("#pwdresult").html("비밀번호불일치").css("color", "red");
            		$("#memberPwd2").focus().css("background", "red");
            	} else {
            		$("#pwdresult").html("비밀번호일치").css("color", "green");
            	}
        		
        	});
        	
        	//focusin, focusout : 버블링 발생 함
        	//focus, blur : 버블링 발생 안함 -> focusin과 focusout처럼 사용하자
        	$("#name").focus(function() {
        		console.log("focus 이벤트 가동");
        	}).focusin(function() {
        		console.log("focusin 이벤트 가동");
        	}).focusout(function() {
        		console.log("focusout 이벤트 가동");
        	}).blur(function() {
        		console.log("blur 이벤트 가동");
        	}).change(function() {
        		console.log("change 이벤트 가동");
        	}).select(function() {
        		console.log("select 이벤트 가동");
        	})
        	
/*         	$("form").submit(function(event) {
        		event.preventDefault();
        	}); */
        	
        });
    </script>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		
		$searchZipCode.onclick = function() {
			
		new daum.Postcode({
			oncomplete : function(data) {
				console.log(data.zonecode);
				console.log(data.address);
				document.getElementById("zipCode").value = data.zonecode;
				document.getElementById("address1").value = data.address;
			 	document.getElementById("address2").focus();
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.
			}
		}).open();
		}
	</script>
	</div>

	<jsp:include page="../common/footer.jsp"/> 
</body>
</html>