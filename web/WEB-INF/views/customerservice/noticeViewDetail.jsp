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
<link rel="stylesheet" type="text/css" href="/mg/resources/css/customer/customer_main.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/customer/notice_view.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="/mg/resources/css/main-common.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>


<body>

	<jsp:include page="../common/header.jsp" />
	
	<header class="panel-heading wht-bg" style="margin: 0 0 30px 0;">
			<h4 class="gen-case" style="font-size: 30px; text-align: center;font-family: 'Jua', sans-serif;
	font-size:40px">공지사항</h4>
		</header>
    <section class="panel">
              <header class="panel-heading wht-bg">
              </header>
              <div class="panel_body ">
                <div class="mail-header row">
                  <div class="col-md-8">
                  <textarea id="headCore" style="resize:none; width:880px; height:30px;margin-left:20px;margin-top:10px;"readonly><c:out value="${ requestScope.notice.title }"/></textarea>
                  </div>
                  <div class="col-md-4">
                    <div class="compose-btn pull-right"style="margin-left: 227px;">
                                  <a type="button" class="btn-theme" onclick="location.href='${ pageContext.servletContext.contextPath }/notice/list'" style="margin-top:-17px; margin-left: -17px;"> 목록으로</a>
                     </div>
                  </div>
                </div>
                <div class="mail-sender">
                  <div class="row">
                    <div class="col-md-9">
                      <!-- <img src="img/ui-zac.jpg"> -->
                      <strong class="col-md-8">작성자 : <c:out value="${ requestScope.notice.writer.name }"/></strong>
                    <div class="col-md-4">
                      <p class="date"style="margin-left: 20px;font-size:20px;"><c:out value="${ requestScope.notice.createdDate }" /></p>
                    </div>
                    </div>
                  </div>
                </div>
                <div class="view-mail">
                  <%-- <p><c:out value="${ requestScope.notice.body }"/></p> --%>
                  <textarea id="core" class="notice_body" readonly><c:out value="${ requestScope.notice.body }"/></textarea>
                <div class="notice_image">
                <img onerror="this.style.display='none'" src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.notice.attaNotiList[0].thumbnailPath }"/>" />
                </div>
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
                <div id="holdUp2" class="compose-btn" >
                  <a id="rewriteNoList" type="button" class="btn-theme_2" onclick="location.href='${ pageContext.servletContext.contextPath }/notice/list'">
                  	목록으로</a>
                  <div id="holdUp3">
                  <button class="btn  btn-sm tooltips" data-original-title="Print" type="button" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-print"></i> </button>
                  <button class="btn btn-sm tooltips" data-original-title="Trash" data-toggle="tooltip" data-placement="top" title=""><i class="fa fa-trash-o"></i></button>
                  </div>
                </div>
              </div>
              
                	<jsp:include page="../common/footer.jsp" />
                	
            </section>


</body>
</html>