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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>

	<jsp:include page="../common/header.jsp" />


	   <div id="contentWrapper">
      <div id="contentWrap">
         <div id="content">

            <div id="order">
               <h2>주문서 작성</h2>

               <div class="page-body">

                  <form name="payment" id="order_form" action="/shop/orderin.html"
                     method="post">
                    

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
                           배송 정보 <label> <input type="checkbox" name=""
                              form="order_form" id="same" value="수취인동일" onclick="copydata()"> 위
                              정보와 같음
                           </label>
                           <input type="hidden" name="필요없음" value="필요없음">
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
                                    <td colspan="3"><input type="radio" value="즐겨찾기"
                                       name="place" form="order_form" onclick="addrclick()"/>
                                       내 주소&nbsp; &nbsp;&nbsp;<input type="radio" id="place2" value="직접입력" form="order_form"
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
                                    <th class="txt-l">적립금 사용&nbsp;&nbsp;<button id="allUseButton" type="button">적용</button></th>
                                    <td colspan="4">
                                    <input type="text" id="usePointNum" name="" form="order_form" autocomplete="off"
                                       size="15" style="background: silver" class="MS_input_txt allways-disable">
                                       <input type="hidden" name="필요없음2" value="필요없음2">
                                        <label> 
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
                                             name="radio_paymethod" value="신용카드" /> 신용카드 <em><span
                                                class="op-card-dc-price fc-red"></span></em></li>
                                       </ul>
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                        <!-- .tbl-order -->

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
                        var address = '${ requestScope.loginInfo.address }'.split('$');
                        var addressResult = '';
                        for(var i = 0; i < address.length; i++) {
                        	addressResult += address[i] + ' ';
                        }
                        
                        //주문정보 동일checkbox action
                        function copydata() {
                            if ($('#same').prop('checked') === true) {
                               
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
                        var payMoney = resultPr;
                        /* $("#usePointNum").keyup(function() {}); */
                        var returnPoint = 0;
                        $("#usePointNum").blur(function() {
                        	/* console.log($("#usePointNum").val());
                        	console.log("온");
                        	console.log(resultPr - $("#usePointNum").val());
                        	console.log(p); */
                        	p = resultPr - $("#usePointNum").val();
                        	if(p > 0 || p === 0) {
                        		if(${ requestScope.loginInfo.point } >= $("#usePointNum").val()) {
	                        		returnPoint = $("#usePointNum").val();
	                        		$("#salePrice").html(makeComma($("#usePointNum").val()) + ' ');
	                        		$("#usePointNum").val(makeComma($("#usePointNum").val()));
	                        		$("#price2").html(makeComma(p) + ' '); 
	                        		$("#price3").html(makeComma(p) + ' ');
	                        		payMoney = p;
	                        		console.log('하 포인트 : ' + payMoney);
                        		} else {
                        			alert('포인트 한도 초과');
                        			$("#usePointNum").val('');
                        			returnPoint = $("#usePointNum").val('');
                            		$("#salePrice").html(makeComma($("#usePointNum").val()) + ' ');
                            		$("#usePointNum").val(makeComma($("#usePointNum").val()));
                            		$("#price2").html(makeComma(resultPr) + ' '); 
                            		$("#price3").html(makeComma(resultPr) + ' ');
                            		payMoney = resultPr;
                        		}
                        		
                        		/* 결제 금액 < 포인트 입력한경우 */
                        	} else {
                        		$("#salePrice").html(makeComma(resultPr) + ' ');
                        		$("#usePointNum").val(makeComma(resultPr));
                        		$("#price2").html(0 + ' '); 
                        		$("#price3").html(0 + ' ');
                        		payMoney = 0;
                        		returnPoint = resultPr; 
                        	}
                        	
                        	/* if($("#usePointNum").val() === '') {
                        		alert('이거지 blur');
                        	} */
                        	
                        console.log(payMoney);
                        });
                        
                        /* 포인트창 클릭하면 초기화 */
                        $("#usePointNum").click(function() { $("#usePointNum").val(''); });
                        
             </script>
                            
                            <div id="paybutton"><a id="gogo" class="pay_btn">주문하기</a>
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
     $("#gogo").click(function() {
    	 
    	 if($('input[name="place"]').prop('checked') === false && ($("#place2").prop('checked') === false)) {
    		 alert('주소를 입력해주세요');
    	 } else if ($('input[name="radio_paymethod"]').prop('checked') === false) {
    		 alert('결제 방법을 선택해주세요');
    	 } else if ($('input[name="pay_agree"]').prop('checked') === false) {
    		 alert('주문 동의 후 결제를 진행해주세요.');
    	 } else if(payMoney === 0) {
    		 
    		 var jihun = $('form[name="payment"]').serializeArray();
             console.log($('input[name="receiver"]').val());
        	 

             jihun.push(
                     {name : "payMoney", value : payMoney }
                    , {name : 'goodsNo', value : ${ requestScope.detailInfo.no } }
                    , {name : 'goodsPrice', value : ${ requestScope.detailInfo.price } }
                    , {name : 'count', value : ${ param.count } }
                    , {name : 'buyerName', value : '${ requestScope.loginInfo.name}' }
                    , {name : 'buyerTel', value : ${ requestScope.loginInfo.phone} }
                    , {name : 'buyerAddr', value : addressResult }
                    , {name : 'buyerPostcode', value : address[0] }
                    , {name : 'buyerEmail', value : '${ requestScope.loginInfo.email}' }
                    , {name : 'payName', value : '${ requestScope.detailInfo.name } ${ param.count }개' }
                    , {name : 'existingPoint', value : ${ requestScope.loginInfo.point } }
                    , {name : 'resultPr', value : payMoney }
                    , {name : 'usePointNum', value : returnPoint }
                    , {name : 'end', value : '끝내자' }
                     );
             
             console.table(jihun);
             console.log(typeof jihun);
    		 
    		 $.ajax({
                 url: "${ pageContext.servletContext.contextPath }/testJihun/test", //cross-domain error가 발생하지 않도록 주의해주세요
                 type: 'POST',
                 dataType: 'json',
                 data: {
                     paySuccessNo : 0,
                     jihun : jihun
                 },
                 success : function(data, textStatus, xhr) {
                	 alert(data);
                	 location.href= '${ pageContext.servletContext.contextPath }/mypage/main';
                 },
                 error : function(xhr, status, error) {}
             });
    		 
    	 } else {
    	 
         var jihun = $('form[name="payment"]').serializeArray();
         console.log($('input[name="receiver"]').val());
    	 

         jihun.push(
                 {name : "payMoney", value : payMoney }
                , {name : 'goodsNo', value : ${ requestScope.detailInfo.no } }
                , {name : 'goodsPrice', value : ${ requestScope.detailInfo.price } }
                , {name : 'count', value : ${ param.count } }
                , {name : 'buyerName', value : '${ requestScope.loginInfo.name}' }
                , {name : 'buyerTel', value : ${ requestScope.loginInfo.phone} }
                , {name : 'buyerAddr', value : addressResult }
                , {name : 'buyerPostcode', value : address[0] }
                , {name : 'buyerEmail', value : '${ requestScope.loginInfo.email}' }
                , {name : 'payName', value : '${ requestScope.detailInfo.name } ${ param.count }개' }
                , {name : 'existingPoint', value : ${ requestScope.loginInfo.point } }
                , {name : 'resultPr', value : payMoney }
                , {name : 'usePointNum', value : returnPoint }
                , {name : 'end', value : '끝내자' }
                 );
         
         console.table(jihun);
         console.log(typeof jihun);
         
         /* 분쇄기 */
         /* $.each(jihun, function(key, data) 
         { 
        	if (this.name == "sender")
        	this.value = this.value.replace(",", "");
        	console.log(this.value);
         }); */
         
    	 
        var IMP = window.IMP; // 생략가능
        IMP.init('imp63084868'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'nice',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '${ requestScope.detailInfo.name } ${ param.count }개',
            amount : payMoney,
            buyer_email : '${ requestScope.loginInfo.email}',
            buyer_name : '${ requestScope.loginInfo.name}',
            buyer_tel : '${ requestScope.loginInfo.phone}',
            buyer_addr : addressResult,
            buyer_postcode : address[0],
        }, function(rsp) {
            if ( rsp.success ) {
            	/* 방법1. ajax success로 알림창 띄워주기 */
                $.ajax({
                    url: "${ pageContext.servletContext.contextPath }/testJihun/test", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        payId : rsp.imp_uid,
                        payStore : rsp.merchant_uid,
                        payAmount : rsp.paid_amount,
                        paySuccessNo : rsp.apply_num,
                        jihun : jihun
                    },
                    success : function(data, textStatus, xhr) {
                   	 alert(data);
                   	location.href= '${ pageContext.servletContext.contextPath }/mypage/main';
                    },
                    error : function(xhr, status, error) {}
                });
                
                /* 방법2. ajax 밖인 if문 안에서 알림창 띄우기.
                     	    대신 ajax success와 동시에 사용할수 업고 동시에 사용하면 ajax의 success는 작동하지 않는다.*/
                
            } else {
                //실패시 이동할 페이지
                alert('결제가 실패하였습니다');
                location.href= '${ pageContext.servletContext.contextPath }/mypage/main';
            }
        });
        
    } //if문
   
  });
  </script>
    

	
	
	
	<jsp:include page="../common/footer.jsp" />
	</body>
</html>