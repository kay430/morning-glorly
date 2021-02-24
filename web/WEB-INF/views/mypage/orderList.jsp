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
	href="/mg/resources/css/mypage/orderList.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	
	
      <br>
     <div id="page-wrapper">
      <!-- 사이드바 -->
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
            <a href="#"><h3>MyPage</h3></a>
        </li>
          <li><a href="${ pageContext.servletContext.contextPath }/mypage/orderList">주문 내역</a></li>
          <li><a href="${ pageContext.servletContext.contextPath }/mypage/resentlyViewed">최근 본 상품</a></li>
          <li><a href="${ pageContext.servletContext.contextPath }/mypage/wishList">관심 상품</a></li>
          <li><a href="#">회원정보변경</a></li>
          <li><a href="${ pageContext.servletContext.contextPath }/mypage/quitMember">회원탈퇴신청</a></li>
        </ul>
      </div>
      <!-- /사이드바 -->
    <div class="col-sm-8">
      <h2>주문내역</h2>
      <hr>
      
      <div class="fakeimg">
          </aside>
      <br>
      <h5>최근주문정보</h5>
      <hr>
      <table align="center" id="listArea">
        <tr>  
            <th width="100px">번호</th>
            <th width="200px">주문일자</th>
            <th width="200px">상품명</th>
            <th width="100px">결제금액</th>
            <th width="100px">주문상세</th>
            <th width="100px">배송현황</th>
        </tr>
        </table>
            <!--여기서부터 주문거래 내역 나오게하는 테이블-->
            <table align="center" id="listArea">
                <tr>
                    <td colspan="4" class="t1">주문내역이 없습니다</td>
                </tr>
            <hr>
        </table>
        <hr>
        </div>
    </div>
    </div>
   

<br>
<br>
<br>
<br>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>