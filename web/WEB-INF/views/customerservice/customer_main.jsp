<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
  <script src="//code.jquery.com/jquery.min.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/mg/resources/css/customer/customer_main.css">
  <link rel="stylesheet" type="text/css" href="/mg/resources/css/header.css">
  <link rel="stylesheet" type="text/css" href="/mg/resources/css/footer.css">
  <link rel="stylesheet" type="text/css" href="/mg/resources/css/main-common.css">
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
				<li><a href="${ pageContext.servletContext.contextPath }/product/review">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<div id="main-wrapper">
			<div class="main-header">
				<h1>
					<img src="/image/Logo1.png">
				</h1>
				<br>
				<h1>안녕하세요! 모닝글로리 고객센터입니다.</h1>
				<div class="info">
					<h2>
						고객센터 1666-0000 // 운영시간 09:00~18:00 <br> 점심시간 12:00~13:00 주말 및
						공휴일 휴무
					</h2>
				</div>
			</div>
			<hr>
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<h2>자주 묻는 질문</h2>

					<hr>
					<div>
						<table class="question-table">
							<tr>
								<th class="q-table">전체보기</th>
								<th class="q-table">배송관련</th>
								<th class="q-table">주문접수관련</th>
								<th class="q-table">각종 변경관련</th>
								<th class="q-table">교환/환불관련</th>
								<th class="q-table">기타</th>
							</tr>
						</table>
						<table class="question">
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list">1. 최지환은 뭐하나요</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list">2. 똥 싸나여?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list">3. 똥쟁이라구요?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list">4.별명이 똥쟁이 최지환인가요?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list">5.그렇다면 쏘리질러!</th>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>