package com.jihunh.jsp.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jihunh.jsp.common.wrapper.EncodePwd;
import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.member.model.service.MgService;
 

@WebServlet("/change/memberPwd")
public class MypageChangeMemberPwd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/mypage/changeMemberPwd.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MgDTO testPwd = new MgDTO();
		testPwd.setId(((MgDTO) request.getSession().getAttribute("loginMember")).getId());
		testPwd.setPwd(request.getParameter("pwd1"));
		String pwd2 = request.getParameter("pwd2");
		String pwd3 = request.getParameter("pwd3");
				
		int result = new MgService().changePwdCheck(testPwd);
		
		int result2 = 0;
		String message = "";
		if(result > 0) {
			
			testPwd.setPwd(new EncodePwd().EncodePwd(pwd3));
			new MgService().changePwd(testPwd);
			System.out.println("성공");
			message = "성공";
			
		} else {
			
			if(testPwd.getPwd().equals("")) {
				message = "빈값";
			} else {
				message = "불일치";
			}
			
		}
		/* ajax로 서블릿 값 전달 완료. DB에서 비밀번호 조회를 위한 MemNo로 조회 후 비교하기 */
		
		String jsonMessage = new Gson().toJson(message);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.append(jsonMessage);
		
		out.flush();
		out.close();
		
	}

}
