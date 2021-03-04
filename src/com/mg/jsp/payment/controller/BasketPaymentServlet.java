package com.mg.jsp.payment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.admin.model.product.model.service.MgGoodsService;
import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.order.model.dto.GoodOrderDTO;
import com.mg.jsp.order.model.dto.OrderAddressDTO;
import com.mg.jsp.order.model.dto.OrderDTO;
import com.mg.jsp.order.model.dto.OrderDeliveryDTO;
import com.mg.jsp.payment.model.dto.PaymentDTO;
import com.mg.jsp.payment.model.dto.PaymentDivisionDTO;
import com.mg.jsp.payment.model.service.PaymentService;

@WebServlet("/basket/payment")
public class BasketPaymentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		MgGoodsDTO detailInfo = new MgGoodsService().selectOnedetailInfo(no);
		String MemId = ((MgDTO) request.getSession().getAttribute("loginMember")).getId();
		System.out.println("detailInfo " + detailInfo);
		MgDTO loginInfo = new PaymentService().selectMemberInfo(MemId);

		System.out.println("회원정보 " + loginInfo);

		String path = ""; 
		if(detailInfo !=null) { 
			path ="/WEB-INF/views/payment/BasketPayment.jsp";
			request.setAttribute("detailInfo", detailInfo);
			request.setAttribute("loginInfo", loginInfo);

		} else { path= "/WEB-INF/views/main/failed.jsp";
		request.setAttribute("message", "상세조회실패"); 
		}

		request.getRequestDispatcher(path).forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("==================== Map으로 꺼내온 값 =====================");
		
		Map<String, String[]> paymentInfo = new TreeMap<String, String[]>(request.getParameterMap());
		
		for(String key : paymentInfo.keySet()) {
			String[] value = paymentInfo.get(key);
			
			for(int i = 0; i < value.length; i++) {
				System.out.println((key + " : " + value[i]));
			}
			
		}
		
		/* 0-1. 데이터를 저장할 해당 테이블 DTO 생성 */
		OrderDTO order = new OrderDTO();		//최상위 DTO
		order.setMgInfo(new MgDTO());			//Login 회원 정보
		List<GoodOrderDTO> orderGoodList = new ArrayList<>();
		List<OrderAddressDTO> orderAddList = new ArrayList<>();
		List<OrderDeliveryDTO> orderDeliList = new ArrayList<>();
		List<PaymentDTO> orderPayList = new ArrayList<>();
		List<PaymentDivisionDTO> orderPayDiviList = new ArrayList<>();
		GoodOrderDTO orderGoods = new GoodOrderDTO();
		OrderDeliveryDTO orderDeli = new OrderDeliveryDTO();
		OrderAddressDTO orderAdd = new OrderAddressDTO();
		PaymentDTO orderPay = new PaymentDTO();
		PaymentDivisionDTO orderPayDivi = new PaymentDivisionDTO();
		
		/* 1. 주문 테이블 */
		order.getMgInfo().setNo(((MgDTO) request.getSession().getAttribute("loginMember")).getNo());
		order.setOrderTitle(((String[])paymentInfo.get("jihun[25][value]"))[0]);
		order.setAmountPrice(Integer.parseInt(((String[])paymentInfo.get("jihun[16][value]"))[0]));
		
		/* 2. 주문 상품 테이블 */
		orderGoods.setGoodsNo(Integer.parseInt(((String[])paymentInfo.get("jihun[17][value]"))[0]));
		orderGoods.setAmountCount(Integer.parseInt(((String[])paymentInfo.get("jihun[19][value]"))[0]));
		orderGoods.setGoodsPrice(Integer.parseInt(((String[])paymentInfo.get("jihun[18][value]"))[0]));
		orderGoodList.add(orderGoods);
		order.setOrderGoods(orderGoodList);
		
		/* 3. 주문 배송 테이블 */
		orderDeliList.add(orderDeli);
		order.setOrderDeli(orderDeliList);
		
		/* 4. 주문 배송 주소 테이블 */
		orderAdd.setAddType(((String[])paymentInfo.get("jihun[9][value]"))[0]);
		orderAdd.setRecieverName(((String[])paymentInfo.get("jihun[5][value]"))[0]);
		orderAdd.setRecieverPhone(((String[])paymentInfo.get("jihun[6][value]"))[0]
								+ ((String[])paymentInfo.get("jihun[7][value]"))[0]
								+ ((String[])paymentInfo.get("jihun[8][value]"))[0]);
		orderAdd.setRecieverAdd(((String[])paymentInfo.get("jihun[10][value]"))[0] +"$"
							 + ((String[])paymentInfo.get("jihun[11][value]"))[0] +"$"
							 + ((String[])paymentInfo.get("jihun[12][value]"))[0]);
		orderAdd.setMemNo(order.getMgInfo().getNo());
		orderAddList.add(orderAdd);
		order.setOrderAdd(orderAddList);
		
		/* 5. 결제 테이블 */
		orderPay.setMgInfo(new MgDTO());
		orderPay.getMgInfo().setNo(orderAdd.getMemNo());
		orderPay.setFinalPrice(Integer.parseInt(((String[])paymentInfo.get("jihun[16][value]"))[0]));
		
		/* 5-1. 포인트 사용 유무에 따른 Point 컬럼 처리 */
		if( ((String[])paymentInfo.get("jihun[28][value]"))[0].equals("") ) {
			orderPay.setUsedPoint(0);
		} else {
			orderPay.setUsedPoint(Integer.parseInt(((String[])paymentInfo.get("jihun[28][value]"))[0]));
			/* 포인트 차액 추가 */
			order.getMgInfo().setPoint((Integer.parseInt(((String[])paymentInfo.get("jihun[26][value]"))[0])) - orderPay.getUsedPoint());
			order.setExistingPoint(Integer.parseInt(((String[])paymentInfo.get("jihun[26][value]"))[0]));
		}
		orderPayList.add(orderPay);
		order.setPayment(orderPayList);
		
		/* 6. 결제 구분 테이블 - 전액 포인트 결제 유무에 따른 처리*/
		if(orderPay.getFinalPrice() == 0) {
			orderPayDivi.setAdmissionPayNo(0303); //전액 포인트 결제시 임의로 승인번호 부여함
		} else {
			orderPayDivi.setAdmissionPayNo(Integer.parseInt(request.getParameter("paySuccessNo"))); //결제 승인번호
		}
		orderPayDiviList.add(orderPayDivi);
		order.setPayDivi(orderPayDiviList);
		
		
		/* 7. 테이블 Insert */
		int result = new PaymentService().insertOrderResult(order);
		
		/* 8. Insert 성공 여부에 따른 출력 message 입력*/
		String message = "";
		if(result > 8) {
			message = ((String[])paymentInfo.get("jihun[0][value]"))[0] + "님의 " 
		+ orderPay.getFinalPrice() + "원 결제가 완료되었습니다.";
			System.out.println("최종 결과 확인");
		} else {
			message = "결제 처리 중 내부 오류 발생";
			System.out.println("최종 실패");
		}
		
		
		String jsonString = new Gson().toJson(message);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.append(jsonString);
		out.flush();
		out.close();
		
	}

}





























