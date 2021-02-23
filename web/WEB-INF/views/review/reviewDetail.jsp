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
   href="/mg/resources/css/customer/customer_qna.css">
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
<div class="outer outer-review-detail">
		<br>
		<h2 align="center">리뷰  내용</h2>
		<div class="table-area">
			<table align="center">
				<tr>
					<td>제목 </td>
					<td colspan="3"><p><c:out value="${ requestScope.reviewDetail.title }"/></p></td>
				</tr>
				<tr>
					<td>작성자 </td>
					<td><p><c:out value="${ requestScope.reviewDetail.mgDTO.name }"/></p></td>
					<td>작성일</td>
					<td><p><c:out value="${ requestScope.reviewDetail.createDate }"/></p></td>
				</tr>
				<tr>
					<td>내용 </td>
					<td colspan="3">
						<textarea style="resize:none; width:90%; height:200px;" readonly><c:out value="${ requestScope.reviewDetail.body }"/></textarea>
					</td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/product/review'">메뉴로 돌아가기</button>
				<%-- <c:if test="${ sessionScope.loginMember.role eq 'ADMIN' }">--%>
					<button onclick="location.href='${ pageContext.servletContext.contextPath }/review/update?no=${ requestScope.review.no }'">수정하기</button>
				<%-- </c:if> --%>
			</div>
		</div>
	</div>
</body>
</html>
   