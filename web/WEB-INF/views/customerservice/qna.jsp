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
	href="/mg/resources/css/customer/customer_main.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
</head>

<body>

	<jsp:include page="../common/header.jsp" />

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="${ pageContext.servletContext.contextPath }/customer/list"> CUSTOMER</a></li>
				<li><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a>
				<li><a href="${ pageContext.servletContext.contextPath }/question/list">질문과 답변~</a></li>
				<li><a href="${ pageContext.servletContext.contextPath }">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<h1>질문과 답변</h1>
		<hr>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<h1>질문과 답변게시판들어가는곳</h1>
				<div class="outer-notice-list">
					<div class="table-area">
						<table align="center" id="listArea">
							<tr class="trtrtr">
								<th width="50px">글번호</th>
								<th width="300px">글제목</th>
								<th width="100px">작성자</th>
								<th width="50px">조회수</th>
								<th width="100px">작성일</th>
								<th width="50px">처리상태<th> 
							</tr>
							<c:forEach var="question" items="${ requestScope.questionList }">		
								<tr>
									<td><c:out value="${ question.no }" /></td>
									<td><c:out value="${ question.title }" /></td>
									<td><c:out value="${ question.writer.id }" /></td>
									<td><c:out value="${ question.count }" /></td>
									<td><c:out value="${ question.createDate }" /></td>
									<td><c:out value="${ question.status }" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="search-area" align="center">
						<select id="searchCondition" name="searchCondition">
							<option value="writer">작성자</option>
							<option value="title">제목</option>
							<option value="body">내용</option>
						</select> <input type="search" name="searchValue">
						<button type="submit">검색하기</button>
						<%-- <c:if test="${ sessionScope.loginMember.role eq 'ADMIN' }">
						</c:if> --%>
							<button id="questionNotice">작성하기</button>
					</div>	
				</div>
			</div>
		</div>
		
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>