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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script src="/mg/resources/js/adminjihun.js"></script>

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
            <a class="active" href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span>회원관리</span>
              </a>
            <ul class="sub">
             <li class="active"><a id="adminMemberList">회원조회</a></li>
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
            <a href="javascript:;">
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
    <section id="main-content">
      <section class="wrapper site-min-height">
        <div class="row mt">
          <div class="col-lg-12">
            <div class="row content-panel">
              <div class="col-md-4 profile-text mt mb centered">
                <div class="right-divider hidden-sm hidden-xs">
                <table align="center">
                	<tr>
                		<th><h4 align="center">생년월일  </h4></th>
                		<th><h4>: <c:out value="${ mgList.pno }"/></h4></th>
                	</tr>
                	<tr>
                		<th><h4 align="center">성별 </h4></th>
                		<th><h4>: <c:out value="${ mgList.pno }"/></h4></th>
                	</tr>
                	<tr>
                		<th><h4 align="center">연락처 </h4></th>
                		<th><h4>: <c:out value="${ mgList.phone }"/></h4></th>
                	</tr>
                	<tr>
                		<th><h4 align="center">이메일  </h4></th>
                		<th><h4>: <c:out value="${ mgList.email }"/></h4></th>
                	</tr>
                	<tr>
                		<th><h4 align="center"><i class="fa fa-money"></i>포인트</h4></th>
                		<th><h4 >: <c:out value="${ mgList.point }"/></h4></th>
                	</tr>
                </table>
                </div>
              </div>
              <!-- /col-md-4 -->
              <div class="col-md-4 profile-text">
              	<c:choose>
              		<c:when test="${ mgList.blackList ne 'BLCUNS' }">
              			<c:if test="${ mgList.status eq 'Y' }">
              				<h3><c:out value="${ mgList.name }"/></h3>
              			</c:if>
              			<c:if test="${ mgList.status eq 'N' }">
              			<table>
              				<tr>
              					<th><h3><c:out value="${ mgList.name }"/></h3></th>
              					<th><h4 style="color: red;">탈퇴 회원</h4></th>
              				</tr>
              			</table>
              			</c:if>
              		</c:when>
              		<c:otherwise>
              			<c:if test="${ mgList.status eq 'Y' }">
              			<table>
              				<tr>
              					<th><h3 style="color: red;">블랙리스트 : </h3></th>
              					<th><h3> <c:out value="${ mgList.name }"/></h3></th>
              				</tr>
              			</table>
              			</c:if>
              			<c:if test="${ mgList.status eq 'N' }">
              			<table>
              				<tr>
              					<th><h3 style="color: red;">블랙리스트 : </h3></th>
              					<th><h3><c:out value="${ mgList.name }"/></h3></th>
              					<th><h4 style="color: red;">탈퇴 회원</h4></th>
              				</tr>
              			</table>
              			</c:if>
              		</c:otherwise>
              	</c:choose>
              	<table>
              		<tr>
              			<th><h4>[No_<c:out value="${ mgList.no }"/>].</h4></th>
              			<th><h4><c:out value="${ mgList.id }"/></h4></th>
              			<th><h4>(<c:out value="${ mgList.enrollDate }"/>~ 
              			<c:if test="${ mgList.status eq 'N' }">
              				<c:out value="${ mgList.modifiedDate }"/>
              			</c:if>
              			)</h4></th>
              		</tr>
              	</table>
                <h4><c:out value="${ mgList.address }"/></h4>
                <br>
                <h4><c:out value="${ mgList.email }"/> <button class="btn btn-theme"><i class="fa fa-envelope"></i> Send Message</button></h4>
              </div>
              <!-- /col-md-4 -->
              <div class="col-md-4 centered">
                <div class="profile-pic">
                  <p><img src="img/ui-sam.jpg" class="img-circle"></p>
                  <p>
                    <button class="btn btn-theme"><i class="fa fa-check"></i> Follow</button>
                    <button class="btn btn-theme02">Add</button>
                  </p>
                </div>
              </div>
              <!-- /col-md-4 -->
            </div>
            <!-- /row -->
          </div>
          <!-- /col-lg-12 -->
          <div class="col-lg-12 mt">
            <div class="row content-panel">
              <div class="panel-heading">
                <ul class="nav nav-tabs nav-justified">
                  <li class="active">
                    <a data-toggle="tab" href="#overview">Overview</a>
                  </li>
                  <li>
                    <a data-toggle="tab" href="#contact" class="contact-map">Contact</a>
                  </li>
                  <li>
                    <a data-toggle="tab" href="#edit">Edit Profile</a>
                  </li>
                </ul>
              </div>
              <!-- /panel-heading -->
              <div class="panel-body">
                <div class="tab-content">
                  <div id="overview" class="tab-pane active">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="detailed mt">
                          <h4>Recent BlackList Activity</h4>
                 <table style="text-align: center;">
                	<tr style="font-color: black;">
                		<th><h4 align="center">번호  </h4></th>
                		<th><h4 align="center">적용 날짜  </h4></th>
                		<th><h4 align="center">변경 사유  </h4></th>
                		<th><h4 align="center">블랙 상태  </h4></th>
                	</tr>
             		   <c:forEach var="mgBlack" items="${ mgList.mgBlack }">
                	<tr>
   						<td><h4><c:out value="${mgBlack.no}" /></h4></td>
   						<td><h4><c:out value="${mgBlack.createdDate}" /></h4></td>
   						<td width="550px"><h4><c:out value="${mgBlack.reasonInfo}" /></h4></td>
   						<td><h4><c:out value="${mgBlack.status}" /></h4></td>
                	</tr>
						</c:forEach>
                </table>
                   <!-- /content-panel -->
          <div align="center">
         <c:choose>
            <c:when test="${ empty requestScope.searchValue }">
               <button id="startPage"><<</button>
               <c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
                  <button disabled><</button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo > 1 }">
                  <button id="prevPage"><</button>
               </c:if>
               
               <c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
               	<c:if test="${ requestScope.pageInfo.pageNo eq P }">
               		<button disabled><c:out value="${ p }"/></button>
               	</c:if>
               	<c:if test="${ requestScope.pageInfo.pageNo ne P }">
               		<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
               	</c:if>
               </c:forEach>
               
               <c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxpage }">
                  <button disabled>></button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxpage }">
                  <button id="nextPage">></button>
               </c:if>
               
               <button id="maxpage">>></button>
               
            </c:when>
            <c:otherwise>
               
            </c:otherwise>
         </c:choose>
      </div>
                          <div class="recent-activity">
                            <div class="activity-icon bg-theme"><i class="fa fa-check"></i></div>
                            <div class="activity-panel">
                              <h5>1 HOUR AGO</h5>
                              <p>Purchased: Dashio Admin Panel & Front-end theme.</p>
                            </div>
                            <div class="activity-icon bg-theme02"><i class="fa fa-trophy"></i></div>
                            <div class="activity-panel">
                              <h5>5 HOURS AGO</h5>
                              <p>Task Completed. Resolved issue with Disk Space.</p>
                            </div>
                            <div class="activity-icon bg-theme04"><i class="fa fa-rocket"></i></div>
                            <div class="activity-panel">
                              <h5>3 DAYS AGO</h5>
                              <p>Launched a new product: Flat Pack Heritage.</p>
                            </div>
                          </div>
                          <!-- /recent-activity -->
                        </div>
                        <!-- /detailed -->
                      </div>
            <!-- 우측 부분 -->
                      <!-- /col-md-6 -->
                      <div class="col-md-6 detailed">
                        <h4>블랙리스트 변경하기</h4>
                        <div class="row centered mt mb" style=";">
                        <textarea id="mgBlackReason"rows="3" class="form-control" placeholder="수정하기를 누르면 블랙리스트 상태 변경이 가능합니다." readonly></textarea>
                        <div id="holdUp" style="float: left;">
               		   <button id="modifyButton" class="btn btn-sm">
       		           <i class="fa fa-arrow-right"></i> 수정하기
                  		</button>
		                  </div>
		                  <div id="mgBlackFinish" style="float: left;">
		                  <select id="ajaxStatus" name="status">
		                  	<option value="Y">블랙리스트 적용</option>
		                  	<option value="N">블랙리스트 해제</option>
		                  </select>
               		   <button id="finallyFinish" class="btn btn-sm">
       		           <i class="fa fa-arrow-right"></i> 완료하기
                  		</button>
		                  </div>
                        </div>
						<script>
