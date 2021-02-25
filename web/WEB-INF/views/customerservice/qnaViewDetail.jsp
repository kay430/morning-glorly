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
	href="web/resources/css/customer/customer_qnadetail.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
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
			<div class="mail-header row">
				<div class="col-md-8">
					<textarea id="headCore"
						style="resize: none; width: 90%; height: 30px; margin-bottom: 10px;"
						readonly><c:out
							value="${ requestScope.question.title }" /></textarea>
				</div>
				<div class="col-md-4">
					<div class="compose-btn pull-right">
						<button class="btn  btn-sm tooltips" data-original-title="Print"
							type="button" data-toggle="tooltip" data-placement="top" title="">
							<i class="fa fa-print"></i>
						</button>
						<button class="btn btn-sm tooltips" data-original-title="Trash"
							data-toggle="tooltip" data-placement="top" title="">
							<i class="fa fa-trash-o"></i>
						</button>
					</div>
				</div>
			</div>
			<div class="mail-sender">
				<div class="row">
					<div class="col-md-8">
						<img src="img/ui-zac.jpg" alt=""> <strong class="col-md-8">작성자
							: <c:out value="${ requestScope.question.mgDTO.name}" />
						</strong>
					</div>
					<div class="col-md-4">
						<p class="date">
							<c:out value="${ requestScope.question.createDate }" />
						</p>
					</div>
				</div>
			</div>
			<img
				style="float: left; width: 200px; height: 200px; margin: 10px 15px 10px 0;"
				src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.notice.attaNotiList[0].thumbnailPath }"/>" />
			<img
				style="float: left; width: 200px; height: 200px; margin: 10px 15px 10px 0;"
				src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.notice.attaNotiList[0].thumbnailPath }"/>" />
			<img
				style="float: left; width: 200px; height: 200px; margin: 10px 15px 10px 0;"
				src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.notice.attaNotiList[0].thumbnailPath }"/>" />
			<div class="view-mail" style="margin: 150px 0 0 0;">
				<%-- <p><c:out value="${ requestScope.notice.body }"/></p> --%>
				<textarea id="core" style="resize: none; width: 90%; height: 250px;"
					readonly><c:out value="${ requestScope.question.body }" /></textarea>
			</div>


			<div id="holdUp2" class="compose-btn pull-left">
				<a id="rewriteNoList" class="btn btn-sm btn-theme"
					onclick="location.href='${ pageContext.servletContext.contextPath }/question/list'">
					<i class="fa fa-reply"></i> 목록으로
				</a>
				<c:if test="${ sessionScope.loginMember.status eq 'Y' }">
					<div id="holdUp">
						<button id="rewriteNo" class="btn btn-sm">
							<!-- <a href='javascript:test("/mg/resources/js/event")'> -->
							<i class="fa fa-arrow-right"></i> 수정하기
							<!-- </a> -->
						</button>
						<button id="deleteNo" class="btn btn-sm">
							<!-- <a href='javascript:test("/mg/resources/js/event")'> -->
							<i class="fa fa-arrow-right"></i> 삭제하기
							<!-- </a> -->
						</button>

					</div>
					<div id="holdUp4">
						<button id="rewriteNoCommit" class="btn btn-sm">
							<i class="fa fa-arrow-right"></i>완료하기
						</button>
					</div>	
                            

                  </select>
					<script src="/mg/resources/js/event.js"></script>
					<script>
                  window.onload = function() {
                	  
                
                	  $("#rewriteNoCommit").css("display","none");
                	  console.log('${ pageNumNo }')
                  		$("#holdUp2").css("float","left").css("display","inline");
                  		$("#rewriteNoList").css("float","left").css("display","inline");
                  		$("#holdUp").css("float","left").css("display","inline");
                  		$("#holdUp3").css("float","left").css("display","inline");
                  		$("#holdUp4").css("float","left").css("display","inline");
                  		/* $("#test2").load(location.href + " #test2"); */
                  }
                  
                  	$("#rewriteNo").click(function() {
                  		$("#rewriteNoCommit").css("display","block");
                  		$("#rewriteNo").css("display","none");
                  		$("#headCore").attr('readonly', false);
                  		$("#core").attr('readonly', false);
                  		
                  		$("#rewriteNoCommit").click(function() {
                  			
                  			if(confirm("게시물을 수정하시겠습니까?")) {
                      			const headCore = document.getElementById("headCore").value;
                          		const body = document.getElementById("core").value;
                          		const pageNumNo = '${ pageNumNo }';
                          		const adminNo = '${ sessionScope.loginMember.no }';
                          		console.log(headCore);
                          		console.log(body);
                          		
                          		$.ajax({
                          			url: "${ pageContext.servletContext.contextPath }/question/update",
                          			type: "post",
                          			data: {headCore : headCore, body : body, pageNumNo : pageNumNo, adminNo: adminNo },
                          			success: function(data, textStatus, xhr) {
                          				document.getElementById("headCore").innerHTML = data["title"];
                          				document.getElementById("core").innerHTML = data["body"];
                          				
                          				console.log(data["title"]);
                          				console.table(data["body"]);
                                  	  $("#rewriteNoCommit").css("display","none");
                                  	$("#rewriteNo").css("display","block");
                              		$("#headCore").attr('readonly', true);
                              		$("#core").attr('readonly', true);
                          			},
                          			error: function(xhr, status, error) {
                          				console.log(error);
                          			}
                          		});
                  				alert("수정 완료!")
                  			} else {
                  				alert("수정 취소~")
                  				location.href = '${ pageContext.servletContext.contextPath }/question/detail?no=' + '${ pageNumNo }';
                  			}

                  		});
                  		alert("게시물 수정을 진행해주세요.");
                  	});
                  	
                  	
                  	
                 	$("#deleteNo").click(function() {
                  		$("#deleteNo").css("display","none");
                  		$("#headCore").attr('readonly', false);
                  		$("#core").attr('readonly', false);
                  		
                  		$("#deleteNoCommit").click(function() {
                  			
                  			if(confirm("게시물을 삭제하시겠습니까?")) {
                      			const headCore = document.getElementById("headCore").value;
                          		const body = document.getElementById("core").value;
                          		const pageNumNo = '${ pageNumNo }';
                          		const adminNo = '${ sessionScope.questionList.no }';
                          		console.log(headCore);
                          		console.log(body);
                          		
                          		$.ajax({
                          			url: "${ pageContext.servletContext.contextPath }/question/delete",
                          			type: "post",
                          			data: {headCore : headCore, body : body, pageNumNo : pageNumNo, adminNo: adminNo },
                          			success: function(data, textStatus, xhr) {
                          				document.getElementById("headCore").innerHTML = data["title"];
                          				document.getElementById("core").innerHTML = data["body"];
                          				
                          				console.log(data["title"]);
                          				console.table(data["body"]);
                                  	  $("#rewriteNoCommit").css("display","none");
                                  	$("#rewriteNo").css("display","block");
                              		$("#headCore").attr('readonly', true);
                              		$("#core").attr('readonly', true);
                          			},
                          			error: function(xhr, status, error) {
                          				console.log(error);
                          			}
                          		});
                  				alert("삭제 완료!")
                  			} else {
                  				alert("삭제 취소~")
                  				location.href = '${ pageContext.servletContext.contextPath }/question/detail?no=' + '${ pageNumNo }';
                  			}

                  		});
                  		alert("게시물을 삭제를 진행해주세요");
                  	});
                  </script>
				</c:if>
				<div id="holdUp3">
					<button class="btn  btn-sm tooltips" data-original-title="Print"
						type="button" data-toggle="tooltip" data-placement="top" title="">
						<i class="fa fa-print"></i>
					</button>
					<button class="btn btn-sm tooltips" data-original-title="Trash"
						data-toggle="tooltip" data-placement="top" title="">
						<i class="fa fa-trash-o"></i>
					</button>
				</div>
			</div>
		</div>
	</section>


</body>
</html>