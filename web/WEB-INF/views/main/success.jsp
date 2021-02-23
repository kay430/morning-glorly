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

	<script>
		(function() {
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode) {
			case "insertMember" :
				successMessage = "회원가입에 성공하셨습니다.";
				movePath = "${ pageContext.servletContext.contextPath }"
				break;
			case "FindId" :
				successMessage =  " ${ requestScope.loginMember.name } 님의 아이디는 ${ requestScope.loginMember.id } 입니다";
				movePath = "${ pageContext.servletContext.contextPath }"
				break;
			case "insertNotice"	:
			successMessage = "등록 성공하셨습니다.";
			movePath = "${ pageContext.servletContext.contextPath }"
			break;
			case "Findpwd" :
				successMessage =  "성공입니다";
				movePath = "${ pageContext.servletContext.contextPath }"
				break;

			case "insertQuestion" :
				successMessage = "등록 성공하셨습니다.";
				movePath = "${ pageContext.servletContext.contextPath}";
       		 break;

          
		    case "insertReviewNotice"	:
				successMessage = "상품리뷰 등록 성공하셨습니다.";
				movePath = "${ pageContext.servletContext.contextPath }/product/review";
				break;

	          case "insertThumbnail":
	              successMessage = "도시락상품등록에 성공하였습니다!";
	              movePath ="${ pageContext.servletContext.contextPath }/admin/SelectProduct";
	              break;

	        case "insertThumbnail":
	            successMessage = "썸네일 게시판 등록 성공";
	            movePath ="${ pageContext.servletContext.contextPath }/admin/SelectProduct";
	            break;
	            
	        case "deleteMember":
	            successMessage = "회원탈퇴 성공";
	            movePath ="${ pageContext.servletContext.contextPath }/mypage/quitM	ember";
	            break;    

			}
			
			alert(successMessage);
			location.href = movePath;
			
		})();
	</script>

<%-- 	<div class="container">
		<h1 align="center">회원가입 성공!</h1>
			<table align="center" border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>주소</th>
			<th>이메일</th>
			<th>휴대폰</th>
		</tr>
		<tr>
			<td>${ memberName }</td>
			<td>${ memberId }</td>
			<td>${ memberPno }</td>
			<td>${ gender }</td>
			<td>${ address }</td>
			<td>${ email }</td>
			<td>${ phone }</td>
		</tr>
	</table>
	<h1 align="center">수신양호</h1>
	</div> --%>

	<jsp:include page="../common/footer.jsp"/> 
</body>
</html>