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
<!--   <link href="/mg/resources/admin/jihunh.css" rel="stylesheet" /> -->
  <!-- Custom styles for this template -->
  <link href="/mg/resources/css/style.css" rel="stylesheet">
  <link href="/mg/resources/css/style-responsive.css" rel="stylesheet">
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
                    <a  id="adminMemberListButton" data-original-title="사용자 회원을 조회 합니다." data-placement="top" data-toggle="" class="btn mini tooltips">
                      <!-- <i class=" fa fa-refresh"></i> -->
                     	 회원 조회
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
					<th>이메일</th>
					<th>가입일</th>
					<th>상태</th>
				</tr>
				<c:forEach var="mgAdView" items="${ requestScope.mgAdList }">
				<tr>
					<td><input type="checkbox" class=""></td>
					<td><c:out value="${ mgAdView.no }"/></td>
					<td><c:out value="${ mgAdView.name }"/></td>
					<td><c:out value="${ mgAdView.id }"/></td>
					<td><c:out value="${ mgAdView.pno }"/></td>
					<td><c:out value="${ mgAdView.email }"/></td>
					<td><c:out value="${ mgAdView.enrollDate }"/></td>
					<td><c:out value="${ mgAdView.status }"/></td>
				</tr>
				</c:forEach>
                    </tbody>
                  </table>
                </div>
                </div>
                <hr>
        <form id="searchForm" action="${ pageContext.servletContext.contextPath}/admin/member/manageAd/search" method="get">
                <div class="search-area" align="center">
			<select id="searchCondition" name="searchCondition">
				<option value="mgAdName" <c:if test="${ requestScope.searchCondition eq 'mgAdName' }">selected</c:if>>이름</option>
				<option value="mgAdId" <c:if test="${ requestScope.searchCondition eq 'mgAdId' }">selected</c:if>>아이디</option>
				<option value="mgAdPno" <c:if test="${ requestScope.searchCondition eq 'mgAdPno' }">selected</c:if>>생년월일</option>
				<option value="mgAdEmail" <c:if test="${ requestScope.searchCondition eq 'mgAdEmail' }">selected</c:if>>이메일</option>
				<option value="mgAdEnrollDate" <c:if test="${ requestScope.searchCondition eq 'mgAdEnrollDate' }">selected</c:if>>입사일</option>
				<option value="mgAdStatus" <c:if test="${ requestScope.searchCondition eq 'mgAdStatus' }">selected</c:if>>상태</option>
			</select>
			<input type="search" name="searchValue" value="${ requestScope.searchValue }">
			<button type="submit">검색하기</button>
			<c:if test="${ sessionScope.loginMember.status eq 'Y' }">
				<button id="writeNotice" type="button">작성하기</button>
			</c:if>
		</div>
		</form>
		<br>
					 <!-- 페이징 버튼 -->
      <div class="pagingArea" align="center">
         <c:choose>
            <c:when test="${ empty requestScope.searchValue }">
         		<button id="startPage"><<</button>
         		
         		<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
         			<button disabled><</button>
         		</c:if>
         		<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
         			<button id=prevPage><</button>
         		</c:if>
         		
         		<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
         			<c:if test="${ requestScope.pageInfo.pageNo eq p }">
         				<button disabled><c:out value="${ p }"/></button>
         			</c:if>
         			<c:if test="${ requestScope.pageInfo.pageNo ne p }">
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
               <button id="searchStartPage"><<</button>
               
               <c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
               	<button disabled><</button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo > 1 }">
               	<button id="searchPrevPage"><</button>
               </c:if>
               
               <c:forEach var="s" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
               	<c:if test="${ requestScope.pageInfo.pageNo eq s }">
               		<button disabled><c:out value="${ s }"/></button>
               	</c:if>
               	<c:if test="${ requestScope.pageInfo.pageNo ne s }">
               		<button onclick="searchPageButtonAction(this.innerText)"><c:out value="${ s }"/></button>
               	</c:if>
               </c:forEach>
<%-- 				<p>${ s }</p> --%>
               <c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxpage }">
               	<button disabled>></button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxpage }">
               	<button id="searchNextPage">></button>
               </c:if>
               
               <button id="searchMaxPage">>></button>
            </c:otherwise>
         </c:choose>
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
					location.href = "${ pageContext.servletContext.contextPath }/admin/member/manageAd/detail?no=" + no;
				}
			}
		}
	</script>
	<script>
      const link = "${ pageContext.servletContext.contextPath }/admin/member/manageAd";
      const searchLink = "${ pageContext.servletContext.contextPath }/admin/member/manageAd/search"
      
      if(document.getElementById("startPage")) {
         const $startPage = document.getElementById("startPage");
         $startPage.onclick = function() {
            location.href = link + "?currentPage=1";
         }
      }
      
      if(document.getElementById("prevPage")) {
         const $prevPage = document.getElementById("prevPage");
         $prevPage.onclick = function() {
            location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1}";
         }
      }
      
      if(document.getElementById("nextPage")) {
         const $nextPage = document.getElementById("nextPage");
         $nextPage.onclick = function() {
            location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1}";
         }
      }
      
  
		if (document.getElementById("maxpage")) {
			const $maxpage = document.getElementById("maxpage");
			$maxpage.onclick = function() {
				location.href = link
						+ "?currentPage=${ requestScope.pageInfo.maxpage }";
			}
		}
		
		if(document.getElementById("searchStartPage")) {
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function() {
				location.href = searchLink + "?currentPage=1&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchPrevPage")) {
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo - 1}&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if (document.getElementById("searchNextPage")) {
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function() {
				location.href = searchLink
						+ "?currentPage=${ requestScope.pageInfo.pageNo + 1}&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchMaxPage")) {
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function() {
				location.href = searchLink
					+ "?currentPage=${ requestScope.pageInfo.maxpage }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}

		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
		
		function searchPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
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


















