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
	href="/mg/resources/css/customer/customer_main.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
</head>

<body>
	<form id="ReviewForm" action="${ pageContext.servletContext.contextPath }/notice/review" method="post">
	<jsp:include page="../common/header.jsp" />

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> 고객센터</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">질문과 답변</a></li>
				<li><a href="#">상품 후기 </a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<h1>상품 리뷰</h1>
		<hr>
		<div id="page-content-wrapper">
			<div class="container-fluid">

				<div class="outer-notice-list">
					<div class="table-area">
						<table align="center" id="listArea">
							<tr>
								<th>글번호</th>
								<th width="300px">글제목</th>
								<th width="100px">작성자</th>
								<th>조회수</th>
								<th width="100px">작성일</th>
							</tr>
							<c:forEach var="notice" items="${ requestScope.noticeList }">
								<tr>
									<td><c:out value="${ review.no }" /></td>
									<td><c:out value="${ notice.title }" /></td>
									<td><c:out value="${ notice.writer.nickname }" /></td>
									<td><c:out value="${ notice.count }" /></td>
									<td><c:out value="${ notice.createdDate }" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
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

								<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }"
									end="${ requestScope.pageInfo.endPage }" step="1">
									<c:if test="${ requestScope.pageInfo.pageNo eq p }">
										<button disabled>
											<c:out value="${ p }" />
										</button>
									</c:if>
									<c:if test="${ requestScope.pageInfo.pageNo ne p }">
										<button onclick="pageButtonAction(this.innerText);">
											<c:out value="${ p }" />
										</button>
									</c:if>
								</c:forEach>

								<c:if
									test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
									<button disabled>></button>
								</c:if>
								<c:if
									test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
									<button id="nextPage">></button>
								</c:if>

								<button id="maxPage">>></button>

							</c:when>
							<c:otherwise>
								<button id="searchStartPage"><<</button>
								<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
									<button disabled><</button>
								</c:if>
								<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
									<button id="searchPrevPage"><</button>
								</c:if>

								<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }"
									end="${ requestScope.pageInfo.endPage }" step="1">
									<c:if test="${ requestScope.pageInfo.pageNo eq p }">
										<button disabled>
											<c:out value="${ p }" />
										</button>
									</c:if>
									<c:if test="${ requestScope.pageInfo.pageNo ne p }">
										<button onclick="searchPageButtonAction(this.innerText);">
											<c:out value="${ p }" />
										</button>
									</c:if>
								</c:forEach>

								<c:if
									test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
									<button disabled>></button>
								</c:if>
								<c:if
									test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
									<button id="searchNextPage">></button>
								</c:if>
								<button id="searchMaxPage">>></button>
							</c:otherwise>
						</c:choose>


					 </div>
					<form id="searchForm"action="${ pageContext.servletContext.contextPath }/review/search"method="get">
						<div class="search-area" align="center">
							<select id="searchCondition" name="searchCondition">
								<option value="writer">작성자</option>
								<option value="title">제목</option>
								<option value="body">내용</option>
							</select> <input type="search" name="searchValue">
							<button type="submit">검색하기</button>
							<%-- <c:if test="${ sessionScope.loginMember.role eq 'MEMBER }"> --%>
								<button id="writeNotice">작성하기</button>
								
						</div>
					</form>
				</div>
			</div>
		</div>
	</div> 
	<script>
		if (document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");

			for (let i = 0; i < $tds.length; i++) {

				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "orangered";
					this.parentNode.style.cursor = "pointer";
				}

				$tds[i].onmouseout = function() {
					this.parentNode.style.background = "black";
				}

				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/notice/detail?no="
							+ no;
				}
			}
		}
	</script>
	<script>
		const link = "${ pageContext.servletContext.contextPath }/notice/list";
		const searchLink = "${ pageContext.servletContext.contextPath}/notice/search";

		if (document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1";
			}
		}

		if (document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link
						+ "?currentPage=${ requestScope.pageInfo.pageNo - 1}";
			}
		}

		if (document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link
						+ "?currentPage=${ requestScope.pageInfo.pageNo + 1}";
			}
		}

		if (document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link
						+ "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}

		if (document.getElementById("searchStartPage")) {
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function() {
				location.href = searchLink
						+ "?currentPage=1&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}

		if (document.getElementById("searchPrevPage")) {
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function() {
				location.href = searchLink
						+ "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}

		if (document.getElementById("searchNextPage")) {
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function() {
				location.href = searchLink
						+ "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}

		if (document.getElementById("searchMaxPage")) {
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function() {
				location.href = searchLink
						+ "?currentPage=${ requestScope.pageInfo.maxPage }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}

		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}

		function searchPageButtonAction(text) {
			location.href = searchLink
					+ "?currentPage="
					+ text
					+ "&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
		}
	</script>
	<jsp:include page="../common/footer.jsp" />
</form>
</body>
</html>