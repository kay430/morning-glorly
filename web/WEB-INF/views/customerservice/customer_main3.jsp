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
 <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<body>

	<jsp:include page="../common/header.jsp" />

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="${ pageContext.servletContext.contextPath }/customer/list"> CUSTOMER</a></li>
				<li class="sidebar-text"><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a>
				<li class="sidebar-text"><a href="${ pageContext.servletContext.contextPath }/question/list">질문과 답변</a></li>
				<li class="sidebar-text"><a href="${ pageContext.servletContext.contextPath }/product/review">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<div id="main-wrapper">
			<div class="main-header">
				<h1>
					<img src="../resources/image/Logo1.png" style="width:400px">
				</h1>
				<br>
				<br>
				<br>
				<br>
				<h1><div class="info-text-title">안녕하세요! 모닝글로리 고객센터입니다.</div></h1>
				<div class="info">
				<br><br>
				
					<h2>
						<div class="info-text">
						고객센터 1666-0000 // 운영시간 09:00~18:00 <br> 점심시간 12:00~13:00 주말 및
						공휴일 휴무
						</div>
					</h2>
					
				</div>
			</div>
			<hr>
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<h2><div class="info-text">자주 묻는 질문</div></h2>

					<hr>
					<div>
						<table class="question-table">
							<tr>
									<th class="q-table"><a style="font-size:25px"href="${ pageContext.servletContext.contextPath }/customer/list">전체보기</a></th>
								<th class="q-table"><a style="font-size:25px" href="${ pageContext.servletContext.contextPath }/customer/post">배송관련</a></th>
								<th class="q-table"><a style="font-size:25px" href="${ pageContext.servletContext.contextPath }/customer/order">주문접수관련</a></th>
								<th class="q-table"><a style="font-size:25px" href="${ pageContext.servletContext.contextPath }/customer/change">각종 변경관련</a></th>
								<th class="q-table"><a style="font-size:25px" href="${ pageContext.servletContext.contextPath }/customer/refund">교환/환불관련</a></th>
								<th class="q-table"><a style="font-size:25px" href="${ pageContext.servletContext.contextPath }/customer/other">기타</a></th>
							</tr>
						</table>
						<table class="question">
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list"><div class="main-text">1. 적립금은 어떻게 적립이 되나요?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list"><div class="main-text">2. 구매시 카드결제만 가능 한가요?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list"><div class="main-text">3. 적립금은 몇점부터 사용이 가능한가요?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list"><div class="main-text">4. 전화주문 가능한가요?</th>
							</tr>
							<tr>
								<th class="question-empty"></th>
							</tr>
							<tr>
								<th class="question-list"><div class="main-text">5. 적립금을 현금화 할수 있나요?</th>
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