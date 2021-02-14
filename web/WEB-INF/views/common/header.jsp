<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/mg/resources/js/event.js"></script>
</head>
<body>

    <header>
        <div class="header_area">
            <div class="header_menu_area">
                <div class="row">
                    <div class="header_text1" style="height: 30px;">
                        <input type="button" class="btn btn-yg" value="회원가입" id="regist" style="height: 30px; line-height: 10px; background-color: white; color: black;">
                    </div>
                    <div class="header_menu_list">
                        <div class="row">
                            <a href="#" class="menu_list" id="logout">
                                로그아웃
                            </a>                        
                            <a href="#" class="menu_list">
                                택배조회
                            </a>
                            <a href="#" class="menu_list">
                                고객센터
                            </a>
                            <a href="#" class="menu_list">
                                주문조회
                            </a>
                            <a href="#" class="menu_list">
                                장바구니
                            </a>
                            <a href="#" class="menu_list">
                                마이페이지
                            </a>
                            <a href="#" class="menu_list" id="login">
                                로그인
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="logo_area">
                <div class="row">
                    <div class="logo_img">
                        <a href="${ pageContext.servletContext.contextPath }">
                            <img class="logo_detail" src="/mg/resources/image/Logo1.png">
                        </a>
                    </div>
                </div>
            </div>
            <div class="header_line"></div>

            <div class="menubar_area">
                <div class="menubar_list">
                    <div class="row">
                        <div class="menubar_btn">
                            <i class="fas fa-bars"></i>
                        </div>
                        <a href="#" class="menubar_btn2">
                            정기배송
                        </a>
                        <a href="#" class="menubar_btn2">
                            식단표
                        </a>
                        <a href="#" class="menubar_btn2">
                            다이어트식단
                        </a>
                        <a href="#" class="menubar_btn2">
                            유지어터식단
                        </a>
                        <a href="#" class="menubar_btn2">
                            벌크업식단
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>

</body>
</html>