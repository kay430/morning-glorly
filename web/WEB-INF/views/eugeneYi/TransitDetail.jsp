<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Morning Glory Admin</title>

  <script src="/mg/resources/admin/jquery/jquery.min.js"></script>
  <!-- Favicons -->
  <link href="/mg/resources/image/admin/favicon.png" rel="icon">
  <link href="/mg/resources/image/admin/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="/mg/resources/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="/mg/resources/admin/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="/mg/resources/css/style.css" rel="stylesheet">
  <link href="/mg/resources/css/style-responsive.css" rel="stylesheet">
    <script src="/mg/resources/js/event.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
  	<jsp:include page="/WEB-INF/views/common/admin/adHeader.jsp"/>
	
   <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="/mg/resources/image/admin/ui-kor.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">프로필 사진</h5>
          <li class="mt">
            <a id="sweetHome2">
              <i class="fa fa-dashboard"></i>
              <span>메인 페이지</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
                 <span>회원관리</span>
              </a>
             <ul class="sub">
              <li><a id="adminMemberList">회원조회</a></li>
              <li><a href="buttons.html">블랙리스트</a></li>
              <li><a href="panels.html">적립금 조회 </a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-cogs"></i>
              <span>주문관리</span>
              </a>
            <ul class="sub">
              <li><a href="grids.html">주문 조회</a></li>
              <li><a href="calendar.html">결제내역</a></li>
              <li><a href="gallery.html">환불 및 반품</a></li>
              <li><a href="file_upload.html">배송 조회</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>상품관리</span>
              </a>
            <ul class="sub">
              <li><a href="blank.html">상품등록</a></li>
              <li><a href="login.html">상품조회</a></li>
              <li><a href="lock_screen.html">카테고리 관리</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a class="active" href="javascript:;">
              <i class="fa fa-tasks"></i>
              <span>고객센터</span>
              </a>
            <ul class="sub">
              <li class="active"><a id="adminNotice">공지사항</a></li>
              <li><a id="answer">Q&A</a></li>
              <li><a id="review">상품후기</a></li>
              <li><a id="generalQna">자주 묻는 질문</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class=" fa fa-bar-chart-o"></i>
             <span>통계</span>
              </a>
            <ul class="sub">
              <li><a href="morris.html">판매분석</a></li>
              <li><a href="morris.html">카테고리별 매출 조회</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-th"></i>
              <span>DB 조회용</span>
              </a>
            <ul class="sub">
              <li><a href="basic_table.html">Basic Table</a></li>
              <li><a href="responsive_table.html">Responsive Table</a></li>
              <li><a href="advanced_table.html">Advanced Table</a></li>
            </ul>
          </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
  <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!-- page start-->
      <section class="wrapper">
        <!-- page start-->
        <div class="row mt"></div>
          <div>
            <section class="">
            </section>
            <section class="">
            </section>
          </div>
          <div class="col-sm-9">
            <section class="panel">
              <header class="panel-heading wht-bg">
                <h4 class="gen-case">
                    공지사항 확인
                    <form action="#" class="pull-right mail-src-position">
                      <div class="input-append">
                        <input type="text" class="form-control " placeholder="검색하기">
                      </div>
                    </form>
                  </h4>
              </header>
              <div class="panel-body ">
                <div class="mail-header row">
                  <div class="col-md-8">
                  <textarea id="headCore" style="resize:none; width:90%; height:30px;" readonly><c:out value="${ requestScope.notice.title }"/></textarea>
                  </div>
                  <div class="col-md-4">
                    <div class="compose-btn pull-right">
                                  <a class="btn btn-sm btn-theme" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/notice'">
                  <i class="fa fa-reply"></i> 목록으로</a>
                      <button class="btn  btn-sm tooltips" data-original-title="Print" type="button" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-print"></i> </button>
                      <button class="btn btn-sm tooltips" data-original-title="Trash" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-trash-o"></i></button>
                    </div>
                  </div>
                </div>
                <div class="mail-sender">
                  <div class="row">
                    <div class="col-md-8">
                      <img src="img/ui-zac.jpg" alt="">
                      <strong class="col-md-8">작성자 : <c:out value="${ requestScope.notice.writer.name }"/></strong>
                      <div class="col-md-8"><strong>자주 하는 질문 : <c:out value="${ requestScope.notice.general }"/></strong></div>
                      <div class="col-md-8"><strong>유형 : <c:out value="${ requestScope.notice.generalType }"/></strong></div>
                    </div>
                    <div class="col-md-4">
                      <p class="date"><c:out value="${ requestScope.notice.createdDate }"/></p>
                    </div>
                  </div>
                </div>
                <div class="view-mail">
                  <%-- <p><c:out value="${ requestScope.notice.body }"/></p> --%>
                  <textarea id="core" style="resize:none; width:90%; height:200px;" readonly><c:out value="${ requestScope.notice.body }"/></textarea>
                <img src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.notice.attaNotiList[0].thumbnailPath }"/>" />
                </div>
                <!-- 첨부파일 부분 -->
               <!--  <div class="attachment-mail">
                  <p>
                    <span><i class="fa fa-paperclip"></i> 2 attachments — </span>
                    <a href="#">Download all attachments</a> |
                    <a href="#">View all images</a>
                  </p>
                  <ul>
                    <li>
                      <a class="atch-thumb" href="#">
                        <img src="img/instagram.jpg">
                        </a>
                      <a class="name" href="#">
                        IMG_001.jpg
                        <span>20KB</span>
                        </a>
                      <div class="links">
                        <a href="#">View</a> -
                        <a href="#">Download</a>
                      </div>
                    </li>
                    <li>
                      <a class="atch-thumb" href="#">
                        <img src="img/weather.jpg">
                        </a>
                      <a class="name" href="#">
                        IMG_001.jpg
                        <span>20KB</span>
                        </a>
                      <div class="links">
                        <a href="#">View</a> -
                        <a href="#">Download</a>
                      </div>
                    </li>
                  </ul>
                </div> -->
                <div id="holdUp2" class="compose-btn pull-left">
                  <a id="rewriteNoList" class="btn btn-sm btn-theme" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/notice'">
                  <i class="fa fa-reply"></i> 목록으로</a>
                  <c:if test="${ sessionScope.loginMember.status eq 'Y' }">
                  <div id="holdUp">
                  <button id="rewriteNo" class="btn btn-sm">
                  <!-- <a href='javascript:test("/mg/resources/js/event")'> -->
                  <i class="fa fa-arrow-right"></i> 수정하기
                  <!-- </a> -->
                  </button>
                  </div>
                  <div id="holdUp4">
                  <button id="rewriteNoCommit" class="btn btn-sm">
                  <i class="fa fa-arrow-right"></i>완료하기</button>
                  </div>
                  <script src="/mg/resources/js/event.js"></script>
                  <script>
                  window.onload = function() {
                	  console.log("${ requestScope.notice.attaNotiList[0].thumbnailPath }");
                	  /* JS파일 불러오는 방법 도전하다 결국 포기.(02/14) */
              /*   	  $.getScript("/mg/resources/js/event.js", function() {
                			console.log("완료")
                		}); */
                	  
                		if(document.getElementById("logoutAdmin")) {
                			const $logout = document.getElementById("logoutAdmin");
                			$logout.onclick = function() {
                				location.href = "/mg/admin/logout";}}
                		if(document.getElementById("adminNotice")) {
                			const $logout = document.getElementById("adminNotice");
                			$logout.onclick = function() {
                				location.href = "/mg/admin/notice";}}
                		if(document.getElementById("writeNotice")) {
                			const $writeNotice = document.getElementById("writeNotice");
                			$writeNotice.onclick = function() {
                				location.href = "/mg/admin/notice/insert";}}
                		if(document.getElementById("sweetHome")) {
                			const $writeNotice = document.getElementById("sweetHome");
                			$writeNotice.onclick = function() {
                				location.href = "/mg/admin/mainIndex";}}
                		if(document.getElementById("sweetHome2")) {
                			const $writeNotice = document.getElementById("sweetHome2");
                			$writeNotice.onclick = function() {
                				location.href = "/mg/admin/mainIndex";}}
                		if(document.getElementById("answer")) {
                			const $answer = document.getElementById("answer");
                			$answer.onclick = function() {
                				location.href = "/mg/admin/answer";}}
                		if(document.getElementById("review")) {
                			const $review = document.getElementById("review");
                			$review.onclick = function() {
                				location.href = "/mg/admin/review";}}
                		if(document.getElementById("generalQna")) {
                			const $generalQna = document.getElementById("generalQna");
                			$generalQna.onclick = function() {
                				location.href = "/mg/admin/generalQna";}}
                	  
                	  
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
                  			
                  			if(confirm("공지사항을 수정하시겠습니까?")) {
                      			const headCore = document.getElementById("headCore").value;
                          		const body = document.getElementById("core").value;
                          		const pageNumNo = '${ pageNumNo }';
                          		const adminNo = '${ sessionScope.loginMember.no }';
                          		console.log(headCore);
                          		console.log(body);
                          		
                          		$.ajax({
                          			url: "${ pageContext.servletContext.contextPath }/admin/notice/update",
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
                  				location.href = '${ pageContext.servletContext.contextPath }/admin/notice/detail?no=' + '${ pageNumNo }';
                  			}

                  		});
                  		alert("공지사항 수정을 진행해주세요.");
                  	});
                  </script>
                  </c:if>
                  <div id="holdUp3">
                  <button class="btn  btn-sm tooltips" data-original-title="Print" type="button" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-print"></i> </button>
                  <button class="btn btn-sm tooltips" data-original-title="Trash" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-trash-o"></i></button>
                  </div>
                </div>
              </div>
            </section>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer">
      <div class="text-center">
        <p>
          &copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
        </p>
        <div class="credits">
          <!--
            You are NOT allowed to delete the credit link to TemplateMag with free version.
            You can delete the credit link only if you bought the pro version.
            Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
            Licensing information: https://templatemag.com/license/
          -->
          Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
        </div>
        <a href="inbox.html#" class="go-top">
          <i class="fa fa-angle-up"></i>
          </a>
      </div>
    </footer>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="/mg/resources/admin/jquery/jquery.min.js"></script>
  <script src="/mg/resources/admin/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="/mg/resources/admin/jquery.dcjqaccordion.2.7.js"></script>
  <script src="/mg/resources/admin/jquery.scrollTo.min.js"></script>
  <script src="/mg/resources/admin/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="/mg/resources/admin/common-scripts.js"></script>
  <!--script for this page-->

</body>
</html>