<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Morning Glory Admin</title>

<script src="/mg/resources/admin/jquery/jquery.min.js"></script>
<!-- Favicons -->
<link href="/mg/resources/image/admin/favicon.png" rel="icon">
<link href="/mg/resources/image/admin/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="/mg/resources/admin/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link href="/mg/resources/admin/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="/mg/resources/css/style.css" rel="stylesheet">
<link href="/mg/resources/css/style-responsive.css" rel="stylesheet">
<script src="/mg/resources/js/event.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/admin/adHeader.jsp" />

	<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu" id="nav-accordion">
				<p class="centered">
					<a href="profile.html"><img
						src="/mg/resources/image/admin/ui-kor.jpg" class="img-circle"
						width="80"></a>
				</p>
				<h5 class="centered">프로필 사진</h5>
				<li class="mt"><a id="sweetHome2"> <i
						class="fa fa-dashboard"></i> <span>메인 페이지</span>
				</a></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-desktop"></i> <span>회원관리</span>
				</a>
					<ul class="sub">
						<li><a id="adminMemberList">회원조회</a></li>
						<li><a href="buttons.html">블랙리스트</a></li>
						<li><a href="panels.html">적립금 조회 </a></li>
					</ul></li>
				<li class="sub-menu"><a class="active">
						<i class="fa fa-cogs"></i> <span>주문관리</span>
				</a>
					<ul class="sub">
						<li class="active"><a href=" ${ pageContext.servletContext.contextPath }/admin/order">주문 조회</a></li>
						<li><a href=" ${ pageContext.servletContext.contextPath }/admin/payment">결제내역</a></li>
						<li><a href="gallery.html">환불 및 반품</a></li>
						<li><a href="file_upload.html">배송 조회</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-book"></i> <span>상품관리</span>
				</a>
					<ul class="sub">
						 <li><a href=" ${ pageContext.servletContext.contextPath }/admin/registProduct">상품등록</a></li>
                         <li><a href=" ${ pageContext.servletContext.contextPath }/admin/SelectProduct">상품조회</a></li>
						
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-tasks"></i> <span>고객센터</span>
				</a>
					<ul class="sub">
						<li><a id="adminNotice">공지사항</a></li>
						<li><a id="answer">Q&A</a></li>
						<li><a id="review">상품후기</a></li>
						<li><a id="generalQna">자주 묻는 질문</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class=" fa fa-bar-chart-o"></i> <span>통계</span>
				</a>
					<ul class="sub">
						<li><a href="morris.html">판매분석</a></li>
						<li><a href="morris.html">카테고리별 매출 조회</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-th"></i> <span>DB 조회용</span>
				</a>
					<ul class="sub">
						<li><a href="basic_table.html">Basic Table</a></li>
						<li><a href="responsive_table.html">Responsive Table</a></li>
						<li><a href="advanced_table.html">Advanced Table</a></li>
					</ul></li>
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
					<section class=""></section>
					<section class=""></section>
				</div>
				<div class="col-sm-9">
					<section class="panel">
						<header class="panel-heading wht-bg">
							<h4 class="gen-case">
								주문정보 상세 조회
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
									<strong class="col-md-8">주문상품명 : <c:out	value="${ requestScope.order.oTitle }" /></strong> 
										<div class="col-md-8"><strong>주문번호 : <c:out value="${ requestScope.order.oNo }" /></strong></div>
									    <div class="col-md-8"><strong>상품번호 : <c:out value="${ requestScope.order.gNo }" /></strong></div>
										<div class="col-md-8"><strong>주문일자 : <c:out value="${ requestScope.order.oDate }" /></strong></div>
									    <div class="col-md-8"><strong>개별가격 : <c:out value="${ requestScope.order.oGPrice }" /></strong></div>
									    <div class="col-md-8"><strong>주문수량 : <c:out value="${ requestScope.order.aCount }" /></strong></div>
										<div class="col-md-8"><strong>최종가격 : <c:out value="${ requestScope.order.amount }" /></strong></div>
								</div>
								<div class="col-md-4">
									<div class="compose-btn pull-right">
											
										<button class="btn  btn-sm tooltips"
											data-original-title="Print" type="button"
											data-toggle="tooltip" data-placement="top" title="">
											<i class="fa fa-print"></i>
										</button>										<button class="btn btn-sm tooltips"
											data-original-title="Trash" data-toggle="tooltip"
											data-placement="top" title="">
											<i class="fa fa-trash-o"></i>
										</button>

									</div>
								</div>
							</div>
							<div class="mail-sender">
								<div class="row">
									<div class="col-md-8"><strong class="col-md-8">주문자 : <c:out	value="${ requestScope.order.mName }" /></strong>
										<div class="col-md-8"><strong>회원번호 : <c:out value="${ requestScope.order.mNo }" /></strong></div>
                                        <div class="col-md-8"><strong>휴대폰번호 : <c:out value="${ requestScope.order.phNo }" /></strong></div>
									    <div class="col-md-8"><strong>주 소 : <c:out value="${ requestScope.order.addr }" /></strong></div>
									</div>
								</div>
							</div>

							<div id="holdUp2" class="compose-btn pull-left">
								<a id="rewriteNoList" class="btn btn-sm btn-theme"
									onclick="location.href='${ pageContext.servletContext.contextPath }/admin/order'">
									<i class="fa fa-reply"></i> 목록으로
								</a>
								<div id="holdUp3">
									<button class="btn  btn-sm tooltips"
										data-original-title="Print" type="button"
										data-toggle="tooltip" data-placement="top" title="">
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
				<a href="inbox.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/mg/resources/admin/jquery/jquery.min.js"></script>
	<script src="/mg/resources/admin/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/mg/resources/admin/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/mg/resources/admin/jquery.scrollTo.min.js"></script>
	<script src="/mg/resources/admin/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="/mg/resources/admin/common-scripts.js"></script>
	<!--script for this page-->

</body>
</html>