/* 							window.onload = function() {
								console.log("숨김완료");
								console.log('${ pageNumNo }');
								$("#mgBlackFinish").css("display","none");
								
							} */
							
							$("#modifyButton").click(function() {
								$("#modifyButton").css("display","none");
								$("#mgBlackFinish").css("display","block");
								$("#mgBlackReason").attr('readonly', false);
								alert("변경을 진행합니다");
								
								$("#finallyFinish").click(function() {
									
									if(confirm("블랙리스트 변경을 완료하시겠습니까?")) {
										const reason = document.getElementById("mgBlackReason").value;
										const status = document.getElementById("ajaxStatus").value;
										const pageNo = '${ pageNumNo }';
										const loginNo = '${ sessionScope.loginMember.no }';
										
										$.ajax({
											url: "${ pageContext.servletContext.contextPath }/admin/member/manage/updateBlackList",
											type: "post",
											data: {reason : reason, status : status, pageNo : pageNo, loginNo : loginNo },
											success: function(data, textStatus, xhr) {
												document.getElementById("mgBlackReason").innerHTML = data;
									/* 			$("#mgBlackFinish").css("display", "none");
												$("#mgBlackReason").attr('readonly', true);
												$("#modifyButton").css("display", "block"); */
												console.log("변경 완료");
												console.log(data);
												location.href = "${ pageContext.servletContext.contextPath }/admin/member/manage/detail?no=" + pageNo;
											},
											error: function(xhr, status, error) {
												console.log(error);
												console.log("에러에러에러");
											}
										});
										
										
										
										alert("변경 완료");
									} else {
										alert("변경 취소");
									}
									
								});
							});
						</script>
                        <!-- /row -->
                        <h4>My Friends</h4>
                        <!-- /row -->
                        <h4>Pending Tasks</h4>
                        <div class="row centered">
                          <div class="col-md-8 col-md-offset-2">
                            <h5>Dashboard Update (40%)</h5>
                            <div class="progress">
                              <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                <span class="sr-only">40% Complete (success)</span>
                              </div>
                            </div>
                            <h5>Unanswered Messages (80%)</h5>
                            <div class="progress">
                              <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                <span class="sr-only">80% Complete (success)</span>
                              </div>
                            </div>
                            <h5>Product Review (60%)</h5>
                            <div class="progress">
                              <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                <span class="sr-only">60% Complete (success)</span>
                              </div>
                            </div>
                            <h5>Friend Requests (90%)</h5>
                            <div class="progress">
                              <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                <span class="sr-only">90% Complete (success)</span>
                              </div>
                            </div>
                          </div>
                          <!-- /col-md-8 -->
                        </div>
                        <!-- /row -->
                      </div>
                      <!-- /col-md-6 -->
                    </div>
                    <!-- /OVERVIEW -->
                  </div>
                  <!-- /tab-pane -->
                  <div id="contact" class="tab-pane">
                    <div class="row">
                      <div class="col-md-6">
                        <div id="map"></div>
                      </div>
                      <!-- /col-md-6 -->
                      <div class="col-md-6 detailed">
                        <h4>Location</h4>
                        <div class="col-md-8 col-md-offset-2 mt">
                          <p>
                            Postal Address<br/> PO BOX 12988, Sutter Ave<br/> Brownsville, New York.
                          </p>
                          <br>
                          <p>
                            Headquarters<br/> 844 Sutter Ave,<br/> 9003, New York.
                          </p>
                        </div>
                        <h4>Contacts</h4>
                        <div class="col-md-8 col-md-offset-2 mt">
                          <p>
                            Phone: +33 4898-4303<br/> Cell: 48 4389-4393<br/>
                          </p>
                          <br>
                          <p>
                            Email: hello@dashiotheme.com<br/> Skype: UseDashio<br/> Website: http://Alvarez.is
                          </p>
                        </div>
                      </div>
                      <!-- /col-md-6 -->
                    </div>
                    <!-- /row -->
                  </div>
                  <!-- /tab-pane -->
                  <div id="edit" class="tab-pane">
                    <div class="row">
                      <div class="col-lg-8 col-lg-offset-2 detailed">
                        <h4 class="mb">Personal Information</h4>
                        <form role="form" class="form-horizontal">
                          <div class="form-group">
                            <label class="col-lg-2 control-label"> Avatar</label>
                            <div class="col-lg-6">
                              <input type="file" id="exampleInputFile" class="file-pos">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Company</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="c-name" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Lives In</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="lives-in" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Country</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="country" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Description</label>
                            <div class="col-lg-10">
                              <textarea rows="10" cols="30" class="form-control" id="" name=""></textarea>
                            </div>
                          </div>
                        </form>
                      </div>
                      <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h4 class="mb">Contact Information</h4>
                        <form role="form" class="form-horizontal">
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Address 1</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="addr1" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Address 2</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="addr2" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Phone</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="phone" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Cell</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="cell" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Email</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="email" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Skype</label>
                            <div class="col-lg-6">
                              <input type="text" placeholder=" " id="skype" class="form-control">
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                              <button class="btn btn-theme" type="submit">Save</button>
                              <button class="btn btn-theme04" type="button">Cancel</button>
                            </div>
                          </div>
                        </form>
                      </div>
                      <!-- /col-lg-8 -->
                    </div>
                    <!-- /row -->
                  </div>
                  <!-- /tab-pane -->
                </div>
                <!-- /tab-content -->
              </div>
              <!-- /panel-body -->
            </div>
            <!-- /col-lg-12 -->
          </div>
          <!-- /row -->
        </div>
        <!-- /container -->
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    
    <hr><!-- 기존꺼 -->
    <!--main content start-->
    <section id="main-content">
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
                    공지사항
                    <form action="#" class="pull-right mail-src-position">
                      <div class="input-append">
                        <!-- <input type="text" class="form-control " placeholder="Search Mail"> -->
                      </div>
                    </form>
                  </h4>
              </header>
              <div class="panel-body minimal">
                <div class="mail-option">
                  <div class="chk-all">
                    <div class="pull-left mail-checkbox">
                      <input type="checkbox" class="">
                    </div>
                    <div class="btn-group">
                      <a data-toggle="dropdown" href="#" class="btn mini all">
                        All
                        <i class="fa fa-angle-down "></i>
                        </a>
                      <ul class="dropdown-menu">
                        <li><a href="#"> None</a></li>
                        <li><a href="#"> Read</a></li>
                        <li><a href="#"> Unread</a></li>
                      </ul>
                    </div>
                  </div>
                  <div class="btn-group">
                    <a id="adminMemberAdList" data-original-title="관리자회원을 조회할수 있습니다" data-placement="top" data-toggle="" class="btn mini tooltips">
                      <!-- <i class=" fa fa-refresh"></i> -->
                     	 관리자 조회
                      </a>
                  </div>
                  <div class="btn-group hidden-phone">
                    <a data-toggle="dropdown" href="#" class="btn mini blue">
                      More
                      <i class="fa fa-angle-down "></i>
                      </a>
                    <ul class="dropdown-menu">
                      <li><a href="#"><i class="fa fa-pencil"></i> Mark as Read</a></li>
                      <li><a href="#"><i class="fa fa-ban"></i> Spam</a></li>
                      <li class="divider"></li>
                      <li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
                    </ul>
                  </div>
