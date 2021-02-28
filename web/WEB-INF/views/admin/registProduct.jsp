<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Morning Glory Admin</title>

  <!-- Favicons -->
  <link href="/mg/resources/image/admin/favicon.png" rel="icon">
  <link href="/mg/resources/image/admin/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="/mg/resources/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="/mg/resources/admin/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- 내가 만든 CSS다 -->
  <link href="/mg/resources/admin/jihunh.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="/mg/resources/css/style.css" rel="stylesheet">
  <link href="/mg/resources/css/style-responsive.css" rel="stylesheet">
  <link href="/mg/resources/css/zabuto_calendar.css" rel="stylesheet">
  <link href="/mg/resources/admin/bootstrap-datepicker/css/datepicker.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/mg/resources/admin/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="/mg/resources/admin/bootstrap-datepicker//datepicker.css" />
  <link rel="stylesheet" type="text/css" href="/mg/resources/admin/bootstrap-daterangepicker/daterangepicker.css" />
  <link rel="stylesheet" type="text/css" href="/mg/resources/admin/bootstrap-timepicker/compiled/timepicker.css" />
  <link rel="stylesheet" type="text/css" href="/mg/resources/admin/bootstrap-datetimepicker/datetimepicker.css" />
    <script src="/mg/resources/js/event.js"></script>

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
            <a class="active" href="javascript:;">
              <i class="fa fa-book"></i>
              <span>상품관리</span>
              </a>
            <ul class="sub">
              <li class="active"><a href=" ${ pageContext.servletContext.contextPath }/admin/registProduct" id="registProduct">상품등록</a></li>
              <li><a href=" ${ pageContext.servletContext.contextPath }/admin/SelectProduct" id="SelectProduct">상품조회</a></li>
              
            </ul>
          </li>
          <li class="sub-menu">
            <a  href="javascript:;">
              <i class="fa fa-tasks"></i>
              <span>고객센터</span>
              </a>
            <ul class="sub">
              <li><a id="adminNotice">공지사항</a></li>
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
     <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
      <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 상품등록</h3>
        <div class="row mt">
          <!--  DATE PICKERS -->
          <div class="col-lg-12">
            <div class="form-panel">
            
              <form action="${ pageContext.servletContext.contextPath }/admin/registProduct" class="form-horizontal style-form" method="post" encType="multipart/form-data">
              
                <div class="form-group">
                  <label class="control-label col-md-3">*상품명(상품유형명)</label>
                  <div class="col-md-3 col-xs-11">
                    <input class="form-control form-control-inline input-medium default-date-picker" name="productType" id="productType2" size="32" type="text" required>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3">판매도시락상품코드</label>
                  <div class="col-md-3 col-xs-11">
                    <div> 
                      <select id="productCode" name="productCode">

			                	<option value="10">벌크업식단</option>
			                  	<option value="20">유지어터식단</option>
				                <option value="30">다이어트식단</option>
				                <option value="777">숨겨둔혜자식단</option>

			         </select>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3">도시락상품명</label>
                  <div class="col-md-3 col-xs-11">
                    <div>
                      <input class="form-control form-control-inline input-medium default-date-picker" name="productName" id="productName" size="32" type="text" value="" required>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3">가격</label>
                  <div class="col-md-4">
                    <div class="input-group input-large" data-date="01/01/2014" data-date-format="mm/dd/yyyy">
                      <input type="text" class="form-control dpd1" name="price">
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3">등록날짜</label>
                  <div class="col-md-3 col-xs-11">
                    <div>
                       <input type='date' name="registDate"/>
                    </div>
                 
                  </div>
                  </div>
                  <div class="form-group">
                  <label class="control-label col-md-3">판매상태여부</label>
                  <div class="col-md-3 col-xs-11">
                    <div> 
                      <select id="status" name="status">
			                	<option value="yes">Y</option>
			                  	<option value="no">N</option>
				                
			         </select>
                    </div>
                  </div>
                </div>
                 <div class="row mt">
          <div class="col-lg-12">
            <div class="form-panel">
             <!--  <form action="#" class="form-horizontal style-form"> -->
                <div class="form-group">
                  <label class="control-label col-md-3">도시락사진첨부</label>
                  <div class="col-md-4">
                    <input type="file" class="default" name="thumbnailImg1"  id="thumbnailImg1"  onchange="loadImg(this, 1)"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-md-3">Without input</label>
                  <div class="controls col-md-9">
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                      <span class="btn btn-theme02 btn-file">
                        <span class="fileupload-new"><i class="fa fa-paperclip"></i> Select file</span>
                      <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                      <input type="file" class="default" />
                      </span>
                      <span class="fileupload-preview" style="margin-left:5px;"></span>
                      <a href="advanced_form_components.html#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none; margin-left:5px;"></a>
                    </div>
                  </div>
                </div>
                <div class="form-group last">
                  <label class="control-label col-md-3">도시락사진보여지게하기</label>
                  <div class="col-md-9">
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                      <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;" id="titleImgArea">
                        <img id="titleImg" width="350" height="300"/>
                      </div>
                      
                      
                      <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                      
                    </div>
                    <span class="label label-info">NOTE!</span>
                    <span>
                      Attached image thumbnail is
                      supported in Latest Firefox, Chrome, Opera,
                      Safari and Internet Explorer 10 only
                      </span>
                   <div>
              <!-- </form> -->
            </div>
            <!-- /form-panel -->
          </div>
          <!-- /col-lg-12 -->
        </div>
        <!-- /row -->
        <!-- DATE TIME PICKERS -->
        
        <!-- row -->
        <!--ADVANCED FILE INPUT-->
       
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <input type="submit" value="상품등록" id="registDosirak">
                     <input type="submit" value="뒤로가기" id="goBack">
                     
                  </div>
                  </div>
                </div>
              </form>
            </div>
            <!-- /form-panel -->
          </div>
          <!-- /col-lg-12 -->
        </div>
        <!-- row -->
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
		<br>
		<div class="search-area" align="center">
			<select id="" name="">
				<option value="writer">상품코드</option>
				<option value="title">상품유형명</option>
				<option value="body">내용</option>
			</select>
			<input type="search" name="">
			<button type="submit">검색하기</button>
			<c:if test="">
				<button id="">작성하기</button>
			</c:if>
		</div>
		<br> 
		
					 <!-- 페이징 버튼 -->	
    
    
    <script>
    	const $titleImgArea = document.getElementById("titleImgArea");
    	
    	$titleImgArea.onclick = function(){
    		document.getElementById("thumbnailImg1").click(); 
    	}
    	
    	/*업로드된 사진 이미지 불러오기*/
    	
    	function loadImg(value, num) {
			if(value.files && value.files[0]) {
				const reader = new FileReader();
				
				reader.onload = function(e) {
					switch(num) {
					case 1 :
						document.getElementById("titleImg").src = e.target.result;
						break;
					
					}
				}
				
				reader.readAsDataURL(value.files[0]);
    		}
    	}
    </script>
    <!-- /MAIN CONTENT -->
     <!--main content end-->
    <!--footer start-->
	<jsp:include page="/WEB-INF/views/common/admin/adFooter.jsp"/>
	
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