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
										<caption>주문리스트</caption>
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
													<div class="tb-center">1개</div>
												</td>
												<td>
													<c:out value="${ requestScope.detailInfo.price }"/>
												</td>
												<td>
													<div class="tb-center">1,100원</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- .table-order -->

								<h3>주문자정보</h3>
								<div class="tbl-order">
									<table>
										<caption>주문자정보</caption>
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
												<td>${ requestScope.loginInfo.phone }</td>
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
								
								
								</script>
								
								
								<div class="tbl-order">
									<table>
										<caption>배송 정보 입력</caption>
										<colgroup>
											<col width="130">
											<col />
											<col width="130">
											<col />
										</colgroup>
										<tbody>
											<tr>
												<th scope="row"><div class="txt-l">이름</div></th>
												<td colspan="3"><input type="text" name="receiver"
													form="order_form" id="receiver" class="MS_input_txt"
													value="" /></td>
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
												<input name="post1" id="post1" form="order_form" size="6" class="MS_input_txt w60" onclick='this.blur();post();'> 
												<a href="javascript:post();" class="btn-white">우편번호</a>
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
										<caption>주문상품 할인적용</caption>
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
														<strong><em><span
																class="op-total block-op-product-price" price="118000">${ requestScope.detailInfo.price }</span></em>원</strong>
													</div>
												</td>
												<td>
													<div class="base">
														<strong><em><span
																class="op-total block-op-delivery-price" price="0">0</span></em><span
															id="block_op_delivery_unit">원</span></strong> <a class="plus"><img
															src="/mg/resources/image/payment/bul_h23_plus.png" alt="plus" /></a><a
															class="minus" style="display: none;"><img
															src="/images/common/bul_h23_minus.png" alt="minus" /></a>
													</div>
												</td>
												<td>
													<div class="base">
														<strong><em class="fc-red"><span
																class="op-total block-op-sale-price" price="-0">0</span></em>원</strong>
														<a class="plus" style="display: none;"><img
															src="/mg/resources/image/payment/bul_h23_plus.png" alt="plus" /></a><a
															class="minus"><img
															src="/mg/resources/image/payment/bul_h23_minus.png" alt="minus" /></a>
													</div>
												</td>
												<td>
													<div class="base">
														<strong><em><span
																class="op-total block-op-add-price" price="0">0</span></em>원</strong>
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
															class="fc-red"><span class="block-op-sum-price"
																price="118000">계산 준비중</span></em>원</strong>
													</div>
												</td>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th class="txt-l">적립금 사용</th>
												<td colspan="4"><input type="text" id="usereserve"
													name="usereserve" form="order_form" autocomplete="off"
													size="7" style="background: silver"
													class="MS_input_txt allways-disable" value="0"
													onKeyUp="reservecheck('3000')" onBlur=getUseableMoney();
													readonly> <label> <input type="checkbox"
														name="all_check_reserve" onclick="allCheckUse('reserve');"
														disabled> 전액사용
												</label> <span class="fc-gray">(사용가능 적립금: <input type="text"
														id="okreserve" name="okreserve" form="order_form"
														autocomplete="off" size="7" class="MS_input_txt"
														value="3000" readonly>원) / (5,000원 이상부터 사용 가능합니다.)
												</span>
													<div class="cnt-box"></div></td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- .tbl-pay -->

								<h3>
									결제 정보
									<div class="before_pay">
										<label> <input type="checkbox" id="before_pay_agree"
											name="before_pay_agree" form="order_form" /> 선택하신 결제수단을 다음에도
											적용
										</label>
									</div>
								</h3>
								<div class="tbl-order">
									<table>
										<caption>결제 정보</caption>
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
															name="radio_paymethod" value="KAKAOPAY" checked='checked' />
															카카오페이(KAKAOPAY) <em><span
																class="op-card-dc-price fc-red"></span></em></li>
														<li><input type="radio" class="chk-rdo"
															name="radio_paymethod" value="PAYCO" /> 페이코(PAYCO) <em><span
																class="op-card-dc-price fc-red"></span></em></li>
														<li><input type="radio" class="chk-rdo"
															name="radio_paymethod" value="B" /> 무통장입금 <em><span
																class="op-bank-dc-price fc-red"></span></em> <select
															name="pay_data"
															class="w280 MK_bank_select_list MK_pay_add_choice"><option
																	value=''>입금 계좌번호 선택(반드시 주문자 성함으로 입금)</option>
																<option value="국민은행 793301-01-678439 (예금주:(주)옳은)">국민은행
																	793301-01-678439 (예금주:(주)옳은)</option>
																<option value="농협중앙회 301-0184-7928-01 (예금주:(주)옳은)">농협중앙회
																	301-0184-7928-01 (예금주:(주)옳은)</option>
																<option value="기업은행 123-159598-04-011 (예금주:(주)옳은)">기업은행
																	123-159598-04-011 (예금주:(주)옳은)</option>
														</select></li>
														<li><input type="radio" class="chk-rdo"
															name="radio_paymethod" value="C" /> 신용카드 <em><span
																class="op-card-dc-price fc-red"></span></em></li>
														<li><input type="radio" class="chk-rdo"
															name="radio_paymethod" value="V" /> 실시간 계좌이체 <em><span
																class="op-bank-dc-price fc-red"></span></em></li>
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
                                    <ul id='payinfo_V'
										class='payment-info' style='display: none'>
            <li>· 본인 계좌 정보입력으로 결제금액이 이체되는 서비스입니다.</li>
            <li>· 인터넷뱅킹과 동일한 보안방식을 적용하므로 안전하며, 상점에 정보가 남지 않습니다.</li>
        </ul>
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
        <ul id='payinfo_PAYCO' class='payment-info'
										style='display: none'>
                 
            <li style='color:#3b3b3b;'><strong>★ 페이코 POINT 결제시<font
												color='red'> “언제나” 2%</font> 적립 (기본 0.2% 적립)</strong></li>
										<li style='color:#3b3b3b;'><strong>★ 페이코 첫 결제시 1만원 이상 <font
												color='red'>2,000원 즉시 할인</font></strong></li> 
            
            
        </ul>
        <ul id='payinfo_KAKAO' class='payment-info'
										style='display: none'>
            <li>· <img src="/images/common/orderpay_kakao.gif"
											alt="카카오페이" style="vertical-align:middle;" /></li>
            <li>· 가장 빠른 모바일 결제 <img
											src="/images/common/orderpay_kakao2.gif" alt="카카오페이"
											style="margin:0 5px; vertical-align:middle;" /> 
            <a href="http://www.kakao.com/kakaopay" target="_blank"
											style="text-decoration:underline;">지금 바로 확인하세요&gt;</a></li>
            
        </ul>
        <ul id='payinfo_KAKAOPAY' class='payment-info'
										style='display: none'>
            <li>· 카카오톡에서 신용/체크카드 연결하고, 결제도 지문으로 쉽고 편리하게 이용하세요!</li>
            <li>· 본인명의 스마트폰에서 본인명의 카드 등록 후 사용 가능</li>
            <li>· (카드등록 : 카카오톡 > 더보기 > 카카오페이 > 카드)</li>
            <li>· 이용가능 카드사 : 모든 국내 신용/체크카드</li>
            <li>· 카드 결제 시, 결제금액 200만원 이상일 경우 ARS추가 인증이 필요합니다. 카카오머니 결제시는 추가인증 없음</li>
        </ul>
        <ul id='payinfo_SSGPAY' class='payment-info'
										style='display: none'>
            <li>· <img src="/images/common/orderpay_ssgpay.png"
											alt="쓱페이" style="vertical-align:middle; margin-bottom:6px;" /></li>
                <li>· SSG MONEY : 현금영수증 발급 가능합니다.(쇼핑몰에 별도 신청)</li>
    <li>· 결제 불가 카드 : 씨티카드, 비씨카드(수협, 우체국 등)</li>    <li> * SSGPAY는 이마트, 신세계백화점, 스타벅스 등에서 사용할 수 있는 신세계의 간편결제 서비스입니다.</li>
    <li> * 결제방법 : 앱 가입 ▷ 머니충전/카드등록 ▷ 비밀번호 6자리 입력하여 결제!</li>
            
        </ul>
        <ul id='payinfo_SETTLE_BANK' class='payment-info'
										style='display: none'>
            <li>· 최초 사용 시 통장 등록 및 ARS 인증하면, 비밀번호 입력만으로 계좌 결제가 가능합니다.</li>
            <li>· 결제 후에는 현금영수증이 자동 발급됩니다.</li>
            <li>· 1회 / 1일 최대 결제금액 한도는 200만원입니다.</li>
            
        </ul>
        <ul id='payinfo_SMILEPAY' class='payment-info'
										style='display: none'>
            <li><font color="red">* 스마일페이 혜택</font></li>
            <li>1) 스마일페이 결제 시 <font color="red">0.5%</font> 기본 적립(최대 5천원)</li>
            <li>2) 스마일페이에 등록한 스마일카드로 결제 시 <font color="red">2%</font> 추가 적립</li>
            
        </ul>
        <ul id='payinfo_TOSS' class='payment-info' style='display: none'>
            <li>· 토스에 등록된 계좌와 신용/체크카드로 쉽고 편리하게 결제하세요.</li>
            <li>· 이용가능 카드사 : 비씨, 삼성, 롯데, 하나, 신한, 현대카드 (KB카드, NH농협 준비중)</li>
            <li>· 이용가능 은행 : 20개 은행과 8개 증권사</li>
            <li>· 토스 간편결제시 토스에서 제공하는 카드사별 무이자, 청구할인, 결제이벤트만 제공됩니다.</li>
            <li>· 토스머니 결제시 현금영수증은 자동으로 신청됩니다.</li>
            
        </ul>
        <ul id='payinfo_NPAY' class='payment-info' style='display: none'>
            <li>· 주문 변경 시 카드사 혜택 및 할부 적용 여부는 해당 카드사 정책에 따라 변경될 수 있습니다.</li>
            <li>· 네이버페이는 네이버ID로 별도 앱 설치 없이 신용카드 또는 은행계좌 정보를 등록하여 네이버페이 비밀번호로 결제할 수 있는 간편결제 서비스입니다.</li>
            <li>· 결제 가능한 신용카드: 신한, 삼성, 현대, BC, 국민, 하나, 롯데, NH농협, 씨티, 카카오뱅크</li>
            <li>· 결제 가능한 은행: NH농협, 국민, 신한, 우리, 기업, SC제일, 부산, 경남, 수협, 우체국, 미래에셋대우, 광주, 대구, 전북, 새마을금고, 제주은행, 신협, 하나은행, 케이뱅크, 카카오뱅크, 삼성증권, KDB산업은행,씨티은행, SBI은행, 유안타증권, 유진투자증권</li>
            <li>· 네이버페이 카드 간편결제는 네이버페이에서 제공하는 카드사 별 무이자, 청구할인 혜택을 받을 수 있습니다.</li>
            
        </ul>
        <ul id='payinfo_CHAIPAY' class='payment-info'
										style='display: none'>
            <li>· CHAI는 은행 계좌만 등록하면 간편하게 결제할 수 있는 결제 서비스입니다.</li>
            <li>· 은행점검시간인 23:30~00:30까지는 이용이 불가합니다. (단, 차이머니 보유 시 은행점검시간 관계 없이 결제 가능합니다.)</li>
            <li>· 등록 가능한 계좌는 CHAI 앱에서 확인 가능합니다.</li>
            <li>· 결제에 사용할 은행 계좌는 휴대폰 명의자와 일치해야 합니다.</li>
            <li>· CHAI 머니 잔액 부족 시 자동충전 후 결제 됩니다.</li>
            <li>· CHAI 결제를 이용하고 취소 시 CHAI 머니로 환불됩니다.</li>
            <li>* CHAI 특별 혜택 *<br />
            1) 1만원 이상 생애 첫 결제 시 <font color="red">5천원 즉시할인</font>(단, 상시 1.5% 적립과 중복 불가)<br />
            2) 상시 <font color="red">1.5% 캐시백</font>(결제 건당 2천원)<br />
            3) 자동충전 설정 후 결제 시 <font color="red">1% 추가 캐시백</font>(결제 건당 500원)<br />
            * 해당 혜택은 차이 사정에 의해 조기 종료 될 수 있습니다.</li>
            
        </ul>        <ul id='payinfo_B' class='payment-info'
										style='display: none'>
            <li>· 선택된 입금계좌로 <font color=blue>인터넷 뱅킹, 은행 방문</font> 등을 통해 입금해 주세요.     <a
											href='javascript:linkvalue();'><img
												src='/images/common/shop_gobank_long.gif' border=0
												align=absmiddle></a>
    <input type='hidden' name='link_value'><input type='hidden'
											name='link_value' value='https://www.kbstar.com/'>
