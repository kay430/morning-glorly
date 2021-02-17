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
	href="/mg/resources/css/homepagepolicy.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/mg/resources/css/main-common.css">
</head>

<body>

	<jsp:include page="../common/header.jsp" />

	<div id="page-wrapper">
		<!-- 사이드바 -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> 고객센터</a></li>
				<li><a href="#">이용약관</a></li>
				<li><a href="#">개인정보취급방침</a></li>
				<li><a href="#">이용안내 </a></li>
			</ul>
		</div>

		<!-- /사이드바 -->

		<!-- 본문 -->
		<h1>개인정보 취급방침에 대한 안내</h1>
		<hr>
		<div>
			<table border="1px">
				<tr>
					<th class="pcyth">주문접수 및 결제 안내</th>
					<td colspan="6" class="pcytd">주문접수.<br>주문접수는 홈페이지를 통해 24시간 가능합니다<br>
						<br>결제수단.<br> 현재 카드 결제만 가능합니다.
					</td>

				</tr>
				<tr>
					<th class="pcyth">주문 수정및 주문 완료안내</th>
					<td colspan="6" class="pcytd">주문수정.<br>모든 주문 수정은 배송되기 하루전 접수된 요청만 수정이
						가능합니다.<br>
					<br> 배송지수정.<br> 배송지수정은 고객센터(1600-0000)과 게시판 통해 가능합니다.<br>
					<br> 주문완료.<br> 모든 주문완료는 구매후 정상적으로 주문확인이 된 주문만 완료처리됩니다<br>
					</td>
				</tr>
				<tr>
					<th class="pcyth">배송일정 및 배송안내</th>
					<td colspan="6" class="pcytd">배송일정<br> 배송 일정은 주문완료 후 1일 후부터 배송 가능하며 특별히
						배송일을 기재해주시지 않으시면 주문완료 후 가장 빠른 날부터 배송이 됩니다. <br>
					<br> 배송안내.<br> - 택배배송<br> 택배사 물류 사정에 따라 매일 상이 / 배송방법
						: 아이스박스
					</td>
				</tr>
				<th class="pcyth">교환 및 반품안내</th>
				<td colspan="6" class="pcytd">오배송 및 식단불량의 경우<br> 당일 식단 전체에 대해 오배송 및
					식단불량의 경우 : 교환 및 반품 중의 모든 비용을 슬림쿡이 부담하며 하루분을 연장해서 배송<br>
				<br> 당일 식단 중 끼니 하나가 오배송 및 식단불량의 경우 : 교환 및 반품 중의 모든 비용은 슬림쿡 부담하며
					끼니 하나에 대해서 재배송<br>
				<br> 고객 변심에 의해 교환 및 반품 할 경우<br> 교환 : 교환과정의 모든 금액은 고객님께서
					부담하셔야 합니다.(택배비포함)<br> 반품 : 반품과정의 모든 금액은 고객님께서 부담하셔야
					합니다.(택배비포함)<br>
				<br> 교환 및 반품이 불가능한 경우<br> 이미 개봉이 되어버린 식단의 경우는 식단불량한 경우를
					제외하고는 교환 및 반품이 되지 않습니다.<br> 배송을 받고 3일이 지나버린 식단의 경우는 교환 및 반품이
					되지 않습니다.
				</td>
				</tr>
				<tr>
					<th class="pcyth">주문취소 및 환불안내</th>
					<td colspan="6" class="pcytd">주문취소<br> 배송되기전 주문취소시 : 전체환불 가능<br>
						배송중 주문취소시 : 주문을 취소한 날로부터 반품받는날까지의 도시락갯수를 제외한 나머지 금액 환불<br>
					<br> ※주문취소시 주의사항※<br> 모든 식단은 각 끼니별로 환불이 이뤄지십니다.<br>
						환불금액 = 전체결제금액 - 이용식단금액(할인혜택미적용)<br> (ex. 하루식단 중 저녁식단이 오배송 및
						식단불량시 아침, 점심을 제외한 저녁식단만 환불가능.)<br>
					<br> 환불안내<br> 정상적으로 주문이 취소 되었을 경우 아래와 같이 환불 됩니다.<br>
						카드결제 : 카드대행사 통해 취소처리<br> 모든 환불은 접수일로부터 3~7일정도 시간이 소요됩니다.
					</td>
				</tr>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>