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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    <div id="hdWrap">
        <div id="hdTop">
            <ul class="hutil">
                <li><a href="" title="즐겨찾기"><i class="fav">&nbsp;</i>즐겨찾기</a></li>
                <li><a href="" title="1600-0000"><i class="tel">&nbsp;</i>1600-3413</a></li>

              <%--   <li class="fr"><a href="${ pageContext.servletContext.contextPath }" title="고객센터" id="customer">고객센터</a></li> --%>
                <li class="fr"><a href=" ${ pageContext.servletContext.contextPath }/customer/list" title="고객센터" id="customer">고객센터</a></li>
                <li class="fr"><a href="/shop/confirm_login.html?type=myorder" title="주문조회">주문조회</a></li>
                <li class="fr"><a href="/shop/basket.html" title="장바구니">장바구니 <span><span id="user_basket_quantity"
                                class="user_basket_quantity">0</span></span></a></li>
                <li class="fr"><a href="${ pageContext.servletContext.contextPath }/mypage/main" title="고객센터" id="customer">마이페이지</a></li>
                <c:if test="${ empty sessionScope.loginMember }"> 
                <li class="fr"><input type="button" value="로그인/회원가입" id="mainLogin" class="login-btn btn-yg"></input></li>
            	</c:if>
            	<c:if test="${ ! empty sessionScope.loginMember }"> 
                <li class="fr"><input type="button" value="로그아웃" id="logout" class="login-btn btn-yg"></input></li>
            	</c:if>
            </ul>

            <h1><a href="${ pageContext.servletContext.contextPath }" title=""><img src="/mg/resources/image/Logo1(2).png" alt="" class="main_header_img_logo_1"></a></h1>

            <form action="/shop/shopbrand.html" method="post" name="search">
                <p>추천 검색어</p>
                <fieldset>
                    <input name="search" onkeydown="CheckKey_search();" placeholder="다이어트 식단">
                    <button type="button" onclick="search_submit()"></button>
                </fieldset>
            </form>
        </div>

        <div id="branding" class="qwrap">
            <ul class="gnb gnbLayer font_f">
                <li class="first"><a href="#none" title="슬림쿡 전체메뉴" id="allCategory" class="">전체 메뉴<span></span></a></li>
                <li class="flow_home"><a href="/html/mainm.html" title="슬림쿡 홈" class="mn">홈</a></li>
                <li><a href="" title="벌크업 식단" class="mn">벌크업 식단</a></li>
                <li><a href="" title="유지어터 식단" class="mn">유지어터 식단</a></li>
                <li><a href="" title="다이어트 식단" class="mn">다이어트 식단</a></li>
                <li><a href="" title="식단표" class="mn">식단표</a></li>
                <li><a href="" title="정기배송" class="mn">정기배송</a></li>
            </ul>
            <div id="allCategoryArea">
                <div class="allCategoryView">
                    <div class="categoryMenus">
                        <ul class="subcategory">
                            <li class="first">
                                <dl>
                                    <dt><a href="/shop/shopbrand.html?xcode=002&amp;type=O" title="슬림쿡 몸매관리 도시락">몸매관리
                                            도시락</a></dt>
                                    <dd class="imgInner"><a href="/shop/shopdetail.html?branduid=158"
                                            title="슬림쿡 몸매관리 도시락"><img
                                                src="http://slimcook.co.kr/shopimages/slimcook/002000000013.jpg"
                                                alt="슬림쿡 몸매관리 도시락" style="margin-bottom:8px;"></a></dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt><a href="/shop/shopbrand.html?xcode=004&amp;type=O" title="사이드 메뉴">몸매관리 간식</a>
                                    </dt>
                                    <dd style="margin-top:10px;"><a
                                            href="/shop/shopdetail.html?branduid=170&amp;xcode=004&amp;mcode=000&amp;scode=&amp;type=O&amp;sort=order&amp;cur_code=004&amp;GfDT=bmt6W14%3D"
                                            title="수제 샌드위치"><strong>BEST 1</strong> 수제 샌드위치</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1134070&amp;xcode=004&amp;mcode=000&amp;scode=&amp;type=O&amp;sort=manual&amp;cur_code=004&amp;GfDT=bmp3Ug%3D%3D"
                                            title="심쿵 닭가슴살"><strong>BEST 2</strong> 심쿵 닭가슴살</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1133993&amp;xcode=004&amp;mcode=000&amp;scode=&amp;type=O&amp;sort=manual&amp;cur_code=004&amp;GfDT=bmt5W14%3D"
                                            title="유기농 ABC주스"><strong>BEST 3</strong> 유기농 ABC주스</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1126886&amp;xcode=004&amp;mcode=000&amp;scode=&amp;type=O&amp;sort=manual&amp;cur_code=004&amp;GfDT=Z213U1U%3D"
                                            title="미숫가루선식"><strong>BEST 4</strong> 미숫가루선식</a></dd>
                                    <dd><a href="/shopdetail.html?branduid=1134202&amp;xcode=004&amp;mcode=000&amp;scode=&amp;type=O&amp;sort=manual&amp;cur_code=004&amp;GfDT=Zmt3UFg%3D"
                                            title="치즈볼 불닭"><strong>BEST 5</strong> 치즈볼 불닭</a></dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt><a href="/shop/shopbrand.html?xcode=007&amp;type=O" title="샐러드">샐러드</a></dt>
                                    <dd class="imgInner"><a href="/shop/shopbrand.html?xcode=007&amp;type=O"
                                            title="샐러드"><img
                                                src="http://www.slimcook.co.kr/shopimages/slimcook/0070000000062.jpg"
                                                alt="슬림쿡 샐러드" style="margin-bottom:8px;"></a></dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt><a href="/shop/shopbrand.html?xcode=023&amp;type=P" title="샐러드 정기배송">샐러드
                                            정기배송</a></dt>
                                    <dd style="margin-top:10px;"><a
                                            href="/shop/shopdetail.html?branduid=1134005&amp;xcode=023&amp;mcode=000&amp;scode=&amp;type=P&amp;sort=manual&amp;cur_code=023&amp;GfDT=bmt3UA%3D%3D"
                                            title="정기배송 닭가슴살 샐러드"><strong>NEW</strong> 닭가슴살 샐러드</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1134006&amp;xcode=023&amp;mcode=000&amp;scode=&amp;type=P&amp;sort=manual&amp;cur_code=023&amp;GfDT=bm18W1w%3D"
                                            title="정기배송 불고기 샐러드"><strong>NEW</strong> 불고기 샐러드</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1121458&amp;xcode=007&amp;mcode=000&amp;scode=&amp;type=O&amp;sort=manual&amp;cur_code=007&amp;GfDT=am13Ug%3D%3D"
                                            title="정기배송 1일 1식 샐러드"><strong>HOT</strong> 1일 1식 샐러드</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1121386&amp;xcode=023&amp;mcode=000&amp;scode=&amp;type=P&amp;sort=manual&amp;cur_code=023&amp;GfDT=bml4W1k%3D"
                                            title="정기배송 8종 샐러드"><strong>HOT</strong> 8종 샐러드</a></dd>
                                    <dd><a href="/shop/shopdetail.html?branduid=1130298&amp;xcode=023&amp;mcode=000&amp;scode=&amp;type=P&amp;sort=manual&amp;cur_code=023&amp;GfDT=bmx1W14%3D"
                                            title="정기배송 그린 샐러드"><strong>HOT</strong> 그린 샐러드</a></dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt><a href="/shop/shopbrand.html?xcode=022&amp;type=P" title="고단백 상품">고단백 상품</a>
                                    </dt>
                                    <dd class="imgInner"><a href="/shop/shopdetail.html?branduid=1120248"><img
                                                src="http://slimcook.co.kr/shopimages/slimcook/0020000000322.jpg"
                                                alt="슬림쿡 헬스 식단"></a></dd>
                                </dl>
                            </li>
                        </ul>
                        <h3><strong>community</strong> | 슬림쿡 커뮤니티 게시판!</h3>
                        <ul class="community">
                            <li class="first"><a href="/board/board.html?code=slimcook_board2" title="공지사항">공지사항</a>
                            </li>
                            <li><a href="/shop/faq.html" title="자주묻는질문">자주묻는질문</a></li>
                            <li><a href="/board/board.html?code=slimcook" title="질문과 답변">질문과 답변</a></li>
                            <li><a href="/board/board.html?code=slimcook_board1" title="상품 후기">상품 후기</a></li>
                            <li><a href="/shop/page.html?id=29" title="쿠폰존">쿠폰존</a></li>
                        </ul>

                        <h3><strong>슬림쿡 키친</strong> | 쿡모으기를 통해 다양한 혜택이 한 가득!</h3>
                        <ul class="community">
                            <li class="first"><a href="/shop/page.html?id=29" title="왕대박 복권 긁기">왕대박 복권 긁기</a></li>
                            <li><a href="/shop/page.html?id=29" title="출석 체크">출석 체크</a></li>
                            <li><a href="/shop/page.html?id=29" title="황금뱃지 찾기">황금뱃지 찾기</a></li>
                            <li><a href="/shop/page.html?id=29" title="선택 맛vs맛">선택 맛vs맛</a></li>
                            <li><a href="/shop/page.html?id=29" title="설문조사">설문조사</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- #branding // -->
        
        <script type="text/javascript">
         $(function(){
        	 $("#allCategory").click(function(e){
        		 e.preventDefault();
        		 
        		 var $t = $("#allCategory")
        		 
        		 $t.toggleClass("toggle");
        		 
        		 console.log($t);
        	 })
        	 
         })
        </script>
        
                <script type="text/javascript">
         $(function(){
        	 $("#allCategory").click(function(e){
        		 e.preventDefault();

        		 var $t = $("#allCategoryArea")
        		 
        		 $t.toggleClass("toggle");
        		 
        		 console.log($t);
        	 })
        	 
         })
        </script>
        
        <script type="text/javascript">
         $(function(){
        	 $("#allCategory").click(function(e){
        		 e.preventDefault();
			
        		 var $t = $(".onnn")
        		 
        		 $t.toggleClass("opacity-1");
        		 
        		 console.log($t);
        	 })
        	 
         })
	</script>

    </body>
</html>