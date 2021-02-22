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
     <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3>상품조회(Select Product)</h3>
        <div class="row mt">
          <div class="col-lg-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right"></i> 상품 조회</h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              
              <input type="button" value="상품등록하기" id="registMd">
             <!-- <section id="unseen"> -->
                <table class="table table-bordered table-striped table-condensed">
                  <thead>
                    <tr>
                      <th>번호</th>
                      <th>상품유형명</th>
                      <th class="numeric">판매도시락상품코드</th>
                      <th class="numeric">도시락상품명</th>
                      <th class="numeric">가격</th>
                      <th class="numeric">관리자회원번호</th>
                      <th class="numeric">생성일</th>
                      <th class="numeric">상품상태</th>
                      <th class="numeric">상태수정일</th>
                    </tr>
                  </thead>
                  <tbody>
               <c:forEach var="goods" items="${ requestScope.goodsList }">
				<tr>
					<td><c:out value="${ goods.no }"/></td>
					<td><c:out value="${ goods.goodsTypeNo.name }"/></td>
					<td><c:out value="${ goods.typeNo }"/></td>
					<td><c:out value="${ goods.name }"/></td>
					<td><c:out value="${ goods.price }"/></td>
					<td><c:out value="${ goods.writerMemberNo }"/></td>
					<td><c:out value="${ goods.createdDate }"/></td>
					<td><c:out value="${ goods.status }"/></td>
					<td><c:out value="${ goods.modifiedDate }"/></td>
				</tr>
				</c:forEach>
                  </tbody>
                </table>
              <!-- </section> -->
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-lg-4 -->
        </div>
        <!-- /row -->
      
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
	
		
		
						 <!-- 페이징 버튼 -->
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
               
               <c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
                  <button disabled>></button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
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
              
               <c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
               		<c:if test="${ requestScope.pageInfo.pageNo eq p }">
               			<button disabled><c:out value="${ p }"/></button>
               		</c:if>
               		
               		<c:if test="${ requestScope.pageInfo.pageNo ne p }">
               			<button onclick="searchPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
               		</c:if>
               </c:forEach>
              
               <c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
               		<button disabled>></button>
               </c:if>
               
               <c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
               		<button id="searchNextPage">></button>
               </c:if>
               <button id="searchMaxPage">>></button>
            </c:otherwise>
         </c:choose>
      </div>
		<!-- 검색폼 -->
			<form id="searchForm" action="${ pageContext.servletContext.contextPath }/admin/product/search" method="get">
    		<div class="search-area" align="center">
    			<select id="searchCondtion" name="searchCondition">
    				<option value="mdCode" <c:if test="${ requestScope.searchCondition eq 'mdCode' }">selected</c:if>>상품코드</option>
			        <option value="mdType" <c:if test="${ requestScope.searchCondition eq 'mdType' }">selected</c:if>>상품유형명</option>
				    <option value="mdName" <c:if test="${ requestScope.searchCondition eq 'mdName' }">selected</c:if>>도시락상품명</option>
			    </select>
		        	<input type="search" id="searchValue" name="searchValue">
			        <button type="submit">검색하기</button>
		     <%-- 	<c:if test="">
				<button id="">작성하기</button>
			</c:if> --%>
    		</div>
    	
    	</form> 
	
	
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
					const $update = this.parentNode.children[1].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/admin/update/product";
				}
			}
		}
		
		
		/* $(function() {
			$("#listArea td").hover(function() {
				$(this).parent().css({"background":"orangered", "cursor":"pointer"});
			}, function() {
				$(this).parent().css({"background":"black"});
			}).click(function() {
				const no = $(this).parent().children(":eq(0)").text();
				console.log(no);
			});
		}); */
		
	</script>
	
	<script>
      const link = "${ pageContext.servletContext.contextPath }/admin/SelectProduct";
      
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
      
  
		if (document.getElementById("maxPage")) {
			const $maxpage = document.getElementById("maxPage");
			$maxpage.onclick = function() {
				location.href = link
						+ "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}

		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
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