<!--                   <div class="btn-group">
                    <a data-toggle="dropdown" href="#" class="btn mini blue">
                      Move to
                      <i class="fa fa-angle-down "></i>
                      </a>
                    <ul class="dropdown-menu">
                      <li><a href="#"><i class="fa fa-pencil"></i> Mark as Read</a></li>
                      <li><a href="#"><i class="fa fa-ban"></i> Spam</a></li>
                      <li class="divider"></li>
                      <li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
                    </ul>
                  </div> -->
                 <!--  <ul class="unstyled inbox-pagination">
                    <li><span>1-50 of 99</span></li>
                    <li>
                      <a class="np-btn" href="#"><i class="fa fa-angle-left  pagination-left"></i></a>
                    </li>
                    <li>
                      <a class="np-btn" href="#"><i class="fa fa-angle-right pagination-right"></i></a>
                    </li>
                  </ul> -->
                </div>
                <div class="table-inbox-wrap ">
                  <table id="memberManagement" class="table table-inbox table-hover">
                    <tbody>
                    <!-- 추후에 활용해볼 css -->
                      <!-- <tr class="unread">
                        <td class="inbox-small-cells">
                          <input type="checkbox" class="mail-checkbox">
                        </td>
                          <td class="inbox-small-cells"><i class="fa fa-star"></i></td>
                          <td class="view-message  dont-show"><a href="">Google Inc.</a></td>
                          <td class="view-message "><a href="">Your new account is ready.</a></td>
                          <td class="view-message  inbox-small-cells"><i class="fa fa-paperclip"></i></td>
                          <td class="view-message  text-right">08:10 AM</td>
                      </tr>
                      <tr class="unread">
                        <td class="inbox-small-cells">
                          <input type="checkbox" class="mail-checkbox">
                        </td>
                        <td class="inbox-small-cells"><i class="fa fa-star"></i></td>
                        <td class="view-message dont-show"><a href="mail_view.html">Mark Thompson</a></td>
                        <td class="view-message"><a href="mail_view.html">Last project updates</a></td>
                        <td class="view-message inbox-small-cells"></td>
                        <td class="view-message text-right">March 15</td>
                      </tr>
                      <tr class="unread">
                        <td class="inbox-small-cells">
                          <input type="checkbox" class="mail-checkbox">
                        </td>
                        <td class="inbox-small-cells"><i class="fa fa-star"></i></td>
                        <td class="view-message dont-show"><a href="mail_view.html">Wonder Corp.</a></td>
                        <td class="view-message"><a href="mail_view.html">Thanks for your registration</a></td>
                        <td class="view-message inbox-small-cells"></td>
                        <td class="view-message text-right">March 15</td>
                      </tr>
                      <tr class="">
                        <td class="inbox-small-cells">
                          <input type="checkbox" class="mail-checkbox">
                        </td>
                        <td class="inbox-small-cells"><i class="fa fa-star"></i></td>
                        <td class="view-message dont-show"><a href="mail_view.html">Facebook</a></td>
                        <td class="view-message"><a href="mail_view.html">New Friendship Request</a></td>
                        <td class="view-message inbox-small-cells"></td>
                        <td class="view-message text-right">March 13</td>
                      </tr> -->
                     <style>
                      /* #memberManagement th:nth-child(2) {
                      background-color: red;
                      }
                      #memberManagement td {
                      text-align: center;
                      } */
                      </style>
                      <tr>
					<th><input type="checkbox" class=""></th>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>이메일</th>
					<th>주소</th>
					<th>폰번호</th>
					<th>포인트</th>
					<th>가입일</th>
					<th>블랙여부</th>
					<th>상태</th>
				</tr>
				<c:if test="${ requestScope.mgList ne null }">
				<tr>
					<td><input type="checkbox" class=""></td>
					<td><c:out value="${ mgList.no }"/></td>
					<td><c:out value="${ mgList.name }"/></td>
					<td><c:out value="${ mgList.id }"/></td>
					<td><c:out value="${ mgList.pno }"/></td>
					<td><c:out value="${ mgList.gender }"/></td>
					<td><c:out value="${ mgList.email }"/></td>
					<td><c:out value="${ mgList.address }"/></td>
					<td><c:out value="${ mgList.phone }"/></td>
					<td><c:out value="${ mgList.point }"/></td>
					<td><c:out value="${ mgList.enrollDate }"/></td>
					<td><c:out value="${ mgList.blackList }"/></td>
					<td><c:out value="${ mgList.status }"/></td>
				</tr>
				</c:if>
