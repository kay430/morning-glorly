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
  <title>Dashio - Bootstrap Admin Template</title>

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
                      <strong>작성자 : <c:out value="${ requestScope.notice.writer.name }"/></strong>
                    </div>
                    <div class="col-md-4">
                      <p class="date"><c:out value="${ requestScope.notice.createdDate }"/></p>
                    </div>
                  </div>
                </div>
                <div class="view-mail">
                  <%-- <p><c:out value="${ requestScope.notice.body }"/></p> --%>
                  <textarea id="core" style="resize:none; width:90%; height:200px;" readonly><c:out value="${ requestScope.notice.body }"/></textarea>
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
                  <i class="fa fa-arrow-right"></i> 수정하기</button>
                  </div>
                  <div id="holdUp4">
                  <button id="rewriteNoCommit" class="btn btn-sm">
                  <i class="fa fa-arrow-right"></i>완료하기</button>
                  </div>
                  <script>
                  window.onload = function() {
                	  $("#rewriteNoCommit").css("display","none");
                	  console.log('${ pageNumNo }')
                  		$("#holdUp2").css("float","left").css("display","inline");
                  		$("#rewriteNoList").css("float","left").css("display","inline");
                  		$("#holdUp").css("float","left").css("display","inline");
                  		$("#holdUp3").css("float","left").css("display","inline");
                  		$("#holdUp4").css("float","left").css("display","inline");
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