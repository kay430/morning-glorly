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
	href="/mg/resources/css/customer_main.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/idFind.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/mypage/wishList.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />
<br>

      <br>
     <div id="page-wrapper">
      <!-- 사이드바 -->
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
            <a href="#"><h3>MyPage</h3></a>
        </li>
          <li><a href="#">주문 내역</a></li>
          <li><a href="#">최근 본 상품</a></li>
          <li><a href="#">관심 상품</a></li>
          <li><a href="#">회원정보변경</a></li>
          <li><a href="#">회원탈퇴신청</a></li>
        </ul>
      </div>
      <!-- /사이드바 -->
      <h2><송남규>님의 위시리스트~</h2>
      <hr>
      <table align="center" id="listArea">
        <tr>  
            <th width="10px"><input type="checkbox" name="checkbox" class="chk1"></th>
            <th width="150px">사진</th>
            <th width="150px">상품명</th>
            <th width="70px">수량</th>
            <th width="70px">재고</th>
            <th width="70px">적립금</th>
            <th width="70px">가격</th>
            <th width="70px">장바구니</th>
        </tr>
        <c:forEach var="" items="${ requestScope.noticeList }">
          <tr>
            <td><c:out value="${ notice.no }"/></td>
            <td><c:out value="${ notice.title }"/></td>
            <td><c:out value="${ notice.writer.nickname }"/></td>
            <td><c:out value="${ notice.count }"/></td>
            <td><c:out value="${ notice.createdDate }"/></td>
          </tr>
          </c:forEach>
        </table>
            <!--여기서부터 관심상품목록 나오게하는 테이블-->
            <div class="wishList-List">
            <table align="center" id="listArea">
                <tr>
                    <td class="t1">보관하신 상품내역이 없습니다</td>
                </tr>
            <hr>
        </table>
      </div>
        <hr>
        <br><br>
        <div class= checkForDeleteButton>
                <input type="button" value="선택삭제" class="del">
                <br><br><br><br><br>
        </div>
        </div>
		<jsp:include page="../common/footer.jsp" />
</body>
</html>