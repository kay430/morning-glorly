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
	href="/mg/resources/css/customer/customer_reviewinsert.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<body>

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
		
		
		<hr>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				
				<hr>
				<div class="gongji">
					<div class="outer-notice-insert">
						<div class="outer outer-notice-list">
							<br>
							<div class="table-area">
								<form action="${ pageContext.servletContext.contextPath }/review/insert"
									method="post" encType="multipart/form-data">
									<table align="center" style="margin-left:-80px ">
										<tr>
											<td><div style="font-family: 'Jua', sans-serif; font-size:25px;">제목</div></td>
											<td><input type="text" size="95" name="title" style="margin-top: 15px; margin-bottom: 15px;"></td>
										</tr>
										<tr>
											<td><div style="font-family: 'Jua', sans-serif; font-size:25px;">작성자</div></td>
											<td><input type="text"
												value="${ sessionScope.loginMember.name }" name="writer" readonly style="margin-top: 15px; margin-bottom: 15px"></td>
										</tr>
										<tr>
											<td><div style="font-family: 'Jua', sans-serif; font-size:25px;">내용</div></td>
											<td colspan="2"><textarea name="body" cols="60"
													rows="15" style="resize: none; width: 600px; height: 350px; margin-left:1px;margin-top: 15px; margin-bottom: 15px"
													required ></textarea></td>
										</tr>
										<tr>
											<td><div style="font-family: 'Jua', sans-serif; font-size:25px;">비밀번호</div></td>
											<td><input type="text" size="30" name="password" style="margin-top: 15px; margin-bottom: 15px"></td>
										</tr>

									
									<br>
										<tr>
											<td><div style="font-family: 'Jua', sans-serif; font-size:25px;">후기 사진</div></td>
											 <td colspan="3">
												<div class="title-image-area1">
													<img id="titleImg" width="350" height="200" style="margin-top: 15px; margin-bottom: 15px;">
												</div>
											</td> 
										</tr>
										
 												</table>
										<div class="thumbnail-file-area" align="center">
 												
											<input type="file" id="thumbnailImg1" name="thumbnailImage1"
												onchange="loadImg(this, 1)" style="font-family: 'Jua', sans-serif; font-size:25px;"> 
											
										</div>
									<div align="center">
										<button class="buttons"type="reset" id="cancelInsert"style="font-family: 'Jua', sans-serif; font-size:25px;padding:15px 15px">취소하기</button>
										<button class="buttons"type="submit" id="submitReview"style="font-family: 'Jua', sans-serif; font-size:25px; padding:15px 15px">등록하기</button>
										</div>
										</form>
										<!--썸네일 들어갈곳 -->
										<script>
											const $titleImgArea = document
													.getElementById("titleImgArea");
											

											$titleImgArea.onclick = function() {
												document.getElementById(
														"thumbnailImg1")
														.click();
											}

											
											function loadImg(value, num) {
												if (value.files
														&& value.files[0]) {
													const reader = new FileReader();

													reader.onload = function(e) {
														switch (num) {
														case 1:
															document
																	.getElementById("titleImg").src = e.target.result;
															break;
														
														}
													}

													reader
															.readAsDataURL(value.files[0]);
												}
											}
										</script>
										<!-- 썸네일은 여기까지-->
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