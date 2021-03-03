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
<link rel="stylesheet" type="text/css" href="/mg/resources/css/customer/customer_qnadetail.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/main-common.css">
 
<link rel="stylesheet" type="text/css" href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<style>
.btn-sm{
font-family: 'Jua', sans-serif ;	
	
	background: rgb(227, 240, 168);
    color: rgb(3, 3, 3) !important;
    border: 1px #093 solid !important;
    margin-left: 0%;
    border-radius: 30px / 30px;}
</style>
<body>

	<jsp:include page="../common/header.jsp" />

	<section class="qna_panel"
		>
		<header class="panel-heading wht-bg" style="margin: 0 0 30px 0;">
			<h4 class="gen-case" style="font-size: 30px; text-align: center;font-family: 'Jua', sans-serif;
	font-size:40px">질문게시판</h4>
		</header>
		<div class="panel-body ">
			<div class="mail-header row">
				<div class="col-md-8">
					<textarea id="headCore"
						style="resize: none; width: 90%; height: 30px; margin-bottom: 14px; margin-left:19px"
						readonly><c:out
							value="${ requestScope.question.title }" /></textarea>
				</div>
				<!--필요 없는 버튼 <div class="col-md-4">
					<div class="compose-btn pull-right">
						<button class="btn  btn-sm tooltips" data-original-title="Print"
							type="button" data-toggle="tooltip" data-placement="top" title="">
							<i class="fa fa-print"></i>
						</button>
						<button class="btn btn-sm tooltips" data-original-title="Trash"
							data-toggle="tooltip" data-placement="top" title="">
							<i class="fa fa-trash-o"></i>
						</button>
					</div> -->
				</div>
			</div>
			<div class="mail-sender">
				<div class="row">
					<div class="col-md-8"style="font-family: 'Jua', sans-serif">
						<img src="img/ui-zac.jpg" alt=""> <strong class="col-md-8">작성자
							: <c:out value="${ requestScope.question.mgDTO.name}" />
						</strong>
					</div>
					<div class="col-md-4"style="font-family: 'Jua', sans-serif">
						<p class="date">작성일:
							<c:out value="${ requestScope.question.createDate }" />
						</p>
					</div>
				</div>
			</div>
			<img
				style="float: left; width: 200px; height: 200px; margin: 10px 15px 10px 20px;"
				src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.question.attaQueList[0].thumbnailPath }"/>" />
			<div class="view-mail" style="margin: 150px 0 0 0;">
				<%-- <p><c:out value="${ requestScope.notice.body }"/></p> --%>
				<textarea id="core" style="resize: none; width: 90%; height: 250px;margin-left: 20px;"
					readonly><c:out value="${ requestScope.question.body }" /></textarea>
			</div>


			<div id="holdUp2" class="compose-btn pull-left" style="margin-left: 21px;
    margin-top: 10px;">
				
				<button id="rewriteNoList" class="btn-sm"
					onclick="location.href='${ pageContext.servletContext.contextPath }/question/list'">
					<i class="fa fa-reply"></i> 목록으로
				</button>
				<c:if test="${ sessionScope.loginMember.status eq 'Y' }">
					<div id="holdUp">
						<button id="rewriteNo" class="btn-sm">
							<!-- <a href='javascript:test("/mg/resources/js/event")'> -->
							 수정하기
							<!-- </a> -->
						</button>
						<button id="deleteNo" class="btn-sm" >
							<!-- <a href='javascript:test("/mg/resources/js/event")'> -->
							삭제하기
							<!-- </a> -->
						</button>

					</div>
					<div id="holdUp4">
						<button id="rewriteNoCommit" class="btn-sm" >
							완료하기
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
					<!-- <button class="btn  btn-sm tooltips" data-original-title="Print"
						type="button" data-toggle="tooltip" data-placement="top" title="">
						<i class="fa fa-print"></i>
					</button>
					<button class="btn btn-sm tooltips" data-original-title="Trash"
						data-toggle="tooltip" data-placement="top" title="">
						<i class="fa fa-trash-o"></i>
					</button> -->
				</div>
			</div>
		</div>
	</section>

    <!-- 댓글 부분 -->
    <div id="comment">
        <table border="1" bordercolor="lightgray">
    <!-- 댓글 목록 -->    
    <c:if test="${requestScope.commentList != null}">
        <c:forEach var="comment" items="${requestScope.commentList}">
        
            <tr>
                <!-- 아이디, 작성날짜 -->
                <td width="150">
                    <div>
                        ${comment.comment_id}<br>
                        <font size="2" color="lightgray">${comment.comment_date}</font>
                    </div>
                </td>
                <!-- 본문내용 -->
                <td width="550">
                    <div class="text_wrapper">
                        ${comment.comment_content}
                    </div>
                </td>
                <!-- 버튼 -->
                <td width="100">
                    <div id="btn" style="text-align:center;">
                        <a href="#">[답변]</a><br>
                    <!-- 댓글 작성자만 수정, 삭제 가능하도록 -->    
                    <c:if test="${comment.comment_id == sessionScope.sessionID}">
                        <a href="#">[수정]</a><br>    
                        <a href="#">[삭제]</a>
                    </c:if>        
                    </div>
                </td>
            </tr>
            
        </c:forEach>
    </c:if>
            
            <!-- 로그인 했을 경우만 댓글 작성가능 -->
<%--             <c:if test="${sessionScope.sessionID !=null}">
            <tr bgcolor="#F5F5F5">
            <form id="writeCommentForm">
                <input type="" name="comment_board" value="${board.board_num}123131312312312312123213123123213">
                <input type="" name="comment_id" value="${sessionScope.sessionID}">
                <!-- 아이디-->
                <td width="150">
                    <div>
                        ${sessionScope.sessionID}
                    </div>
                </td>
                <!-- 본문 작성-->
                <td width="550">
                    <div>
                        <textarea name="comment_content" rows="4" cols="70" ></textarea>
                    </div>
                </td>
                <!-- 댓글 등록 버튼 -->
                <td width="100">
                    <div id="btn" style="text-align:center;">
                        <p><a href="#" onclick="writeCmt()">[댓글등록]</a></p>    
                    </div>
                </td>
            </form>
            </tr>
            </c:if> --%>
    
        </table>
    </div>
</div>


	




	</body>
</html>