<%-- 				<c:forEach var="mgView" items="${ requestScope.mgList }">
				<tr>
					<td><input type="checkbox" class=""></td>
					<td><c:out value="${ mgView.no }"/></td>
					<td><c:out value="${ mgView.name }"/></td>
					<td><c:out value="${ mgView.id }"/></td>
					<td><c:out value="${ mgView.pno }"/></td>
					<td><c:out value="${ mgView.gender }"/></td>
					<td><c:out value="${ mgView.email }"/></td>
					<td><c:out value="${ mgView.address }"/></td>
					<td><c:out value="${ mgView.phone }"/></td>
					<td><c:out value="${ mgView.point }"/></td>
					<td><c:out value="${ mgView.enrollDate }"/></td>
					<td><c:out value="${ mgView.blackList }"/></td>
					<td><c:out value="${ mgView.status }"/></td>
				</tr>
				</c:forEach> --%>
                    </tbody>
                  </table>
                </div>
                </div>
		
              </div>
            </section>
          </div>
      </section>
      <!-- /wrapper -->
    </section>
    	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "yellow";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.background = "white";
				}
				
				$tds[i].onclick = function() {
					const no = this.parentNode.children[1].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/admin/member/manage/detail?no=" + no;
				}
			}
		}
	</script>
	<script>
      const link = "${ pageContext.servletContext.contextPath }/admin/member/manage/detail?no=${ pageNumNo }&";
      const searchLink = "${ pageContext.servletContext.contextPath }/admin/member/manage/search"
      
      if(document.getElementById("startPage")) {
         const $startPage = document.getElementById("startPage");
         $startPage.onclick = function() {
            location.href = link + "currentPage=1";
         }
      }
      
      if(document.getElementById("prevPage")) {
         const $prevPage = document.getElementById("prevPage");
         $prevPage.onclick = function() {
            location.href = link + "currentPage=${ requestScope.pageInfo.pageNo - 1}";
         }
      }
      
      if(document.getElementById("nextPage")) {
         const $nextPage = document.getElementById("nextPage");
         $nextPage.onclick = function() {
            location.href = link + "currentPage=${ requestScope.pageInfo.pageNo + 1}";
         }
      }
      
  
		if (document.getElementById("maxpage")) {
			const $maxpage = document.getElementById("maxpage");
			$maxpage.onclick = function() {
				location.href = link
						+ "currentPage=${ requestScope.pageInfo.maxpage }";
			}
		}

		function pageButtonAction(text) {
			location.href = link + "currentPage=" + text;
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


















