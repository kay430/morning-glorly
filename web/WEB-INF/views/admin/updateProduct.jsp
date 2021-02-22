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
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>상품관리</span>
              </a>
            <ul class="sub">
              <li><a href=" ${ pageContext.servletContext.contextPath }/admin/registProduct" id="registProduct">상품등록</a></li>
              <li><a href=" ${ pageContext.servletContext.contextPath }/admin/SelectProduct" id="SelectProduct">상품조회</a></li>
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
    <br><br><br><br><br><br><br>	
     <div id="edit" class="tab-pane" >
                    <div class="row">
                      <div class="col-lg-8 col-lg-offset-2 detailed">
                        <h4 class="mb">상품 수정</h4>
                        <form role="form" class="form-horizontal" >
                          <div class="form-group" >
                            <label class="col-lg-2 control-label">*상품명(상품유형코드)</label>
                            <div class="col-lg-4" >
                              <input type="text" placeholder=" " id="c-name" class="form-control" name="updateProduct" id="updateProduct">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">*판매도시락 상품코드</label>
                            <div class="col-lg-4">
                             <select id="updateCode" name="updateCode">
			                	<option value="bulkup">10</option>
			                  	<option value="ujiater">20</option>
				                <option value="diet">30</option>
				                <option value="hyeja">777</option>
			         </select>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">*도시락상품명</label>
                            <div class="col-lg-4">
                              <input class="form-control form-control-inline input-medium default-date-picker" name="updateName" id="updateName" size="32" type="text" value="" required>
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label">가격</label>
                            <div class="col-lg-4">
                               <input type="text" class="form-control dpd1" name="price">
                            </div>
                          </div>
                          <div class="form-group">
                  <label class="control-label col-md-3">수정날짜</label>
                  <div class="col-md-3 col-xs-11">
                    <div>
                       <input type='date' name="updateDate"/>
                    </div>
                 
                  </div>
                  </div>
                  <div class="form-group">
                  <label class="control-label col-md-3">판매상태여부</label>
                  <div class="col-md-3 col-xs-11">
                    <div> 
                      <select id="status" name="updatestatus">
			                	<option value="yes">Y</option>
			                  	<option value="no">N</option>
				                
			         </select>
                    </div>
                  </div>
                </div>
                          
                          <div class="form-group last">
                  <label class="control-label col-md-3">사진첨부</label>
                  <div class="col-md-9">
                    <div class="fileupload fileupload-new" data-provides="fileupload">
                      <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                        <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" alt="" />
                      </div>
                      <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                      <div>
                        <span class="btn btn-theme02 btn-file">
                          <span class="fileupload-new"><i class="fa fa-paperclip"></i> Select image</span>
                        <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                        <input type="file" class="default" />
                        </span>
                        <a href="advanced_form_components.html#" class="btn btn-theme04 fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash-o"></i> Remove</a>
                      </div>
                    
                        </form>
                    
                      </div>
                      <!-- /col-lg-8 -->
                    </div>
                    <!-- /row -->
                  </div>
                  <!-- /tab-pane -->
     <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
   
	
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