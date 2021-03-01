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
	href="/mg/resources/css/mymapge/changeMemberInfo.css">
<link href="/mg/resources/admin/jihunh.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

	<jsp:include page="../common/header.jsp" />


	   <div id="contentWrapper">
      <div id="contentWrap">
         <div id="content">

            <div id="order">
               <h2>주문서 작성</h2>

               <div class="page-body">

                  <form name="form1" id="order_form" action="/shop/orderin.html"
                     method="post">
                     <input type="hidden" name="ok" value="N"> <input
                        type="hidden" name="paymethod" value=""> <input
                        type="hidden" name="paydata1" value=""> <input
                        type="hidden" name="paydata2" value=""> <input
                        type="hidden" name="address" value="" id="address"> <input
                        type="hidden" name="etcaddress" value=""> <input
                        type="hidden" name="virresno1" value=""> <input
                        type="hidden" name="virresno2" value=""> <input
                        type="hidden" name="resno" value=""> <input
                        type="hidden" name="msecure_key"
                        value="8F1wtpoxVL2LAAWdwN95aw=="> <input type="hidden"
                        name="add_msecure_key" value=""> <input type="hidden"
                        name="id_info" value=""> <input type="hidden"
                        name="id_name" value=""> <input type="hidden"
                        name="sslid" value="slimcook"> <input type="hidden"
                        name="sslip" value="www.slimcook.co.kr"> <input
                        type="hidden" name="tempid"
                        value="01f8eb55b54bee855e1ae8f8940d60cf"> <input
                        type="hidden" name="id" value="kim113"> <input
                        type="hidden" name="use_freedeli_coupon" value="N" /> <input
                        type="hidden" name="banktown_id" value=""> <input
                        type="hidden" name="card_brand" value="하루 약 900Kcal 프로그램">
                     <input type="hidden" name="card_brand_npay"
                        value="하루 약 900Kcal 프로그램"> <input type="hidden"
                        name="total_amount" value="1"> <input type="hidden"
                        name="banktownprice" value="118000"> <input
                        type="hidden" name="cardprice" value="118000"> <input
                        type="hidden" name="cur_reserve" value="3000"> <input
                        type="hidden" name="reserveonlyprice" value=""> <input
                        type="hidden" name="ktprice" value="118000"
                        origin-data-value="118000"> <input type="hidden"
                        name="kt_id" value=""> <input type="hidden"
                        name="deli_product_price" value="0"> <input
                        type="hidden" name="bankonly" value="N"> <input
                        type="hidden" name="quickdelihour" value=""> <input
                        type="hidden" name="quickdelimethod" value=""> <input
                        type="hidden" name="quickdelipricetype" value="C"> <input
                        type="hidden" name="shoplang" value=""> <input
                        type="hidden" name="pay_path" value="PC"> <input
                        type="hidden" name="tm1post1" value="" id=tm1post1> <input
                        type="hidden" name="tm1post2" value="" id=tm1post2> <input
                        type="hidden" name="tm1address1" value="" id=tm1address1>
                     <input type="hidden" name="tm1address2" value="" id=tm1address2>
                     <input type="hidden" name="tm2post1" value="" id=tm2post1>
                     <input type="hidden" name="tm2post2" value="" id=tm2post2>
                     <input type="hidden" name="tm2address1" value="" id=tm2address1>
                     <input type="hidden" name="tm2address2" value="" id=tm2address2>
                     <input type="hidden" name="deli_reserve" value="3000"> <input
                        type="hidden" name="deli_emoney" value=""> <input
                        type="hidden" name="order_deli_price" value="0"> <input
                        type="hidden" name="discount_use_not_reserve" value="0">
                     <input type="hidden" name="mobile_type" value="NONE">
                     <!--핸드폰 결제 타입  (DA : 다날, MO : 모빌리언스)-->
                     <input type="hidden" name="group_deli_type" id="group_deli_type"
                        value="">
                     <!--회원등급 배송료처리-->
                     <input type="hidden" name="mk_ems_type" id="mk_ems_type" value="">
                     <!--해외 배송료처리-->
                     <input type="hidden" name="simplepay_type" id="simplepay_type"
                        value="">
                     <!-- 간편결제 -->
                     <input type="hidden" name="order_paytype" id="order_paytype"
                        value="PAY">
                     <!-- 스마트주문서(주문서리뉴얼) 결제팝업 버전 -->
                     <input type="hidden" name="add_deli_price" id="add_deli_price"
                        value="0">
                     <!-- 스마트주문서(주문서리뉴얼) 추가배송비 -->
                     <input type="hidden" name="add_deli_price_temp"
                        id="add_deli_price_temp" value="0">
                     <!-- 스마트주문서(주문서리뉴얼) 추가배송비 -->
                     <input type="hidden" name="tba_name" id="tba_name" />
                     <!-- 증빙신청 세금계산서 신청자명 -->
                     <input type="hidden" name="tba_phone" id="tba_phone" />
                     <!-- 증빙신청 세금계산서 휴대전화 번호 -->
                     <input type="hidden" name="tba_email" id="tba_email" />
                     <!-- 증빙신청 세금계산서 이메일 -->
                     <input type="hidden" name="tba_company_num" id="tba_company_num" />
                     <!-- 증빙신청 세금계산서 사업자번호 -->
                     <input type="hidden" name="tba_company_name"
                        id="tba_company_name" />
                     <!-- 증빙신청 세금계산서 (상호)법인명 -->
                     <input type="hidden" name="tba_company_owner"
                        id="tba_company_owner" />
                     <!-- 증빙신청 세금계산서 대표자명 -->
                     <input type="hidden" name="tba_company_post"
                        id="tba_company_post" />
                     <!-- 증빙신청 세금계산서 우편번호 -->
                     <input type="hidden" name="tba_company_addr"
                        id="tba_company_addr" />
                     <!-- 증빙신청 세금계산서 주소 -->
                     <input type="hidden" name="tba_company_addr2"
                        id="tba_company_addr2" />
                     <!-- 증빙신청 세금계산서 상세주소 -->
                     <input type="hidden" name="tba_company_biz" id="tba_company_biz" />
                     <!-- 증빙신청 세금계산서 업태 -->
                     <input type="hidden" name="tba_company_item"
                        id="tba_company_item" />
                     <!-- 증빙신청 세금계산서 업종 -->
                     <input type="hidden" name="is_evidence_serchaddress"
                        id="is_evidence_serchaddress" />
                     <!-- 증빙신청 세금계산서 우편번호 클릭여부 -->
                     <input type="hidden" name="evidence_data" id="evidence_data"
                        value="" /> <input type="hidden" name="use_tax" id="use_tax"
                        value="" /> <input type="hidden" name="pvd_deli_price"
                        id="pvd_deli_price" value="0" />
                     <!-- 공급자 배송비 (추가배송비 포함)-->
                     <input type="hidden" id="emoneyok" name="emoneyok" value="Y">
                     <input type="hidden" name="year" value="2021"> <input
                        type="hidden" name="mon" value="03"> <input
                        type="hidden" name="day" value="05"> <input
                        type="hidden" name="hope_deli_s_date" value=""> <input
                        type="hidden" name="hope_deli_e_date" value=""> <input
                        type="hidden" name="hope_deli_day2_setting" value="3649">
                     <input type="hidden" name="hopedate_start_year" value="2021">
                     <input type="hidden" name="hopedate_start_month" value="03">
                     <input type="hidden" name="hopedate_start_day" value="05">
                     <input type="hidden" id="hopedate_except_month" value="">
                     <input type="hidden" id="hopedate_except_day"
                        value="2021-03-02,2021-03-03,2021-03-04,"> <input
                        type="hidden" id="hopedate_except_holiday"
                        value="01-01,03-01,05-05,06-06,08-15,10-03,10-09,12-25,">
                     <input type="hidden" name="tempslimPhone" value="" id=tempslimPhone>
                     <input type="hidden" name="tempslimPhoneMid" value="" id=tempslimPhoneMid> 
                     <input type="hidden" name="tempslimPhoneEnd" value="" id=tempslimPhoneEnd>
                     <input type="hidden" name="member_before_pay" id="member_before_agree" value="Y">

                     <fieldset>
                        <h3>주문리스트</h3>
                        <div class="tbl-order">
                           <table>
                              <colgroup>
                                 <col width="150" />
                                 <col width="*" />
                                 <col width="100" />
                                 <col width="150" />
                                 <col width="100" />
                              </colgroup>
                              <thead>
                                 <tr>
                                    <th scope="col"></th>
                                    <th scope="col">제품</th>
                                    <th scope="col">수량</th>
                                    <th scope="col">가격</th>
                                    <th scope="col">적립</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="nbg">
                                    <td>
                                       <div class="tb-center">
                                          <div class="thumb">
                                             <img src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.detailInfo.attachmentList[0].thumbnailPath }"/>" id="picture" name="picture"/>
                                          </div>
                                       </div>
                                    </td>
                                    <td>
                                       <div class="tb-left">
                                          <c:out value="${ requestScope.detailInfo.name }"/>
                                       </div>
                                    </td>
                                    <td>
                                       <div class="tb-center">${ param.count }</div>
                                    </td>
                                    <td>
                                       <div id="price"></div>
                                    </td>
                                    <td>
                                       <div id="point1" class="tb-center"></div>
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                        <!-- .table-order -->

                        <h3>주문자정보</h3>
                        <div class="tbl-order">
                           <table>
                              <colgroup>
                                 <col width="130">
                                 <col />
                              </colgroup>
                              <tbody>
                                 <tr>
                                    <th scope="row"><div class="txt-l">이름</div></th>
                                    <td>${ requestScope.loginInfo.name }<input
                                       type="hidden" name="sender" form="order_form" id="sender"
                                       class="MS_input_txt"
                                       value="${ requestScope.loginInfo.name }" />
                                    </td>
                                 </tr>
                                 <tr>
                                    <th scope="row"><div class="txt-l">이메일</div></th>
                                    <td>${ requestScope.loginInfo.email }</td>
                                 </tr>
                                 <tr>
                                    <th scope="row"><div class="txt-l">핸드폰</div></th>
                                    <td><select name="phone1" form="order_form"
                                       id="emergency11" class="MS_select MS_tel">
                                          <option value="">선택</option>
                                          <option value="010">010</option>
                                          <option value="011">011</option>
                                          <option value="016">016</option>
                                          <option value="017">017</option>
                                          <option value="018">018</option>
                                          <option value="019">019</option>
                                    </select> - 
                                    <input type="text" name="phone2" form="order_form" id="emergency12" size="4" maxlength="4" class="MS_input_txt w60" value=""> - 
                                    <input type="text" name="phone3" form="order_form" id="emergency13" size="4" maxlength="4" minlength=4 class="MS_input_txt w60" value=""></td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                        <!-- .tbl-order -->

                        <h3>
                           배송 정보 <label> <input type="checkbox" name="same"
                              form="order_form" id="same" onclick="copydata()"> 위
                              정보와 같음
                           </label>
                        </h3>
                        
                        <div class="tbl-order">
                           <table>
                              <colgroup>
                                 <col width="130">
                                 <col />
                                 <col width="130">
                                 <col />
                              </colgroup>
                              <tbody>
                                 <tr>
                                    <th scope="row"><div class="txt-l">이름</div></th>
                                    <td colspan="3"><input type="text" name="receiver" form="order_form" id="receiver" class="MS_input_txt" value="" /></td>
                                 </tr>
                                 <tr>
                                    <th scope="row"><div class="txt-l">핸드폰</div></th>
                                    <td><select name="slimPhone" form="order_form"
                                       id="slimPhone" class="MS_select MS_tel">
                                          <option value="">선택</option>
                                          <option value="010">010</option>
                                          <option value="011">011</option>
                                          <option value="016">016</option>
                                          <option value="017">017</option>
                                          <option value="018">018</option>
                                          <option value="019">019</option>
                                    </select> - <input type="text" name="slimPhoneMid" form="order_form"
                                       id="slimPhoneMid" size="4" maxlength="4"
                                       class="MS_input_txt w60" value=""> - <input
                                       type="text" name="slimPhoneEnd" form="order_form"
                                       id="slimPhoneEnd" size="4" maxlength="4" minlength=4
                                       class="MS_input_txt w60" value=""></td>
                                 </tr>
                                 <tr>
                                    <th scope="row"><div class="txt-l">배송지 선택</div></th>
                                    <td colspan="3"><input type="radio" value="A"
                                       name="place" form="order_form" onclick="addrclick()" />
                                       내 주소&nbsp; &nbsp;&nbsp;<input type="radio" value="E" form="order_form"
                                       name="place" onclick="post();" />신규 배송지</font></td>
                                 </tr>
                                 <tr>
                                    <th scope="row"><div class="txt-l">주소</div></th>
                                    <td colspan="3">
                                    <input name="post1" id="post1" form="order_form" size="6" class="MS_input_txt w60"> 
                                    <a id="searchPost" class="btn-white">우편번호</a>
                                       <div class="mt-10">
                                          <input type="text" name="address1" form="order_form" id="address1" size="50" class="MS_input_txt w240" readonly> 
                                          <input type="text" name="address2" form="order_form" id="address2" size="50" class="MS_input_txt w240">
                                       </div>
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                        <!-- .tbl-order -->

                        <h3>주문상품 할인적용</h3>
                        <div class="tbl-pay">
                           <table>
                              <colgroup>
                                 <col style="width: 24%" />
                                 <col style="width: 18%" />
                                 <col style="width: 18%" />
                                 <col style="width: 18%" />
                                 <col style="width: 22%" />
                              </colgroup>
                              <thead>
                                 <tr>
                                    <th scope="col">상품금액</th>
                                    <th scope="col">배송비</th>
                                    <th scope="col">할인금액</th>
                                    <th scope="col">추가금액</th>
                                    <th scope="col">결제 예정금액</th>
                                 </tr>
                                 <tr>
                                    <td>
                                       <div class="base">
                                          <strong><em><span id="price1"
                                                class="op-total block-op-product-price"></span></em>원</strong>
                                       </div>
                                    </td>
                                    <td>
                                       <div class="base">
                                          <strong><em><span id="deliveryPrice"
                                                class="op-total block-op-delivery-price"></span></em><span
                                             id="block_op_delivery_unit">원</span></strong> <a class="plus"><img
                                             src="/mg/resources/image/payment/bul_h23_plus.png" alt="plus" /></a><a
                                             class="minus" style="display: none;"><img
                                             src="/images/common/bul_h23_minus.png" alt="minus" /></a>
                                       </div>
                                    </td>
                                    <td>
                                       <div class="base">
                                          <strong><em class="fc-red"><span id="salePrice"
                                                class="op-total block-op-sale-price" ></span></em>원</strong>
                                          <a class="plus" style="display: none;"><img
                                             src="/mg/resources/image/payment/bul_h23_plus.png" alt="plus" /></a><a
                                             class="minus"><img
                                             src="/mg/resources/image/payment/bul_h23_minus.png" alt="minus" /></a>
                                       </div>
                                    </td>
                                    <td>
                                       <div class="base">
                                          <strong><em><span id="addPrice"
                                                class="op-total block-op-add-price" ></span></em>원</strong>
                                          <a class="plus"><img
                                             src="/mg/resources/image/payment/bul_h23_plus.png" alt="plus" /></a><a
                                             class="minus" style="display: none;"><img
                                             src="/mg/resources/image/payment/bul_h23_minus.png" alt="minus" /></a>
                                       </div>
                                    </td>
                                    <td>
                                       <div class="base">
                                          <a class="equal"><img
                                             src="/mg/resources/image/payment/bul_h23_equal.png" alt="equal" /></a> <strong><em
                                             class="fc-red"><span id="price2" 
                                             class="block-op-sum-price"
                                                ></span></em>원</strong>
                                       </div>
                                    </td>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <th class="txt-l">적립금 사용&nbsp;&nbsp;<button id="usePoint" type="button">적용</button></th>
                                    <td colspan="4">
                                    <input type="text" id="usePointNum" name="usereserve" form="order_form" autocomplete="off"
                                       size="7" style="background: silver" class="MS_input_txt allways-disable">
                                        <label> <input type="checkbox" id="usePointNumAll"
                                          name="all_check_reserve"> 전액사용
                                    </label> <span class="fc-gray">(사용가능 적립금: <span id="ableUsePoint"></span> 원) 
                                    </span>
                                       <div class="cnt-box"></div></td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                        <!-- .tbl-pay -->

                        <h3>
                           결제 정보
                        </h3>
                        <div class="tbl-order">
                           <table>
                              <colgroup>
                                 <col width="130">
                                 <col />
                              </colgroup>
                              <tbody>
                                 <tr>
                                    <th scope="row"><div class="txt-l">결제방법</div></th>
                                    <td>
                                       <ul class="pay-method">
                                          <li><input type="radio" class="chk-rdo"
                                             name="radio_paymethod" value="C" /> 신용카드 <em><span
                                                class="op-card-dc-price fc-red"></span></em></li>
                                       </ul>
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                        <!-- .tbl-order -->


								<!-- 증빙신청 태그 추가 시 임의로 태그를 제거하게 되면 결제 등 정상 동작이 불가할 수 있습니다 !!! -->
								<div id="evidence" style="display: none;">
									<div class="tbl-order"
										style="margin-top: 0px; border-top: 0px;">
										<table>
											<caption>증빙 신청</caption>
											<colgroup>
												<col width="130">
												<col />
											</colgroup>
											<tbody>
												<tr>
													<th scope="row"><div class="txt-l">증빙 신청</div></th>
													<td style="padding-left: 18px;"><input type="radio"
														name="evidencecheck" form="order_form" onclick=""
														value="N" checked /> 신청안함 <input type="radio"
														name="evidencecheck" form="order_form" onclick=""
														value="cashbill" /> 현금영수증

														<div style="padding-top: 5px;">
															<div id="evidence_data">
																<script type='text/javascript' src="/js/check.js"></script>
																<div id="evidence_donot_data"
																	style="display: none; color: red;">
																	* 투명한 온라인 거래를 위해서 현금영수증 의무발행을 사용하고 있습니다.<br />* 현금영수증을
																	신청하지 않아도 의무발행제도에 의하여 '국세청 발급번호 010-000-1234'로 발행 됩니다.
																</div>
																<div id="evidence_cashbill_data" style="display: none;">
																	<span id="cashbilltype"> <select
																		name="evidence_banktype" class="bank-type"
																		onchange="togglecashbilltype(this.value)">
																			<option value='0' selected>핸드폰 번호
																			<option value='1'>국세청 현금영수증 카드
																			<option value='2'>사업자 번호
																	</select>
																	</span> <span id="evidence_cashbill_tel"> <input
																		type="text" name="mobilephone" size="5" maxlength="3"
																		class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['mobilephone'][0], this.form['mobilephone'][1], 3);"
																		onKeyPress="InpuOnlyPhone(this)" /> - <input
																		type="text" name="mobilephone" size="5" maxlength="4"
																		class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['mobilephone'][1], this.form['mobilephone'][2], 4);"
																		onKeyPress="InpuOnlyPhone(this)" /> - <input
																		type="text" name="mobilephone" size="5" maxlength="4"
																		class="MS_input_txt txt-input w60"
																		onKeyPress="InpuOnlyPhone(this)" />&nbsp;<span
																		style=""><input type="checkbox" name="reset" />초기화</span></span>
																	<span
																		id="evidence_cashbill_card" style="display: none">                    <input
																		type="text" name="tax_card_number" size="5"
																		maxlength="4" class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['tax_card_number'][0], this.form['tax_card_number'][1], 4);"
																		onKeyPress="InpuOnlyPhone(this)" /> - 
                    <input type="text" name="tax_card_number" size="5"
																		maxlength="4" class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['tax_card_number'][1], this.form['tax_card_number'][2], 4);"
																		onKeyPress="InpuOnlyPhone(this)" /> - 
                    <input type="text" name="tax_card_number" size="5"
																		maxlength="4" class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['tax_card_number'][2], this.form['tax_card_number'][3], 4);"
																		onKeyPress="InpuOnlyPhone(this)" /> - 
                    <input type="text" name="tax_card_number" size="6"
																		maxlength="6" class="MS_input_txt txt-input w60"
																		onKeyPress="InpuOnlyPhone(this)" /></span>                                                        <span
																		id="evidence_cashbill_company" style="display:none">                                                                                <input
																		type="text" name="crn" size="4" maxlength="3"
																		class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['crn'][0], this.form['crn'][1], 3);"
																		onKeyPress="InpuOnlyPhone(this)" /> - 
                    <input type="text" name="crn" size="3" maxlength="2"
																		class="MS_input_txt txt-input w60"
																		onkeyup="nextfocus(this.form['crn'][1], this.form['crn'][2], 2);"
																		onKeyPress="InpuOnlyPhone(this)" /> - 
                    <input type="text" name="crn" size="6" maxlength="5"
																		class="MS_input_txt txt-input w60" />                                                            <span
																		class="company-name">업체명 :                     <input
																			type="text" name="crname" size="16" maxlength="20"
																			class="MS_input_txt txt-input w60"></span>
                                                        </span>                                            
                                                                                                    </div>
                                                <div
																	id="evidence_taxbill_data" style="display:none;">                                                <table
																		class="tbl-taxbill">
                                                    <colgroup>
                                                        <col
																				style="width: 19%">
                                                        <col
																				style="width: *">
                                                    </colgroup>
                                                    <tbody>
                                                        <tr>
                                                            <th><div>신청자명</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>휴대폰번호</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>이메일</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>사업자번호</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>상호(법인명)</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>대표자명</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>사업장주소</div></th>
                                                            <td>
                                                                <div>
                                                                                                                                        <a
																							href="" class="btn-white">우편번호</a><br />
                                                                    <br />
                                                                                                                                    </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>업태</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th><div>종목</div></th>
                                                            <td>
                                                                <div></div>
                                                            </td>
                                                        </tr>                                            
                                                    </tbody>              
                                                </table>
                                                </div>                                            </div>                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        </div>                        
                        <div class='lst-order'>
        <ul id='payinfo_C' class='payment-info' style="display: none">
            <li>· 안심클릭 및 인터넷안전결제(ISP)서비스로 <font color=blue>128bit SSL</font>로 암호화된 결제 창이 새로 뜹니다.</li>
            <li>· 결제후, 카드명세서에 [<font color=red>tosspayments.com(토스페이먼츠)</font>]로 표시되며, 카드 정보는 상점에 남지 않습니다.</li>
            
        </ul>
        <ul id='payinfo_D' class='payment-info' style="display: none">
            <li>· 결제정보가 상점에 남지 않으며, 보안 적용된 결제창이 새로 뜹니다.</li> 
            <li>· 결제후, 핸드폰 요금청구서에 '소액결제'로 표시됩니다.</li>
            <li>· <font color=red>결제후, 결제건의 취소는 해당 달에만 가능합니다.</font></li>
            
        </ul>
        <ul id='payinfo_A' class='payment-info' style='display: none'>
            <li><img src='/images/common/paypal_text_KOR.gif'></li>
        </ul>
        <ul id='payinfo_T' class='payment-info' style='display: none'>
            <li>·제휴BC카드 이외의 카드로는 결제가 되지 않습니다.</li>
        </ul>
      </div>

                        <!-- 고급형 사은품 선택 노출 -->
                                                   
                        <h3>주문자 동의</h3>
                        <div class="tbl-order">
                            <table>
                                <colgroup>
                                    <col width="130">
                                    <col />
                                </colgroup>
                                <tbody>
                                                                                                            <tr>
                                        <th scope="row"><div
														class="txt-l">주문동의</div></th>
                                        <td>
                                            <label class="label">            <input
														type="checkbox" id="pay_agree" name="pay_agree"
														form="order_form" /> 상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</label>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
								<!-- .tbl-order -->

                                                        <br><hr><div
									class="tbl-order tot-order">
                                <table>
                                    <caption></caption>
                                    <colgroup>
                                        <col width="130">
                                        <col />
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th><center>최종 결제금액</center></th>
                                            <td>
                                                <strong class="price"><em><span id="price3"></span></em> 
                                                <span id="block_unit_won">원</span></strong> &nbsp; 
                                        (적립예정: <span id="block_expect_reserve" data-original-reserve="1100"
													coupon-reserve="0">1,100</span>원)
                                                        <div
														class="reserve-msg">(적립 예정금액과 최종 적립금액은 상이할 수 있습니다. 주문 완료 시 지급되는 적립금을 확인해주시기 바랍니다.)</div>
                                                                                                                                                </td>
                                        </tr>
                                    
										</tbody>
                                </table>
                            </div>
								<!-- .tbl-pay -->
								<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
								                        <script>
                        $('select[name="phone1"] option[value='+'${ requestScope.loginInfo.phone}'.substring(0, 3)+']').attr("selected", true);
                        $('input[name="phone2"]').val('${ requestScope.loginInfo.phone}'.substring(3, 7));
                        $('input[name="phone3"]').val('${ requestScope.loginInfo.phone}'.substring(7, 11));
                        console.log('${ requestScope.loginInfo.phone}'.substring(0, 3));
                        
                        //주문정보 동일checkbox action
                        function copydata() {
                            if ($('input[name="same"]').prop('checked') === true) {
                               
                                $('input[name="receiver"]').val($('input[name="sender"]').val());
                                
                                if ('select' == 'select') {
                                   if ($('select[name="slimPhone"]')) {
                                      $('select[name="slimPhone"] option[value='+'${ requestScope.loginInfo.phone}'.substring(0, 3)+']').attr("selected", true);
                                   } else {
                                      console.table($('select[name="slimPhone"]'));
                                      $('select[name="slimPhone"]').val('${ requestScope.loginInfo.phone}'.substring(0, 3)).attr("selected", true);
                                   }
                                } else {
                                }
                                
                              $('input[name="slimPhoneMid"]').val('${ requestScope.loginInfo.phone}'.substring(3, 7));
                              $('input[name="slimPhoneEnd"]').val('${ requestScope.loginInfo.phone}'.substring(7, 11));
                                
                            } else {
                                $('input[name="receiver"]').val('');
                                 if ('select' == 'select') {
                                    if ($('select[name="slimPhone"]')) $('select[name="slimPhone"] option[value=""]').attr("selected",true);
                                } else {
                                    if ($('select[name="slimPhone"]')) $('select[name="slimPhone"]').val('');
                                }
                                if ($('input[name="slimPhoneMid"]')) $('input[name="slimPhoneMid"]').val('');
                                if ($('input[name="slimPhoneEnd"]')) $('input[name="slimPhoneEnd"]').val('');
                            }
                        }
                        function addrclick() {
                           var result = '${ requestScope.loginInfo.address }'.split('$');
                           
                           $('input[name="post1"]').val(result[0]);
                           $('input[name="address1"]').val(result[1]);
                           $('input[name="address2"]').val(result[2]);
                           
                        }
                        
                        function post() {
                           console.log('하이');
                           
                           $('input[name="post1"]').val('');
                           $('input[name="address1"]').val('');
                           $('input[name="address2"]').val('');
                           
                        }
                        
                        var resultPr = 0;
                        if(${ param.count > 0 }) {
	                        resultPr = ${ param.count * requestScope.detailInfo.price};
                        } else {
                        	resultPr = ${ requestScope.detailInfo.price };
                        }
                        
                        var point = resultPr * 0.02;
                        
                        function makeComma(str) { str = String(str); return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,'); }
                        $("#price").html(makeComma(resultPr) + '원'); 
                        $("#price1").html(makeComma(resultPr) + ' '); 
                        $("#deliveryPrice").html(0 + ' ');
                        $("#salePrice").html(0 + ' ');
                        $("#addPrice").html(0 + ' ');
                        $("#price2").html(makeComma(resultPr) + ' '); 
                        $("#price3").html(makeComma(resultPr) + ' '); 
                        $("#point1").html(makeComma(point) + '원'); 
                        $("#ableUsePoint").html(makeComma(${ requestScope.loginInfo.point })); 
                        
                        $("#searchPost").click(function() {
                        	new daum.Postcode({
                        		oncomplete : function(data) {
                        			console.log(data.zonecode);
                        			console.log(data.address);
                        			$('input[name="post1"]').val(data.zonecode);
                        			$('input[name="address1"]').val(data.address);
                        			$('input[name="address2"]').focus();
                        		}
                        	}).open();
                        });
                        
                        var p = 0;
                        $("#usePointNum").click(function() {
                        	if($("#usePointNumAll").prop("checked")) {
                        		$("#usePointNum").val('');
                        		
                        		//실패. 왜 안되는지 모르겠다.(03/01)
                        		$("#usePointNumAll").attr("checked", false);
                        	} else {
                        		/* $("#usePointNumAll").attr("checked", true); */
                        	}
                        	
                        	
                        });
                        /* $("#usePointNum").keyup(function() {}); */
                        $("#usePointNum").blur(function() {
                        	/* console.log($("#usePointNum").val());
                        	console.log("온");
                        	console.log(resultPr - $("#usePointNum").val());
                        	console.log(p); */
                        	p = resultPr - $("#usePointNum").val();
                        	if(p > 0) {
                        		$("#salePrice").html(makeComma($("#usePointNum").val()) + ' ');
                        		$("#price2").html(makeComma(p) + ' '); 
                        		$("#price3").html(makeComma(p) + ' ');
                        	} else {
                        		$("#salePrice").html(makeComma(resultPr) + ' ');
                        		$("#usePointNum").val(makeComma(resultPr) + ' ');
                        		$("#price2").html(0 + ' '); 
                        		$("#price3").html(0 + ' ');
                        	}
                        });
                        
                        $("#usePoint").click(function() {
                        	if(p > 0) {
                        		$("#salePrice").html(makeComma($("#usePointNum").val()) + ' ');
                        		$("#price2").html(makeComma(p) + ' '); 
                        		$("#price3").html(makeComma(p) + ' ');
                        	} else {
                        		$("#salePrice").html(makeComma(resultPr) + ' ');
                        		$("#usePointNum").val(makeComma(resultPr) + ' ');
                        		$("#price2").html(0 + ' '); 
                        		$("#price3").html(0 + ' ');
                        	}
                        	console.log("클릭버튼");
                        })
                	 
              	   	$("#usePointNumAll").change(function() {
              	    	if($(this).prop("checked")) {
              	    		console.log("클릭버튼");
              	    		
              	    		$("#usePointNum").click(function() {
              	    			//체크박스 변경 실패.
              	   			});
              	    		
              	    		if(${ requestScope.loginInfo.point } > 0) {
              	    			
              	    			if(${ requestScope.loginInfo.point } > resultPr) {
              	    				$("#usePointNum").val(resultPr);
              	    			} else {
              	    				$("#usePointNum").val(${ requestScope.loginInfo.point });
              	    			}
              	    			
              	    				
              	    		}
              	    		
            	    	} else {
            	    		$("#usePointNum").val('');
            	    		console.log("클릭버튼dd");
            	    		
            	    	}
                 	});
                        
                        </script>
                           
                            
                            <div id="paybutton"><a href="${ pageContext.servletContext.contextPath }/proceed/payment" class="pay_btn">주문하기</a>
                                <a href="javascript:order_cancel('cancel')" class="can_btn">주문취소</a>
                            </div>                        </fieldset>
                        </form>                    </div>
					<!-- .page-body -->



                </div>
				<!-- #order -->






          </div>
			<!-- #contentSub -->


        </div>
		<!-- #contentWrap -->
    </div>
	<!-- #contentWrapper-->
    <hr />
    <script>
    function requestPay() {
      // IMP.request_pay(param, callback) 호출
      IMP.request_pay({ // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: "ORD20180131-0000011",
          name: "노르웨이 회전 의자",
          amount: 64900,
          buyer_email: "gildong@gmail.com",
          buyer_name: "홍길동",
          buyer_tel: "010-4242-4242",
          buyer_addr: "서울특별시 강남구 신사동",
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {
              ...,
              // 결제 성공 시 로직,
              ...
          } else {
              ...,
              // 결제 실패 시 로직,
              ...
          }
      });
    }
  </script>
    

	
	
	
	<jsp:include page="../common/footer.jsp" /><
																			/body>
</html>