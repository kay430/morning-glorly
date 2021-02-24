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
	href="/mg/resources/css/mypage/mypage.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	
	 <br>
       <div id="page-wrapper">
        <!-- 사이드바 -->
        <div id="sidebar-wrapper">
          <ul class="sidebar-nav">
              <li class="sidebar-brand">
              <a href="#"> <h3>MyPage</h3></a>
          </li>
            <li><a href="#">주문 내역</a></li>
            <li><a href="#">최근 본 상품</a></li>
            <li><a href="#">관심 상품</a></li>
            <li><a href="${ pageContext.servletContext.contextPath }/change/memberInfo">회원정보변경</a></li>
            <li><a href="${ pageContext.servletContext.contextPath }/mypage/quitMember">회원탈퇴신청</a></li>
          </ul>
        </div>
        <!-- /사이드바 -->
      <h2>마이페이지</h2>
      <hr>
      
      <div class="fakeimg">
          <aside class="area1">
           <input value="${ sessionScope.loginMember.name }님 반가워요" readonly class="abc" ><br><br>
            전화 :   <input value="${ sessionScope.loginMember.phone }" readonly class="abc"><br>
            이메일: <input value="${ sessionScope.loginMember.email }" readonly class="abc"><br>
            주소 :  <input  value="${ sessionScope.loginMember.address }"  size="40" readonly class="abc"><br>
          </aside>
          <aside class="area2">
            <h4 class="h">총 주문금액 :</h4>
            <br><br>
            적립금 : 
          </aside>
      </div>
      <br>
      <div>
      <h5>최근주문정보
      
        <input type="button" value="더보기" class="seeMoreBtn"></h5>

      <hr>
      <table align="center" id="listArea">
        <tr>
            <th width="300px">주문일자</th>
            <th width="200px">상품명</th>
            <th width="100px">결제금액</th>
            <th width="100px">주문상세</th>
        </tr>
        
        </table>
        <hr>
        <table align="center" id="listArea">
            <tr>
                <td colspan="4" class="t1">주문내역이 없습니다</td>
              
            </tr>
            </table>
        <hr>
        <h5>최근등록게시글
      
          <input type="button" value="더보기" class="seeMoreBtn"></h5>
        <hr>
        <table align="center" id="listArea">
          <tr>
              <th width="400px">등록일자</th>
              <th width="200px">제목</th>
              <th width="100px">게시판</th>
              
          </tr>
          
          </table>
          <hr>
          <table align="center" id="listArea">
              <tr>
                  <td colspan="4" class="t1">주문내역이 없습니다</td>
                
              </tr>
              </table>
          <hr>
          <h5>관심상품정보
            <input type="button" value="더보기" class="seeMoreBtn"></h5>
          <hr>
          <table align="center" id="listArea">
            <tr>
                <th width="300px"></th>
                <th width="200px"></th>
                <th width="100px"></th>
                <th width="100px"></th>
            </tr>
            
            </table>
            <hr>
            <table align="center" id="listArea">
                <tr>
                    <td colspan="4" class="t1">관심상품이 없습니다</td>
                  
                </tr>
                </table>
            <hr>
      </div>
       </div>
       
	<jsp:include page="../common/footer.jsp" />
</body>
</html>