<input type='hidden' name='link_value'
											value='http://banking.nonghyup.com/'>
<input type='hidden' name='link_value' value='http://www.mybank.co.kr/'>
</li>
            <li>· 반드시 입금 기한 내에 정확한 결제금액을 입금해 주세요.</li>
            <li>· 입금 기한이 지나면 주문은 자동취소됩니다.</li>
        </ul>        <ul id='payinfo_M' class='payment-info'
										style="display: none">
            <li>· 구매자는 반드시 국민은행 인터넷뱅킹을 이용해야 합니다.</li> 
            <li>· 국민은행 에스크로를 통해서 구매결정이 필요한 결제방식입니다.</li>
            <li>· <font color=red>주의! 발급된 가상계좌로 입금 시, 반드시 이름 / 금액이 꼭 일치해야 합니다!</font></li>
        </ul>                        </div>

                        <!-- 고급형 사은품 선택 노출 -->
                                                   
                        <h3>주문자 동의</h3>
                        <div class="tbl-order">
                            <table>
                                <caption>주문자 동의</caption>
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

                                                        <div
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
                                                <strong class="price"><em><span
															id="block_unit_dollar" style="display:none">$</span> <span
															id="op_total_price">118,000</span></em> <span
														id="block_unit_won">원</span></strong> &nbsp; 
                                                                                                                                                            (적립예정: <span
													id="block_expect_reserve" data-original-reserve="1100"
													coupon-reserve="0">1,100</span>원)
                                                        <div
														class="reserve-msg">(적립 예정금액과 최종 적립금액은 상이할 수 있습니다. 주문 완료 시 지급되는 적립금을 확인해주시기 바랍니다.)</div>
                                                                                                                                                </td>
                                        </tr>
                                    
										</tbody>
                                </table>
                            </div>
								<!-- .tbl-pay -->
                            
                            <div id="paybutton">                                <a
										href="javascript:send();" class="pay_btn">주문하기</a>
                                <a
										href="javascript:order_cancel('cancel')" class="can_btn">주문취소</a>
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
    

	
	
	
	<jsp:include page="../common/footer.jsp" /><
																			/body>
</html>