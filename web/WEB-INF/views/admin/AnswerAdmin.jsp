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
              <li><a href="general.html">회원조회</a></li>
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
              <li><a id="adminNotice">공지사항</a></li>
              <li class="active"><a id="answer">Q&A</a></li>
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
        <h3><i class="fa fa-angle-right"></i> Q&A</h3>
        <!-- row -->
        <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
                <h4><i class="fa fa-angle-right"></i> 고객 질문</h4>
                <hr>
                <thead>
                  <tr>
                    <th>글번호</th>
                    <th><i class="fa fa-bullhorn"></i> 제목</th>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 작성자</th>
                    <th><i class="fa fa-bookmark"></i> 조회수</th>
                    <th><i class="fa fa-bookmark"></i> 날짜</th>
                    <th><i class=" fa fa-edit"></i> 상태</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="answer" items="${ requestScope.answerList }">
				<tr>
					<td><c:out value="${ answer.no }"/></td>
					<td><c:out value="${ answer.title }"/></td>
					<td><c:out value="${ answer.writer.name }"/></td>
					<td><c:out value="${ answer.count }"/></td>
					<td><c:out value="${ answer.createdDate }"/></td>
					<td><c:out value="${ answer.type }"/></td>
				</tr>
				</c:forEach>
<!--                   <tr>
                    <td>
                      <a href="basic_table.html#">샘플 아이콘</a>
                    </td>
                    <td class="hidden-phone">제목</td>
                    <td>작성자 </td>
                    <td>조회수</td>
                    <td><span class="label label-info label-mini">대기중</span>
                    <span class="label label-warning label-mini">답변완료</span>
                    <span class="label label-success label-mini">재질문</span>
                    </td>
                    <td>
                      <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                    </td>
                  </tr> -->
                </tbody>
              </table>
            
          <hr>
                <div class="search-area" align="center">
			<select id="searchCondition" name="searchCondition">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="body">내용</option>
			</select>
			<input type="search" name="searchValue">
			<button type="submit">검색하기</button>
			<c:if test="${ sessionScope.loginMember.status eq 'Y' }">
				<button id="writeAnswer">작성하기</button>
			</c:if>
		</div>
		
            <br>
            <!-- /content-panel -->
          <div class="pagingArea" align="center">
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
      </div></div></div>
          <!-- /col-md-12 -->
        </div>
        <!-- /row -->
      </section>
    </section>
    <!-- /MAIN CONTENT -->
    <script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "orangered";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.background = "white";
				}
				
				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/admin/answer/detail?no=" + no;
				}
			}
		}
	</script>
	<script>
      const link = "${ pageContext.servletContext.contextPath }/admin/answer";
      
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

		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
	</script>
    <!--main content end-->
  
  
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