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
				<li class="sidebar-brand"><a href="#"> 고객센터</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">질문과 답변</a></li>
				<li><a href="#">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->
  																				<!--구매하기 작성 하는곳  -->
		<!-- 본문 -->
		<h1>구매후기</h1>
		<hr>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<h2>구매후기 작성</h2>
				<hr>
				<div class="gongji">
					<div class="outer-notice-insert">
						<div class="outer outer-notice-list">
							<br>
							<div class="table-area">
								<form
									action="${ pageContext.servletContext.contextPath }/review/update"
									method="post">
									<table align="center">
										<tr>
											<td>제목</td>
											<td><input type="text" size="105" name="title"></td>
										</tr>
										<tr>
											<td>작성자</td>
											<td><input type="text"
												value="${ sessionScope.loginMember.name}" name="writer"
												readonly></td>
										</tr>
										<tr>
											<td>내용</td>
											<td colspan="2"><textarea name="body" cols="60"
													rows="15" style="resize: none; width: 800px; height: 450;"
													required></textarea></td>
										</tr>
										<tr>
											<td>비밀번호</td>
											<td><input type="text" size="30" name="password"></td>
										</tr>

									</table>
									<br>
									<div align="center">
										<button type="reset" id="cancelNotice">취소하기</button>
										<button type="submit"id="updateReview">등록하기</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>