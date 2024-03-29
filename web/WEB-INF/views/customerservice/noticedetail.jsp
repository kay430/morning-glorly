<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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

		<!-- 본문 -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="notice_detail_header_txt">공지사항 작성</div>
				<hr>
				<div class="gongji">
					<div class="outer-notice-insert">
						<div class="outer outer-notice-list">
							<br>
							<div class="table-area">
								<form
									action="${ pageContext.servletContext.contextPath }/notice/insert"
									method="post">
									<table align="center">
										<tr>
											<td>제목</td>
											<td><input type="text" size="50" name="title"></td>
										</tr>
										<tr>
											<td>작성자</td>
											<div class="writer-name">
												<td><input type="text"
													value="${ sessionScope.loginMember.nickname }"
													name="writer" readonly></td>
											</div>
										</tr>

										<tr>
											<td>내용</td>
											<td colspan="2"><textarea name="body" cols="60"
													rows="15" required></textarea></td>
										</tr>
									</table>
									<br>
									<div align="center">
										<button class="notice-detail_btn" type="reset" id="cancelNotice">취소하기</button>
										<button class="notice-detail_btn" type="submit">등록하기</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<jsp:include page="../common/footer.jsp" />

</body>
</html> --%>