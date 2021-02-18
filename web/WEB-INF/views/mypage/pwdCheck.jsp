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
	href="/mg/resources/css/mymapge/pwdcheck.css">
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
        <li><a href="#">회원정보변경</a></li>
        <li><a href="#">회원탈퇴신청</a></li>
      </ul>
    </div>
    <!-- /사이드바 -->
    <br>    
    <div class="col-sm-8">
      <h2>회원정보 변경</h2>
      <hr>
      <div class="img_area">
        <img src="/mg/resources/image/member/pwdCheck3.png">
      </div>
      
      <fieldset>
          <br><br>
        <legend></legend>
        <div class="frm1">
                
                아이디 : <input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요">
        </div>
        <div class="frm">       
                <br><br><br>
                비밀번호 : <input type="password" id="user_password" name="user_password" class="txt-input" placeholder="비밀번호를 입력해주세요">
            
        </div><!-- .frm -->
        <div class="btns">
            <a href="javascript:pw_check();" class="btn_default btn_color_point">확인</a>
            &nbsp;&nbsp;
            <a href="/index.html" class="btn_default btn_color">취소</a>
        </div><!-- .btns -->
      
      </fieldset>
    
      	
    </div>
   </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>