/* 시간 받기 */
//		java.sql.Date jihun = java.sql.Date.valueOf(((String[])paymentInfo.get("jihun[28][value]"))[0]);
//		System.out.println("일단 변수로 지정한거 : " + jihun);
//		order.setOrderDate(java.sql.Date.valueOf(((String[])paymentInfo.get("jihun[28][value]"))[0]));
//		System.out.println("바로 담은 시간 : " + order.getOrderDate());
//		System.out.println("시간 타입 확인 : " + order.getOrderDate().getClass().getName());

/* 결제정보 하나씩 출력하기
 * String payId = request.getParameter("payId"); String payStore =
 * request.getParameter("payStore"); String payAmount =
 * request.getParameter("payAmount"); int paySuccessNo =
 * Integer.parseInt(request.getParameter("paySuccessNo"));
 * 
 * System.out.println("payId : " + payId); System.out.println("payStore : " +
 * payStore); System.out.println("payAmount : " + payAmount);
 * System.out.println("paySuccessNo : " + paySuccessNo);
 */

/* 0. Ajax로 전송받은 key, value 확인 */
/*
 * SortedMap<String,String[]> paymentInfo = Collections.synchronizedSortedMap (
 * new TreeMap<String,String[]>(request.getParameterMap()));
 * 
 * synchronized(paymentInfo) {
 * 
 * for(String key : paymentInfo.keySet()) { String[] value =
 * paymentInfo.get(key);
 * 
 * for(int i=0; i<value.length; i++) { System.out.println((key + " : " +
 * value[i])); } } }
 */