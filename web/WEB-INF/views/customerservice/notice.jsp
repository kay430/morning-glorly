
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
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/customer/notice.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
         <li class="sidebar-brand"><a href="${ pageContext.servletContext.contextPath }/customer/list"> CUSTOMER</a></li>
				<li class="sidebar-text"><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a>
				<li class="sidebar-text"><a href="${ pageContext.servletContext.contextPath }/question/list">질문과 답변</a></li>
				<li class="sidebar-text"><a href="${ pageContext.servletContext.contextPath }/product/review">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문시작 -->
		<div class="notice_header_txt">
			공지사항
			<div id="main-wrapper">
				<div id="page-content-wrapper">
					<div class="container-fluid">
						<div class="outer-notice-list">
							<div class="table-area">
								<table align="center" id="noticeTable">
									<tr class="board-list-tr">
										<th class="board-list-th list-header-bd">글번호</th>
										<th class="board-list-main-td list-header-bd">글제목</th>
										<th class="board-list-sub-td list-header-bd">작성자</th>
										<th class="board-list-sub-td list-header-bd">조회수</th>
										<th class="board-list-wdate">작성일</th>
									</tr>
									<c:forEach var="notice" items="${ requestScope.noticeList }">
										<tr class="board-list-tr">
											<td class="board-list-th list-header-bd"><c:out value="${ notice.no }" /></td>
											<td class="board-list-main-td"><c:out value="${ notice.title }" /></td>
											<td class="board-list-sub-td"><c:out value="${ notice.writer.name }" /></td>
											<td class="board-list-sub-td"><c:out value="${ notice.count }" /></td>
											<td class="board-list-wdate"><c:out value="${ notice.createdDate }" /></td>
										</tr>
									</c:forEach>
								</table>
							</div>
							<div class="search-area" align="center">
								<select id="searchCondition" name="searchCondition"style="font-family: 'Jua', sans-serif;font-size:25px;">
									<option value="writer">작성자</option>
									<option value="title">제목</option>
									<option value="body">내용</option>
								</select> <input type="search" name="searchValue"> 
								<button type="submit" style="font-family: 'Jua', sans-serif;font-size:25px; background-color:white;">검색하기</button>
							</div>
									 <!-- 페이징 버튼 -->
 	<div class="pagingArea" align="center" style="font-family: 'Jua', sans-serif;font-size:25px;">
         <c:choose>
            <c:when test="${ empty requestScope.searchValue }">
               <button id="startPage" style="background-color:white;"><<</button>
               <c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
                  <button disabled><</button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo > 1 }">
                  <button id="prevPage" style="background-color:white;"><</button>
               </c:if>
               
               <c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
               	<c:if test="${ requestScope.pageInfo.pageNo eq P }">
               		<button disabled><c:out value="${ p }"/></button>
               	</c:if>
               	<c:if test="${ requestScope.pageInfo.pageNo ne P }">
               		<button onclick="pageButtonAction(this.innerText);" style="background-color:white;"><c:out value="${ p }"/></button>
               	</c:if>
               </c:forEach>
               
               <c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxpage }">
                  <button disabled>></button>
               </c:if>
               <c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxpage }">
                  <button id="nextPage" style="background-color:white;">></button>
               </c:if>
               
               <button id="maxpage" style="background-color:white;">>></button>
               
            </c:when>
         </c:choose>
      </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- <jsp:include page="../common/footer.jsp" /> --%>
	
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
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/notice/detail?no=" + no;
				}
			}
		}
		
	</script>
	<script>
      const link = "${ pageContext.servletContext.contextPath }/notice/list";
      
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
</body>
</html>