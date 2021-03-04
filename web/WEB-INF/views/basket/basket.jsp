<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <script src="//code.jquery.com/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/mg/resources/css/header.css">
	<link rel="stylesheet" type="text/css" href="/mg/resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="/mg/resources/css/basket/basket_main.css">
	<link rel="stylesheet" type="text/css" href="/mg/resources/css/basket/basket_common.css">
	<link rel="stylesheet" type="text/css" href="/mg/resources/css/basket/basket_scroll.css">
<title>Insert title here</title>
</head>
<body>

		<jsp:include page="../common/header.jsp"/>

    <div id="contentWrapper">
		<div id="contentWrap">
			<div id="content">

				<div id="cartWrap">
					<h2>장바구니</h2>
					<div class="page-body">
						<div class="table-cart table-fill-prd">
							<table summary="사진, 제품명, 수량, 적립, 가격, 배송비, 취소">
                                <caption>장바구니 담긴 상품</caption>
                                <colgroup>
                                    <col width="70">
                                    <col width="150">
                                    <col width="*">
                                    <col width="100">
                                    <col width="70">
                                    <col width="90">
                                    <col width="90">
                                    <col width="90">
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th scope="col"><div class="tb-center">사진</div></th>
                                        <th scope="col"><div class="tb-center">&nbsp;</div></th>
                                        <th scope="col"><div class="tb-center">제품명</div></th>
                                        
                                        <th scope="col"><div class="tb-center">수량</div></th>
                                        <th scope="col"><div class="tb-right">적립</div></th>
                                        <th scope="col"><div class="tb-right">가격</div></th>
                                        <th scope="col"><div class="tb-center">배송비</div></th>
                                        <th scope="col"><div class="tb-center">합계</div></th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                <tr>
                                         <td scope="col"><div class="tb-center"> <img src="${ pageContext.servletContext.contextPath }<c:out value="${ requestScope.detailInfo.attachmentList[0].thumbnailPath }"/>"></div></td>
                                         
                               	        <%-- <td scope="col"><div class="tb-center"><img src="${ pageContext.servletContext.contextPath }/resources/upload/original/a25a6e882e3749b8ae30890c33714421.png" height="100px" width="100px"/></div></td> --%>
                                        <td scope="col"><div class="tb-center">&nbsp;</div></td>
                                        <td scope="col"><div class="tb-center"><c:out value="${ requestScope.detailInfo1.mgGoodsDTO.name }"/></div></td>
                                        
                                        <td scope="col"><div class="tb-center">${ param.count }</div></td>
                                        <%-- <td scope="col"><div class="tb-center"><c:out value="${ requestScope.detailInfo1.amountCount }"/>개</div></td> --%>
                                        <td scope="col"><div class="tb-right"><fmt:formatNumber value="${ requestScope.detailInfo1.mgGoodsDTO.price * param.count * 0.02}"/>pt</div></td>
                                        <td scope="col"><div class="tb-right"><fmt:formatNumber value="${ requestScope.detailInfo1.mgGoodsDTO.price }"/>원</div></td>
                                        <td scope="col"><div class="tb-center">0원</div></td>
                                        <td scope="col"><div class="tb-center"><fmt:formatNumber value="${ requestScope.detailInfo1.mgGoodsDTO.price * param.count }"/>원</div></td>
                                        
                                </tr>
                                </tbody>
                                <tfoot>
                                   <!--  <tr>
                                        <td colspan="8" class="bgd">
                                                                                    <div class="tb-center dont_nocart">장바구니에 담긴 상품이 없습니다.</div>
                                                                                </td>
                                    </tr> -->
                                </tfoot>
                                        </table>
                            
                        </div><!-- .table-fill-prd -->
                        
                                                <div class="basket-totalprice" >
                            <div class="totalprice-txt"> <strong>총액 : <fmt:formatNumber value="${ requestScope.detailInfo1.mgGoodsDTO.price * param.count }"/>원</strong></div>
                        </div>
                                                                        




                        <div class="btn-order-ctrl">
                            <button id="testJihun" class="btn btn-success" value="주문하기">주문하기</span></button>	
                            <a href="${ pageContext.servletContext.contextPath }" class="btn_large  btn_color">계속 쇼핑하기</a>
                            <a href="javascript:basket_clear();" class="btn_large btn_color">장바구니 비우기</a>
                            
                        </div>
<div class="order_pay" style="margin-top: 10px; text-align:center;"></div>











                    


                    </div><!-- .page-body -->
                </div><!-- #cartWrap -->

          </div><!-- #contentSub -->


        </div><!-- #contentWrap -->
    </div>
    <script>
    
    $("#testJihun").click(function() {
    	
    	
    	
    	location.href = "${ pageContext.servletContext.contextPath }/basket/payment?no=" + "${ requestScope.detailInfo.no }" + "&count=" +"${ param.count }" ; 
    	 
/*                 	 $.ajax({
    		url : "${ pageContext.servletContext.contextPath }/testJihun/test",
    		type : "get",
    		data : {
    			jihunTest : "${ requestScope.detailInfo.no }"
    		},
    		success : function(data, textStatus, xhr) {
    			console.log('성공쓰');
    		},
    		error : function(xhr, status, error) {
    			console.log('실패');
    		}
    	});  */
    	
    });
    </script>
    
    		<jsp:include page="../common/footer.jsp"/>

</body>
</html>