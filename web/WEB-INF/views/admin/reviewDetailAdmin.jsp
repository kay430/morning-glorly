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

 
</head>
<body>
  	<jsp:include page="/WEB-INF/views/common/admin/adHeader.jsp"/>
	
 
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
              <li><a href=" ${ pageContext.servletContext.contextPath }/admin/registProduct">상품등록</a></li>
              <li><a href=" ${ pageContext.servletContext.contextPath }/admin/SelectProduct">상품조회</a></li>
              
            </ul>
          </li>
          <li class="sub-menu">
            <a class="active" href="javascript:;">
              <i class="fa fa-tasks"></i>
              <span>고객센터</span>
              </a>
            <ul class="sub">
              <li><a id="adminNotice">공지사항</a></li>
              <li><a id="answer">Q&A</a></li>
              <li class="active"><a id="review">상품후기</a></li>
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
                    리뷰 확인
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
                  <textarea id="headCore" style="resize:none; width:90%; height:30px;" readonly><c:out value="${ requestScope.review.title }"/></textarea>
                  </div>
                  <div class="col-md-4">
                    <div class="compose-btn pull-right">
                                  <a class="btn btn-sm btn-theme" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/review'">
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
                      <strong class="col-md-8">작성자 : <c:out value="${ requestScope.review.mgDTO.name }"/></strong>
                     
                    <div class="col-md-4">
                      <p class="date">작성일자:<c:out value="${ requestScope.review.createDate }"/></p>
                    </div>
                  </div>
                </div>
                <img src="${ pageContext.servletContext.contextPath }${ requestScope.reviewDetail.attachmentList[0].thumbnailPath }">
                <div class="view-mail">
                   <textarea id="core" style="resize:none; width:90%; height:200px;" readonly><c:out value="${ requestScope.review.body }"/></textarea>
                </div>
                
                <div id="holdUp2" class="compose-btn pull-left">
                  <a id="rewriteNoListA1" class="btn btn-sm btn-theme" onclick="location.href='${ pageContext.servletContext.contextPath }/admin/review'">
                  <i class="fa fa-reply"></i> 목록으로</a>
                  <c:if test="${ sessionScope.loginMember.status eq 'Y' }">
              
                  <div id="holdUp4">
                  <button id="rewriteNoCommitA1" class="btn btn-sm">
                  <i class="fa fa-arrow-right"></i>완료하기</button>
                  </div>
                  <script src="/mg/resources/js/event.js"></script>
                  <script>
                  window.onload = function() {
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
                	  
                	  
                	  $("#rewriteNoCommitA1").css("display","none");
                	  console.log('${ pageNumNo }')
                  		$("#holdUp2").css("float","left").css("display","inline");
                  		$("#rewriteNoListA1").css("float","left").css("display","inline");
                  		$("#holdUp").css("float","left").css("display","inline");
                  		$("#holdUp3").css("float","left").css("display","inline");
                  		$("#holdUp4").css("float","left").css("display","inline");
                  		
                  }
                  
                 
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