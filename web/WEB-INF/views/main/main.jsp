<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Morning Glory</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/mg/resources/css/MorningGloryMain.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

</head>
<body>

    <div id="hdWrap">
        <div id="hdTop">
            <ul class="hutil">
                <li><a href="" title="즐겨찾기"><i class="fav">&nbsp;</i>즐겨찾기</a></li>
                <li><a href="" title="1600-3413"><i class="tel">&nbsp;</i>1600-3413</a></li>

                <li class="fr"><a href="" title="고객센터">고객센터</a></li>
                <li class="fr"><a href="/shop/confirm_login.html?type=myorder" title="주문조회">주문조회</a></li>
                <li class="fr"><a href="/shop/basket.html" title="장바구니">장바구니 <span><span id="user_basket_quantity"
                                class="user_basket_quantity">0</span></span></a></li>
                <li class="fr"><a href="/shop/member.html?type=mynewmain" title="마이페이지">마이페이지</a></li>
                <li class="fr"><a href="" title="로그인">로그인/회원가입</a></li>
            </ul>

            <h1><a href="" title=""><img src="img/Logo1 (2).png" alt="" class="main_header_img_logo_1"></a></h1>

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
                    <h2>
                        <a href="/shop/shopbrand.html?xcode=007&amp;type=O">
                            <img src="http://cdn010.negagea.net/slimcook/slim/slimcook/img1911/allcatebanner_01.jpg"
                                alt="샐러드 정기배송 새벽배송">
                        </a>
                    </h2>
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


        <div id="contentWrapper">

            <div class="new_menu">
                <h3 class="w360">다이어트 도시락<strong> BEST</strong></h3>
                <ul>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                가격
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                가격
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li class="last">
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                가격
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                </ul>


                <h3 class="w210">유지어터 도시락<strong> BEST</strong></h3>
                <ul>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                <span class="s_price_consume">원가</span>
                                <span class="s_discount_percent">(할인율)</span> 
                                최종가
                            </p>
                            <p class="s_name">[할인율] 메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                <span class="s_price_consume">원가</span>
                                <span class="s_discount_percent">(할인율)</span> 
                                최종가
                            </p>
                            <p class="s_name">[정기배송] 메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                <span class="s_price_consume">원가</span>
                                <span class="s_discount_percent">(할인율)</span>
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li class="last">
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                <span class="s_price_consume">원가</span>
                                <span class="s_discount_percent">(할인율)</span>
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                </ul>



                <div class="clobox">
                    <h3>지금 가장 <span>🔥</span><strong>HOT</strong><span>🔥</span> 해요!</h3>
                    <div class="item_best1">
                        <a
                            href="">
                            <p><img src=""></p>
                            <p>
                                <span>🍝메뉴명</span>
                                <span>💝간단한 설명 💝</span>
                                <span>10,000원</span>
                                <span>10<i>%</i></span>
                                <span>9,000<i>원</i></span>
                                <span>지금바로 구매하기!</span>
                            </p>
                        </a>
                    </div>
                </div>


                <!--<h3 class="w330">몸매관리 간식<strong> BEST</strong></h3>-->
                <ul>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                <span class="s_price_consume">원가</span>
                                <span class="s_discount_percent">(할인율)</span> 
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                <span class="s_price_consume">원가</span>
                                <span class="s_discount_percent">(할인율)</span> 
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                    <li class="last">
                        <a href="" title="">
                            <img class="MS_prod_img_s" src="" alt="">
                            <p class="s_price">
                                최종가
                            </p>
                            <p class="s_name">메뉴명</p>
                            <p class="s_subname">간단한 설명</p>
                        </a>
                    </li>
                </ul>
            </div>



            <div class="bestthree_area">
                <div class="box">
                    <p>ONLY ONE BRAND <strong>오직 슬림쿡에서만!</strong></p>
                    <ul>
                        <li>
                            <a href="" title="">
                                <img src="" alt="">
                                <dl>
                                    <dt>저탄수 다이어트 식단!</dt>
                                    <dd>간단한 설명</dd>
                                </dl>
                            </a>
                        </li>
                        <li>
                            <a href="" title="">
                                <img src="" alt="">
                                <dl>
                                    <dt>단백질 벌크업 식단!</dt>
                                    <dd>간단한 설명</dd>
                                </dl>
                            </a>
                        </li>
                        <li>
                            <a href="" title="">
                                <img src="" alt="">
                                <dl>
                                    <dt>유지어터 식단!</dt>
                                    <dd>간단한 설명</dd>
                                </dl>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>


            <div class="recmd_menu">
                <h2>당신을 위한 <strong> 도시락 정기 배송!</strong></h2>
                <ul>
                    <li>
                        <a href=""
                            title="[정기배송] 샐러드 4주 배송 [1일1식]">
                            <p class="s_addtext">#[1주] 벌크업&nbsp;</p>
                            <div class="overli">
                                <img class="MS_prod_img_s" src="" alt="">
                                <p class="s_price">
                                    <span class="s_price_consume">원가</span>
                                    <span class="s_discount_percent">(할인율)</span>
                                    최종가
                                </p>
                                <p class="s_name">[정기배송] 메뉴명</p>
                                <p class="s_subname">간단한설명</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <p class="s_addtext">#[1주] 유지어터&nbsp;</p>
                            <div class="overli">
                                <img class="MS_prod_img_s" src="" alt="">
                                <p class="s_price">
                                    <span class="s_price_consume">원가</span>
                                    <span class="s_discount_percent">(할인율)</span>
                                    최종가                   
                                </p>
                                <p class="s_name">[정기배송] 메뉴명</p>
                                <p class="s_subname">간단한설명</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <p class="s_addtext"> #[1주] 다이어트&nbsp;</p>
                            <div class="overli">
                                <img class="MS_prod_img_s" src="" alt="">
                                <p class="s_price">
                                    <span class="s_price_consume">원가</span>
                                    <span class="s_discount_percent">(할인율)</span>
                                    최종가
                                </p>
                                <p class="s_name">[정기배송] 메뉴명</p>
                                <p class="s_subname">간단한 설명</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" title="">
                            <p class="s_addtext">#다양한 메뉴&nbsp;</p>
                            <div class="overli">
                                <img class="MS_prod_img_s" src="" alt="">
                                <p class="s_price">
                                    <span class="s_price_consume">원가</span>
                                    <span class="s_discount_percent">(할인율)</span>
                                    최종가
                                </p>
                                <p class="s_name">[정기배송] 메뉴명</p>
                                <p class="s_subname">간단한 설명</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>


            <div class="maintab_menu">
                <h2>BEST <strong>MD PICK!</strong></h2>
                <div class="maintab_menu_tab">
                    <input type="radio" name="tab" id="mttab1" checked=""><label for="mttab1" title="샐러드"><i
                            class="maintab_menu_tab1"></i>샐러드</label>
                    <input type="radio" name="tab" id="mttab2"><label for="mttab2" title="샐러드 정기배송"><i
                            class="maintab_menu_tab2"></i>샐러드 정기배송</label>
                    <input type="radio" name="tab" id="mttab3"><label for="mttab3" title="식단관리 도시락"><i
                            class="maintab_menu_tab3"></i>식단관리 도시락</label>
                    <input type="radio" name="tab" id="mttab4"><label for="mttab4" title="간편 간식"><i
                            class="maintab_menu_tab4"></i>간편 간식</label>
                    <input type="radio" name="tab" id="mttab5"><label for="mttab5" title="건강즙"><i
                            class="maintab_menu_tab5"></i>건강즙</label>
                    <input type="radio" name="tab" id="mttab6"><label for="mttab6" title="곡물 가루"><i
                            class="maintab_menu_tab6"></i>곡물 가루</label>
                    <input type="radio" name="tab" id="mttab7"><label for="mttab7" title="건강보조식품"><i
                            class="maintab_menu_tab7"></i>건강보조식품</label>

                    <div id="tabcont1">
                        <ul class="tab_product">
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1121385&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=3&amp;GfDT=a2x3UQ%3D%3D"
                                    title="[12% 할인] 샐러드 8종 맛보기">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000233.jpg?1609808926"
                                        alt="[12% 할인] 샐러드 8종 맛보기">
                                    <p class="s_price">
                                        <span class="s_price_consume">55,000원</span><span
                                            class="s_discount_percent">(12%)</span> 48,600원
                                    </p>
                                    <p class="s_name">[12% 할인] 샐러드 8종 맛보기</p>
                                    <p class="s_subname">토핑이 듬뿍 가미 된 여덟가지 샐러드의 품격을 느껴보세요!(그린샐러드제외)</p>
                                    <p class="s_review_count">리뷰<strong>♥390</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1121458&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=3&amp;GfDT=bm9%2BW10%3D"
                                    title="[정기배송] 샐러드 4주 배송 [1일1식]">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000163.jpg?1609808993"
                                        alt="[정기배송] 샐러드 4주 배송 [1일1식]">
                                    <p class="s_price">
                                        <span class="s_price_consume">142,000원</span><span
                                            class="s_discount_percent">(23%)</span> 109,000원
                                    </p>
                                    <p class="s_name">[정기배송] 샐러드 4주 배송 [1일1식]</p>
                                    <p class="s_subname">한 달 동안 매주 1주분(1일1식)의 샐러드를 정기적으로 배송해드리는 상품! 26% 할인 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥785</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1121384&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=3&amp;GfDT=bmx%2FW14%3D"
                                    title="샐러드 골라담기">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000063.jpg?1589955532"
                                        alt="샐러드 골라담기">
                                    <p class="s_price">
                                        <span class="s_price_consume">4,000원</span><span
                                            class="s_discount_percent">(33%)</span> 2,700원
                                    </p>
                                    <p class="s_name">샐러드 골라담기</p>
                                    <p class="s_subname">아홉가지의 다양한 샐러드를 내 입맛에 원하는대로 쏙쏙~ 골라서 구매하세요!</p>
                                    <p class="s_review_count">리뷰<strong>♥883</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1120911&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=3&amp;GfDT=bWx3Ug%3D%3D"
                                    title="그린 샐러드(드레싱랜덤)">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000153.jpg?1589522659"
                                        alt="그린 샐러드(드레싱랜덤)">
                                    <p class="s_price">
                                        <span class="s_price_consume">4,000원</span><span
                                            class="s_discount_percent">(33%)</span> 2,700원
                                    </p>
                                    <p class="s_name">그린 샐러드(드레싱랜덤)</p>
                                    <p class="s_subname">신선함이 담겨있는 다양하고 아삭한 채소들! 가장 베이직하면서도 완벽한 맛! [드레싱 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥131</strong></p>
                                </a>
                            </li>
                        </ul>
                        <ul class="tab_product">
                        </ul>
                    </div>
                    <div id="tabcont2">
                        <ul class="tab_product">
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1121458&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=2&amp;GfDT=bm50W1w%3D"
                                    title="[정기배송] 샐러드 4주 배송 [1일1식]">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000163.jpg?1609808993"
                                        alt="[정기배송] 샐러드 4주 배송 [1일1식]">
                                    <p class="s_price">
                                        <span class="s_price_consume">142,000원</span><span
                                            class="s_discount_percent">(23%)</span> 109,000원
                                    </p>
                                    <p class="s_name">[정기배송] 샐러드 4주 배송 [1일1식]</p>
                                    <p class="s_subname">한 달 동안 매주 1주분(1일1식)의 샐러드를 정기적으로 배송해드리는 상품! 26% 할인 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥785</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1121468&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=2&amp;GfDT=bWp3UA%3D%3D"
                                    title="[정기배송] 샐러드  4주 배송 [1일2식]">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000173.jpg?1609809011"
                                        alt="[정기배송] 샐러드  4주 배송 [1일2식]">
                                    <p class="s_price">
                                        <span class="s_price_consume">272,000원</span><span
                                            class="s_discount_percent">(24%)</span> 206,000원
                                    </p>
                                    <p class="s_name">[정기배송] 샐러드 4주 배송 [1일2식]</p>
                                    <p class="s_subname">힌 달 동안 매주 1주분(1일2식)의 샐러드를 정기적으로 배송해드리는 상품! 27% 할인 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥219</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1121386&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=2&amp;GfDT=aGl3Uw%3D%3D"
                                    title="[정기배송] 샐러드 4주 배송 [8종]">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000043.jpg?1609809139"
                                        alt="[정기배송] 샐러드 4주 배송 [8종]">
                                    <p class="s_price">
                                        <span class="s_price_consume">220,000원</span><span
                                            class="s_discount_percent">(24%)</span> 167,200원
                                    </p>
                                    <p class="s_name">[정기배송] 샐러드 4주 배송 [8종]</p>
                                    <p class="s_subname">한 달 동안 매주 1주분(8종)의 샐러드를 정기적으로 배송해드리는 상품! 27% 할인 된 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥171</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1130298&amp;xcode=007&amp;mcode=000&amp;scode=&amp;special=2&amp;GfDT=bm14W18%3D"
                                    title="[정기배송]그린 샐러드">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0070000000213.jpg?1595993945"
                                        alt="[정기배송]그린 샐러드">
                                    <p class="s_price">
                                        <span class="s_price_consume">92,000원</span><span
                                            class="s_discount_percent">(28%)</span> 66,000원
                                    </p>
                                    <p class="s_name">[정기배송]그린 샐러드</p>
                                    <p class="s_subname">신선함이 가득한 다양한 야채를 정기배송으로 느낄 수있는 베이직 샐러드! (드레싱랜 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥155</strong></p>
                                </a>
                            </li>
                        </ul>
                        <ul class="tab_product">
                        </ul>
                    </div>
                    <div id="tabcont3">
                        <ul class="tab_product">
                            <li>
                                <a href="/shop/shopdetail.html?branduid=173&amp;xcode=002&amp;mcode=000&amp;scode=&amp;special=1&amp;GfDT=Z293UQ%3D%3D"
                                    title="하루 약 900Kcal 프로그램">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0020000000123.jpg?1587964793"
                                        alt="하루 약 900Kcal 프로그램">
                                    <p class="s_price">
                                        118,000원
                                    </p>
                                    <p class="s_name">하루 약 900Kcal 프로그램</p>
                                    <p class="s_subname">일주일에 다섯 번 집 앞으로 새벽 배송! 슬림쿡 최다 판매 식단조절형 프로그램[1주분 ..</p>
                                    <p class="s_review_count">리뷰<strong>♥461</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=176&amp;xcode=002&amp;mcode=000&amp;scode=&amp;special=1&amp;GfDT=aGl3UA%3D%3D"
                                    title="간헐적 단식 A(라이스+샌드위치) 프로그램">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0020000000113.jpg?1587964830"
                                        alt="간헐적 단식 A(라이스+샌드위치) 프로그램">
                                    <p class="s_price">
                                        96,000원
                                    </p>
                                    <p class="s_name">간헐적 단식 A(라이스+샌드위치) 프로그램</p>
                                    <p class="s_subname">SBS 스페셜 방송에 방영 된 화제의 식단! 식단조절형 프로그램[1주분(총 12식)]</p>
                                    <p class="s_review_count">리뷰<strong>♥303</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=158&amp;xcode=002&amp;mcode=000&amp;scode=&amp;special=1&amp;GfDT=bmt9W14%3D"
                                    title="간헐적 단식 B(라이스+샐러드) 프로그램">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0020000000133.jpg?1587964684"
                                        alt="간헐적 단식 B(라이스+샐러드) 프로그램">
                                    <p class="s_price">
                                        96,000원
                                    </p>
                                    <p class="s_name">간헐적 단식 B(라이스+샐러드) 프로그램</p>
                                    <p class="s_subname">SBS 스페셜 방송에 방영 된 화제의 식단! 식단조절형 프로그램[1주분(총 12식)]</p>
                                    <p class="s_review_count">리뷰<strong>♥146</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=159&amp;xcode=002&amp;mcode=000&amp;scode=&amp;special=1&amp;GfDT=aWd3Ug%3D%3D"
                                    title="덴마크 프로그램">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0020000000353.jpg?1587964614"
                                        alt="덴마크 프로그램">
                                    <p class="s_price">
                                        110,000원
                                    </p>
                                    <p class="s_name">덴마크 프로그램</p>
                                    <p class="s_subname">훈제란,채소,토스트 자몽으로 구성된 단기관리 식단! 덴마크 프로그램[1주분(총21식)]</p>
                                    <p class="s_review_count">리뷰<strong>♥339</strong></p>
                                </a>
                            </li>
                        </ul>
                        <ul class="tab_product">
                        </ul>
                    </div>
                    <div id="tabcont4">
                        <ul class="tab_product">
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1134070&amp;xcode=004&amp;mcode=000&amp;scode=&amp;special=5&amp;GfDT=ZmZ3UQ%3D%3D"
                                    title="심쿵닭가슴살 99g 10팩">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0040000000523.jpg?1598601102"
                                        alt="심쿵닭가슴살 99g 10팩">
                                    <p class="s_price">
                                        <span class="s_price_consume">26,000원</span><span
                                            class="s_discount_percent">(23%)</span> 20,100원
                                    </p>
                                    <p class="s_name">심쿵닭가슴살 99g 10팩</p>
                                    <p class="s_subname">촉촉함과 부드러움 쫄깃함의 끝판왕! 슬림쿡에서 만나보세요!</p>
                                    <p class="s_review_count">리뷰<strong>♥46</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=170&amp;xcode=004&amp;mcode=000&amp;scode=&amp;special=5&amp;GfDT=aW13UA%3D%3D"
                                    title="수제 샌드위치">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0040000000023.jpg?1587966698"
                                        alt="수제 샌드위치">
                                    <p class="s_price">
                                        24,000원
                                    </p>
                                    <p class="s_name">수제 샌드위치</p>
                                    <p class="s_subname">간단하게! 깔끔하게! 맛있게! 수제 샌드위치 4세트~ 출출할 때 간편하게 드셔보세요!</p>
                                    <p class="s_review_count">리뷰<strong>♥55</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1133993&amp;xcode=004&amp;mcode=000&amp;scode=&amp;special=5&amp;GfDT=Zm93Uw%3D%3D"
                                    title="유기농 ABC 주스 100ml">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0040000000513.jpg?1595839835"
                                        alt="유기농 ABC 주스 100ml">
                                    <p class="s_price">
                                        <span class="s_price_consume">19,800원</span><span
                                            class="s_discount_percent">(16%)</span> 16,700원
                                    </p>
                                    <p class="s_name">메뉴명</p>
                                    <p class="s_subname">대표 컬러푸드! 사과, 비트, 당근의 황금비율을 유기농 주스로 만나보세요!</p>
                                    <p class="s_review_count">리뷰<strong>♥41</strong></p>
                                </a>
                            </li>
                            <li>
                                <a href="/shop/shopdetail.html?branduid=1126886&amp;xcode=004&amp;mcode=000&amp;scode=&amp;special=5&amp;GfDT=bm56W18%3D"
                                    title="매일미숫가루선식">
                                    <img class="MS_prod_img_s" src="/shopimages/slimcook/0040000000353.jpg?1587968194"
                                        alt="매일미숫가루선식">
                                    <p class="s_price">
                                        9,800원
                                    </p>
                                    <p class="s_name">메뉴명</p>
                                    <p class="s_subname">가벼운 아침 미숫가루 한 잔으로 든든하고, 간편하게 곡물의 영양을 섭취해보세요.</p>
                                    <p class="s_review_count">리뷰<strong>♥22</strong></p>
                                </a>
                            </li>
                        </ul>
                        <ul class="tab_product">
                        </ul>
                    </div>
                    <div id="tabcont5">
                        5
                    </div>
                    <div id="tabcont6">
                        6
                    </div>
                    <div id="tabcont7">
                        7
                    </div>
                </div>
            </div>



            <div class="sitebestreview_area">
                <div class="box">
                    <h2>베스트 상품</h2>
                    <ul>
                        <li>
                            <a href="메뉴 상세페이지로" title="메뉴명">
                                <img src=""  alt="">
                                <p class="s_sub">메뉴이름</p>
                                <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="메뉴명">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="간헐적 단식 B(라이스+샐러드) 프로그램">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="하루 약 1200Kcal 프로그램">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="덴마크 프로그램">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="헬스 식단 프로그램">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="샐러드 골라담기">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="[정기배송] 샐러드 4주 배송 [1일1식]">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="[정기배송] 샐러드 4주 배송 [1일2식]">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                        <li>
                            <a href="" title="샐러드 8종 맛보기">
                                <img src="" alt="">
                                    <p class="s_sub">메뉴이름</p>
                                    <p class="s_review">간단한 설명</p>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="sitebestreviewimg_area">
                    <a href="" title="이벤트">
                        <img src="http://cdn010.negagea.net/slimcook/slim/slimcook/img1911/sitebestreview_banner_01.jpg" alt="">
                    </a>
                </div>
            </div>
        </div>


        <div id="footer_info">
            <div class="site_box">
                <div class="site_left">
                    <h5>
                        <a href="/" title="하단 로고">
                            <img src="img/Logo1 (1).png" alt="">
                        </a>
                    </h5>
                </div>
                <div class="site_right">
                    <ul>
                        <li><a href="" title="회사소개">회사소개</a></li>
                        <li><a href="" title="개인정보취급방침안내">개인정보취급방침안내</a></li>
                        <li><a href="" title="이용약관">이용약관</a></li>
                        <li><a href="" title="이용안내">이용안내</a></li>
                        <li><a href="" title="고객센터">고객센터</a></li>
                        <li><a href="" title="입점문의">입점 문의</a></li>
                    </ul>
                    <span>상호: 주식회사 옳은</span>
                    <span>대표: 고재현</span>
                    <span>주소: 광주 광산구 하남동 821번지 5층</span>
                    <span>사업자 등록번호: 318-87-00182 
                        <a href="" target="_blank" class="btn_small btn_color1" style="margin-top:-5px;" title="사업자등록번호 조회하기">
                            사업자등록번호
                        </a>
                    </span>
                    <span>전화번호: 1600-3413</span>
                    <span>건강기능식품영업신고 : 제 2017-0228115호(광산구청)</span>
                    <span>개인정보관리책임자: 김화성 (<a href="">youvegot89@naver.com</a>)</span><br>
                    <span>E-mail: <a href="#none">youvegot89@naver.com</a></span>
                    <span>통신판매업신고: 제 2015-광주광산-0370호</span>
                    <span>Copyrightⓒ 2014 슬림쿡 - 단기관리 식단프로그램. All rights Reserved.</span>
                </div>
            </div>
        </div>
</body>

</html>