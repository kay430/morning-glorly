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
	href="/mg/resources/css/customer/customer_qnainsert.css">
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
		
		<!-- /사이드바 -->

		<!-- 본문 -->
		
		<hr>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div style="font-family: 'Jua', sans-serif;
	font-size:40px;" >질문하기</div>
				<hr>
				<div class="gongji">
					<div class="outer-notice-insert">
						<div class="outer outer-notice-list">
							<br>
							<div class="table-area">
								<form
									action="${ pageContext.servletContext.contextPath }/question/insert"
									method="post" encType="multipart/form-data">
									<table align="center">
										<tr>
											<td style="font-family: 'Jua', sans-serif; font-size:25px">제목</td>
											<td><input type="text" size="105" name="title"></td>
										</tr>
										<tr>
											<td style="font-family: 'Jua', sans-serif; font-size:25px">작성자</td>
											<td><input type="text"
												value="${ sessionScope.loginMember.name }" name="writer"
												readonly>
									    <select id="qnaCode" name="qnaCode" style="font-family: 'Jua', sans-serif; font-size:25px">
                            				<option value="10">결제</option>	
                              				<option value="20">배송</option>
                              				<option value="30">상품</option>
                              				<option value="40">환불</option>
                              				<option value="50">후기</option>
                              				<option value="60">기타</option>
                              				</select> 
												
												</td>
										</tr>
    
										<tr class="innerText">
											<td style="font-family: 'Jua', sans-serif; font-size:25px">내용</td>
											<td colspan="2"><textarea name="body" cols="60"
													rows="15" style="resize: none; width: 600px; height: 550px;" required></textarea>
											</td>
										</tr>
                              					 
									</table>
										<div align="center">
											<div class="thumbnail-file-area" id="titleQueImgArea">
												<input type="file" id="QuethumbnailImg1" name="QuethumbnailImg1" onchange="QueloadImg(this, 1)">
												<img id="QuecontentImg1" width="100" height="100">
										</div>								
									<br>
									<div class="button" align="center">
										<button class="buttons" type="reset" id="cancelQuestion">취소하기</button>
										<button class="buttons" type="submit">등록하기</button>
										<button></button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
  	function QueloadImg(value, num) {
  		if(value.files && value.files[0]) {
  			const reader = new FileReader();
  			
  			reader.onload = function(e) {
  				switch(num) {
  				case 1 :
  					document.getElementById("QuecontentImg1").src = e.target.result;
  					console.log("클릭완료");
  					console.log(e.target.result);
  					break;
  				}
  			}
  			
  			reader.readAsDataURL(value.files[0]);
  			console.log(value.files[0]);
  			
  		}
  	}
	</script>
	
	<jsp:include page="../common/footer.jsp" />

</body>
</html>