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
   href="/mg/resources/css/customer/customer_reviewdetail.css">
<link rel="stylesheet" type="text/css"
   href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
   href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
   href="/mg/resources/css/main-common.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

   <jsp:include page="../common/header.jsp" />
	<section class="qna_panel"
		style="margin: 0 auto; width: 1100px; height: 500px; margin-top: 50px;">
		<header class="panel-heading wht-bg" style="margin: 0 0 30px 0;">
			<h4 class="gen-case" style="font-size: 30px; text-align: center;">
				질문게시판</h4>
		</header>
		<div class="panel-body ">
		<br>
		<br>
			<div class="review-header row">
				<div class="col-md-8">
					<textarea id="headCore"
						style="resize: none; width: 980px; height: 30px; margin-left:50px; margin-bottom: 10px;"
						readonly><c:out
							value="${ requestScope.reviewDetail.title }" /></textarea>
				</div>
				
			</div>
			<div class="review-info">
				<div class="row" style="width:600px; margin-left:50px;">
					<div class="col-md-8" style="width:150px;">
						 <strong class="col-md-8">작성자
							: <c:out value="${ requestScope.reviewDetail.mgDTO.name}" />
						</strong>
					</div>
					<div class="col-md-4" style="width:200px;" >
						<p class="date">작성일자
							<c:out value="${ requestScope.reviewDetail.createDate }" />
						</p>
					</div>
				</div>
			</div>
			<div class="review-detail" style="margin: 40px 0 0 0;">
				<textarea id="core" style="resize: none; width: 980px; height: 250px; margin-left:50px;"
					readonly><c:out value="${ requestScope.reviewDetail.body }" /></textarea>
			</div>
			<br>
			<br>
			<br>
			<img src="${ pageContext.servletContext.contextPath }${ requestScope.reviewDetail.attachmentList[0].thumbnailPath }"
							width="500" height="300" style="margin-left:50px">
	<br>
	<br>
	<br>
	<br>
	<br>
			

			<div align="center">
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/product/review'">메뉴로 돌아가기</button>
				<%-- <c:if test="${ sessionScope.loginMember.role eq 'ADMIN' }">--%>
					<button onclick="location.href='${ pageContext.servletContext.contextPath }/review/update?no=${ requestScope.review.no }'">수정하기</button>
				<%-- </c:if> --%>
				<button type="submit"id="deleteReview" onclick="alert('리뷰를 삭제합니다');">리뷰 삭제</button>
				<br>
		<script> function deleteReview()
		{ alert("리뷰가 삭제 되었습니다"); 
		} </script>
	<br>
	<br>
	<br>
	<br>
			</div>
		</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	
		</section>


</body>
</html>
   