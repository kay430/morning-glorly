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
<link rel="stylesheet" type="text/css" href="/mg/resources/css/customer_main.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/main-common.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/mypage/changeMemberInfo.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	
	<div class="ud">
		<div class="img_area">
			<img style="margin: -30px 0 30px 94px;" src="/mg/resources/image/Logo1(2).png">
		</div> 
        <h1 align="center">모닝글로리
            <strong>회원정보수정</strong>
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
					<td><input type="text" maxlength="13" name="memberId" id="memberId" class="a" readonly value="${ sessionScope.loginMember.id }"></td>
					
				</tr>
				<tr>
					<td class="red">* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd" id="memberPwd" class="a"></td>
					
				</tr>
				<tr>
					<td class="red">* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2" class="a"></td>
				
				</tr>
				<tr>
					<td class="red">* 이름</td>
					<td><input type="text" maxlength="5" name="name"  class="a" value="${ sessionScope.loginMember.name }"></td>
				</tr>
				<tr>
					<td class="red1">연락처</td>
					<td><input type="tel" name="phone" class="a" value="${ sessionScope.loginMember.phone }"></td>
					
				</tr>
				<tr>
					<td class="red1">이메일</td>
					<td><input type="email" name="email" class="a" value="${ sessionScope.loginMember.email }"></td>
					
				</tr>
				<tr>
					<td class="red1"> 우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" class="a" >&nbsp;&nbsp;&nbsp;<input type="button" value="검색" class="btn-ygs" id="searchZipCode" class="a"></td>
					
				</tr>
				<tr>
					<td class="red1">주소</td>
					<td><input type="text" name="address1" id="address1"  class="a" ></td>
					
				</tr>
				<tr>
					<td class="red1">상세주소</td>
					<td><input type="text" name="address2" id="address2" class="a"></td>
					
				</tr>
            </tbody>
			</table>
        </div>
			<br>
			<div class="btns" align="center">
				<input type="submit" value="수정하기" class="btn-or" 
				onclick="${ pageContext.servletContext.contextPath }/change/memberInfo">
                <input type="reset" value="메인으로" class="btn-yg-1" id="goMain">
			</div>
		</form>
		
	</div>	<!-- 회원 정보 수정 영역 끝 -->
    
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		
		$searchZipCode.onclick = function() {
			new daum.Postcode({
		        oncomplete: function(data) {
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
		var result = '${ sessionScope.loginMember.address }'.split('$');
		console.log(result);

		document.getElementById("zipCode").value = "[" + result[0] + "] ";
		document.getElementById("address1").value = result[1];
		document.getElementById("address2").value = result[2];
	</script>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>