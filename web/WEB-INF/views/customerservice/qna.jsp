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
	href="/mg/resources/css/customer/customer_qna.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
</head>

<body>

	<jsp:include page="../common/header.jsp" />

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="${ pageContext.servletContext.contextPath }/customer/list"> CUSTOMER</a></li>
				<li><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a>
				<li><a href="${ pageContext.servletContext.contextPath }/question/list">질문과 답변~</a></li>
				<li><a href="${ pageContext.servletContext.contextPath }/product/review">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
				<div class="notice_header_txt">
			질문과 답변
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="outer-notice-list">
					<div class="table-area">
						<table align="center" id="listArea">
							<tr class="board-list-tr">
								<th class="board-list-th list-header-bd">글번호</th>
								<th class="board-list-main-td list-header-bd">글제목</th>
								<th class="board-list-sub-td list-header-bd">작성자</th>
								<th class="board-list-sub-td list-header-bd">조회수</th>
								<th class="board-list-wdate list-header-bd">작성일</th>
								<th class="board-list-sub-td list-header-bd">처리상태</th>
							</tr>
							<c:forEach var="question" items="${ requestScope.questionList }">

								<tr class="board-list-tr">
									<td class="board-list-th list-header-bd"><c:out value="${ question.no }" /></td>
									<td class="board-list-main-td list-header-bd"><c:out value="${ question.title }" /></td>
									<td class="board-list-sub-td list-header-bd"><c:out value="${ question.mgDTO.name }" /></td>
									<td class="board-list-sub-td list-header-bd"><c:out value="${ question.count }" /></td>
									<td class="board-list-wdate list-header-bd"><c:out value="${ question.createDate }" /></td>
									<td class="board-list-sub-td list-header-bd"><c:out value="${ question.status }" /></td>

								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="search-area" align="center">
						<select id="searchCondition" name="searchCondition">
							<option value="writer">작성자</option>
							<option value="title">제목</option>
							<option value="body">내용</option>
						</select> <input type="search" name="searchValue">
						<button type="submit">검색하기</button>
						<button type="writeQuestion">작성하기</button>
					</div>
					</div>
	  <div class="pagingArea" align="center">
         <c:choose>
            <c:when test="${ empty requestScope.searchValue }">
               <button id="startPage"><<</button>
               <c:if test="${ requestScope.questionPageInfo.pageNo <= 1 }">
                  <button disabled><</button>
               </c:if>
               <c:if test="${ requestScope.questionPageInfo.pageNo > 1 }">
                  <button id="prevPage"><</button>
               </c:if>
               
               <c:forEach var="p" begin="${ requestScope.questionPageInfo.startPage }" end="${ requestScope.questionPageInfo.endPage }" step="1">
               	<c:if test="${ requestScope.questionPageInfo.pageNo eq P }">
               		<button disabled><c:out value="${ p }"/></button>
               	</c:if>
               	<c:if test="${ requestScope.questionPageInfo.pageNo ne P }">
               		<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
               	</c:if>
               </c:forEach>
               
               <c:if test="${ requestScope.questionPageInfo.pageNo >= requestScope.questionPageInfo.maxPage }">
                  <button disabled>></button>
               </c:if>
               <c:if test="${ requestScope.questionPageInfo.pageNo < requestScope.questionPageInfo.maxPage }">
                  <button id="nextPage">></button>
               </c:if>
               
               <button id="maxPage">>></button>
               
            </c:when>
         </c:choose>
      </div>
				</div>
			</div>
		</div>
		
	</div>
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
					location.href = "${ pageContext.servletContext.contextPath }/question/detail?no=" + no;
				}
			}
		}
		
	</script>
	<script>
      const link = "${ pageContext.servletContext.contextPath }/question/list";
      
      if(document.getElementById("startPage")) {
          const $startPage = document.getElementById("startPage");
          $startPage.onclick = function() {
             location.href = link + "?currentPage=1";
          }
       }
       
       if(document.getElementById("prevPage")) {
          const $prevPage = document.getElementById("prevPage");
          $prevPage.onclick = function() {
             location.href = link + "?currentPage=${ requestScope.QuestionPageInfo.pageNo - 1}";
          }
       }
       
       if(document.getElementById("nextPage")) {
          const $nextPage = document.getElementById("nextPage");
          $nextPage.onclick = function() {
             location.href = link + "?currentPage=${ requestScope.QuestionpPageInfo.pageNo + 1}";
          }
       }
       
   
 		if (document.getElementById("maxPage")) {
 			const $maxpage = document.getElementById("maxPage");
 			$maxpage.onclick = function() {
 				location.href = link
 						+ "?currentPage=${ requestScope.QuestionpPageInfo.maxPage }";
 			}
 		}

 		function pageButtonAction(text) {
 			location.href = link + "?currentPage=" + text;
 		}
 		</script>
	
	
	<!--<jsp:include page="../common/footer.jsp" /> -->	

</body>
</html>