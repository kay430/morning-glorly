package com.mg.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.member.model.service.MgService;

@WebServlet("/member/regist")
public class MemberRegist extends HttpServlet {
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String path = "/WEB-INF/views/member/registForm.jsp";
      request.getRequestDispatcher(path).forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String memberName = request.getParameter("memberName");
      String memberId = request.getParameter("memberId");
      String memberPwd = request.getParameter("memberPwd");
      String memberPno = request.getParameter("date");
      String gender = request.getParameter("gender");
      String address = request.getParameter("zipCode")
            + "$" + request.getParameter("address1")
            + "$" + request.getParameter("address2");
      String email = request.getParameter("email01")
            + "@" + request.getParameter("email02")
      		+ request.getParameter("email03");
      String phone = request.getParameter("phone01")
            + request.getParameter("phone02")
            + request.getParameter("phone03");
      String subPhone = request.getParameter("subPhone01")
    		  + request.getParameter("subPhone02")
    		  + request.getParameter("subPhone01");
      
      System.out.println(memberName);
      
      MgDTO requestMember = new MgDTO();
      requestMember.setName(memberName);
      requestMember.setId(memberId);
      requestMember.setPwd(memberPwd);
      requestMember.setPno(memberPno);
      requestMember.setGender(gender);
      requestMember.setAddress(address);
      requestMember.setEmail(email);
      requestMember.setPhone(phone);
      requestMember.setSubPhone(subPhone);
      
      System.out.println("memberController requestMember : " + requestMember);
      
      /* 매번 쓰기 번거로워서 필터로 이동하여 한번에 처리했다. */
//      ConfigLocation.CONNECTION_CONFIG_LOCATION = request.getServletContext().getRealPath("/")
//            + "/WEB-INF/config/connection-info.properties";
      
      int result = new MgService().registMember(requestMember);
      
      String path = "";
      if(result > 1) {
         path = "/WEB-INF/views/main/success.jsp";
         request.setAttribute("successCode", "insertMember");
      } else {
         path = "/WEB-INF/views/common/failed.jsp";
         request.setAttribute("message", "회원 입구컷");
      }
      
      request.getRequestDispatcher(path).forward(request, response);
   }


}