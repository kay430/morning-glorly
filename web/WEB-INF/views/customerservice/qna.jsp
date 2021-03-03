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
	     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
								<th class="board-list-sub-td list-header-bd">문의유형</th>
							</tr>
							<c:forEach var="question" items="${ requestScope.questionList }">

								<tr class="board-list-tr">
									<td class="board-list-th list-header-bd"><c:out value="${ question.no }" /></td>
									<td class="board-list-main-td"><c:out value="${ question.title }" /></td>
									<td class="board-list-sub-td"><c:out value="${ question.mgDTO.name }" /></td>
									<td class="board-list-sub-td"><c:out value="${ question.count }" /></td>
									<td class="board-list-wdate"><c:out value="${ question.createDate }" /></td>
									<td class="board-list-sub-td"><c:out value="${ question.status }" /></td>
									<td class="board-list-sub-td"><c:out value="${ question.category.name }"/></td>

								</tr>
							</c:forEach>
						</table>
					</div>
					
						
		<form id="searchForm" action="${ pageContext.servletContext.contextPath }/question/search" method="get">
    		<div class="search-area" align="center">
    			<select id="searchCondtion" name="searchCondition"style="font-family: 'Jua', sans-serif;
	font-size:25px;">
    				<option value="QueName" <c:if test="${ requestScope.searchCondition eq 'QueName' }">selected</c:if>>작성자</option>
			        <option value="QueTitle" <c:if test="${ requestScope.searchCondition eq 'QueTitle' }">selected</c:if>>제목</option>
				    <option value="QueBody" <c:if test="${ requestScope.searchCondition eq 'QueBody' }">selected</c:if>>내용</option>
			    </select>
		        	<input type="search" id="searchValue" name="searchValue" value="${ requestScope.searchValue }">
		        	<button type="submit"style="font-family: 'Jua', sans-serif; font-size:25px; background-color: white;">검색하기</button>
    	         	<button  type="button" id="writeQuestion"style="font-family: 'Jua', sans-serif; font-size:25px; background-color: white;">작성하기</button>	
    	         	  </div>
    	         	  </form> 
							           		
					
	  <div class="pagingArea" align="center"style="font-family: 'Jua', sans-serif; font-size:25px;">
         <c:choose>
            <c:when test="${ empty requestScope.searchValue }">
               <button id="startPage" style="background-color:white"><<</button>
               <c:if test="${ requestScope.questionPageInfo.pageNo <= 1 }">
                  <button disabled style="background-color:white;"><</button>
               </c:if>
               <c:if test="${ requestScope.questionPageInfo.pageNo > 1 }">
                  <button id="prevPage" style="background-color:white;"><</button>
               </c:if>
               
               <c:forEach var="p" begin="${ requestScope.questionPageInfo.startPage }" end="${ requestScope.questionPageInfo.endPage }" step="1">
               	<c:if test="${ requestScope.questionPageInfo.pageNo eq P }">
               		<button disabled style="background-color:white"><c:out value="${ p }"/></button>
               	</c:if>
               	<c:if test="${ requestScope.questionPageInfo.pageNo ne P }">
               		<button onclick="pageButtonAction(this.innerText);" style="background-color:white;"><c:out value="${ p }"/></button>
               	</c:if>
               </c:forEach>
               
               <c:if test="${ requestScope.questionPageInfo.pageNo >= requestScope.questionPageInfo.maxPage }">
                  <button disabled style="background-color:white">></button>
               </c:if>
               <c:if test="${ requestScope.questionPageInfo.pageNo < requestScope.questionPageInfo.maxPage }">
                  <button id="nextPage" style="background-color:white">></button>
               </c:if>
               
               <button id="maxPage" style="background-color:white">>></button>
               
            </c:when>
             <c:otherwise>
               <button id="searchStartPage"><<</button>
               
               <c:if test="${ requestScope.questionPageInfo.pageNo <= 1 }">
                  <button disabled><</button>
               </c:if>
               <c:if test="${ requestScope.questionPageInfo.pageNo > 1 }">
                  <button id="searchPrevPage"><</button>
               </c:if>
              
               <c:forEach var="p" begin="${ requestScope.questionPageInfo.startPage }" end="${ requestScope.questionPageInfo.endPage }" step="1">
               		<c:if test="${ requestScope.questionPageInfo.pageNo eq p }">
               			<button disabled><c:out value="${ p }"/></button>
               		</c:if>
               		
               		<c:if test="${ requestScope.questionPageInfo.pageNo ne p }">
               			<button onclick="searchPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
               		</c:if>
               </c:forEach>
              
               <c:if test="${ requestScope.questionPageInfo.pageNo >= requestScope.questionPageInfo.maxPage }">
               		<button disabled>></button>
               </c:if>
               
               <c:if test="${ requestScope.questionPageInfo.pageNo < requestScope.questionPageInfo.maxPage }">
               		<button id="searchNextPage">></button>
               </c:if>
               <button id="searchMaxPage">>></button>
            </c:otherwise>
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
      const searchLink = "${ pageContext.servletContext.contextPath}/question/search";
      
      if(document.getElementById("startPage")) {
          const $startPage = document.getElementById("startPage");
          $startPage.onclick = function() {
             location.href = link + "?currentPage=1";
          }
       }
       
       if(document.getElementById("prevPage")) {
          const $prevPage = document.getElementById("prevPage");
          $prevPage.onclick = function() {
             location.href = link + "?currentPage=${ requestScope.questionPageInfo.pageNo - 1}";
          }
       }
       
       if(document.getElementById("nextPage")) {
          const $nextPage = document.getElementById("nextPage");
          $nextPage.onclick = function() {
             location.href = link + "?currentPage=${ requestScope.questionPageInfo.pageNo + 1}";
          }
       }
       
   
 		if (document.getElementById("maxPage")) {
 			const $maxpage = document.getElementById("maxPage");
 			$maxpage.onclick = function() {
 				location.href = link
 						+ "?currentPage=${ requestScope.questionPageInfo.maxPage }";
 			}
 		}
 		
 		if(document.getElementById("searchStartPage")) {
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function() {
				location.href = searchLink + "?currentPage=1&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}
		
		if(document.getElementById("searchPrevPage")) {
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.questionPageInfo.pageNo - 1 }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}
		
		if(document.getElementById("searchNextPage")) {
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.questionPageInfo.pageNo + 1 }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}
		
		if(document.getElementById("searchMaxPage")) {
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.questionPageInfo.maxPage }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}

 		function pageButtonAction(text) {
 			location.href = link + "?currentPage=" + text;
 		}
 		
 		function searchPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
		}
 		</script>

	
	<!--<jsp:include page="../common/footer.jsp" /> -->	


</body>
</html>