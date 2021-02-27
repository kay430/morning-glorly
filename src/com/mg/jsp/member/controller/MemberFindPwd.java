package com.jihunh.jsp.member.controller;

import static com.jihunh.jsp.member.controller.SendupdatePwd.getEmail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.wrapper.EncodePwd;
import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.member.model.service.MgService;

@WebServlet("/member/findpwd")
public class MemberFindPwd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/member/pwdFind.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*비밀번호 찾기를 위한 멤버이름과 핸드폰 번호*/
		String memberId = request.getParameter("id");
		String memberName = request.getParameter("name");
		String phone = request.getParameter("phone").replace("-", "");
		String email = request.getParameter("email");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberName : " + memberName);
		System.out.println("phone : " + phone);
		System.out.println("email : " + email);
		
		String tempPwd = getEmail("namgyu1020@naver.com");
		String resultPwd = new EncodePwd().EncodePwd(tempPwd);
		
		MgDTO requestMember = new MgDTO();
		
		requestMember.setId(memberId);
		requestMember.setName(memberName);
		requestMember.setPhone(phone);
		requestMember.setEmail(email);
		requestMember.setPwd(resultPwd);
		
//		MgDTO updateInfo = new MgDTO();
//		 getEmail("namgyu1020@naver.com");
		
//		
//		updateInfo.setId(memberId);
//		updateInfo.setPwd(uuid);
//		
//		if(requestMember != null) {
//			
//		}
		
		
		MgService memberService = new MgService();
		int updateInfo = memberService.findPwd(requestMember);
		System.out.println("updateInfo : " + updateInfo); 
//		if(updateInfo > 0 ) {
//		
//		}else {
//			
//		}
//		System.out.println("내용다가지구왔니???" +updateInfo);
//		
		String path = "";
		if(updateInfo > 0) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "Findpwd");
		} else {
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);

		

		
		
	}

}
