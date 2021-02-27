package com.mg.jsp.admin.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mg.jsp.admin.model.dto.MemberBlackListDTO;
import com.mg.jsp.admin.model.dto.MemberModifyDTO;
import com.mg.jsp.admin.model.service.MemberService;
import com.mg.jsp.member.model.dto.MgDTO;

@WebServlet("/admin/member/manage/updateBlackList")
public class UpdateMemberBlackList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reason = request.getParameter("reason");
		String status = request.getParameter("status");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int adminNo = Integer.parseInt(request.getParameter("loginNo"));
		
		/* 1. 블랙리스트 등록 */
		MemberBlackListDTO mgBlack = new MemberBlackListDTO();
		mgBlack.setMgNo(new MgDTO());
		mgBlack.getMgNo().setNo(pageNo);
		mgBlack.setStatus(status);
		mgBlack.setReasonInfo(reason);
		int result1 = new MemberService().InsertBlackList(mgBlack);
		
		String modifyInfo = "";
		if(mgBlack.getStatus().equals("Y")) {
			modifyInfo = "BLCUNS";
		} else {
			modifyInfo = "MEMBER";
		}
		
		/* 2. 정보수정이력 변경 */
		MemberModifyDTO mgModi = new MemberModifyDTO();
		mgModi.setMgNo(new MgDTO());
		mgModi.setColumn("CHECK_BLACKLIST");
		mgModi.setOriginInfo(new MemberService().selectMgOriginalInfo(pageNo));
		mgModi.setModifyInfo(modifyInfo);
		mgModi.getMgNo().setNo(pageNo);
		System.out.println("가져온값 : " + mgModi);
		int result2 = new MemberService().insertMgModify(mgModi);
		
		/* 3. 회원 정보 변경 */
		int result3 = new MemberService().updateMgBlackColumn(mgBlack, modifyInfo);
		System.out.println("회원정보 변경 결과 : " + result3);
		
		int result4 = result1 + result2 + result3;
		if(result4 > 2) {
			String jsonString = new Gson().toJson(mgModi);
			PrintWriter out = response.getWriter();
			response.getWriter();
			out.append(jsonString);
			out.flush();
			out.close();
		} else {
			String path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "블랙리스트 추가 실패");
			System.out.println("어차피 여기로 못올듯?");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}









