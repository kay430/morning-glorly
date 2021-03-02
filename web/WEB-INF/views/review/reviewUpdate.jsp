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
	href="/mg/resources/css/customer/customer_reviewUpdate.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
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
  																				<!--구매하기 작성 하는곳  -->
		<!-- 본문 -->
		
		<hr>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				
				<hr>
				<div class="gongji">
					
						<div class="outer outer-notice-list">
							<br>
							<div class="table-area" >
								<form action="${ pageContext.servletContext.contextPath }/review/update"method="post">
									<table align="center" style="margin-left: -90px;">
										<tr>
											<td style="font-family: 'Jua', sans-serif; font-size:25px;">제목</td>
											<td><input type="text" size="105" name="title" style="margin-bottom:30px; margin-top:40px;"></td>
										</tr>
										<tr>
											<td style="font-family: 'Jua', sans-serif; font-size:25px;">작성자</td>
											<td><input type="text"
												value="${ sessionScope.loginMember.name}" name="writer"
												readonly style="margin-bottom:30px;  margin-top:20px;"></td>
										</tr>
										<tr>
											<td style="font-family: 'Jua', sans-serif; font-size:25px;">내용</td>
											<td colspan="2"><textarea name="body" cols="60"
													rows="15" style="resize: none; width: 700px; height: 380px; margin-bottom:40px;"
													required></textarea></td>
										</tr>
									
										<tr>
											<td style="font-family: 'Jua', sans-serif; font-size:25px;">비밀번호</td>
											<td><input type="text" size="30" name="password" style="margin-bottom:30px; margin-top:20px; "></td>
										</tr>

									<input type="hidden" name="no" value="${ param.no }">
									</table>
									<br>
									<div align="center">
										<button class="buttons"type="reset" id="cancelNotice" style="font-family: 'Jua', sans-serif; font-size:20px;padding:15px 10px">취소하기</button>
										<button class="buttons"type="submit"id="updateReview" style="font-family: 'Jua', sans-serif; font-size:20px;padding:15px 10px">등록하기</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	

	<jsp:include page="../common/footer.jsp" />

</body>
</html>