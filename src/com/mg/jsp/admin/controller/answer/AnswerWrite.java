package com.mg.jsp.admin.controller.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.MgAdDTO;
import com.mg.jsp.admin.model.service.MgAdService;
import com.mg.jsp.question.model.dto.QuestionAnswerDTO;
import com.mg.jsp.question.model.service.QuestionService;


@WebServlet("/admin/reply")
public class AnswerWrite extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*MgAdDTO requestMember = new MgAdDTO();
		MgAdService memberService = new MgAdService();
		MgAdDTO loginMember = memberService.loginCheck(requestMember);*/
//	
		System.out.println("요기");
		MgAdService memberService = new MgAdService();

	
		String title = request.getParameter("title");
		String replyAnswer = request.getParameter("reply");
		/*int adminNo = Integer.parseInt(request.getParameter("adminNo"));*/
		
	
		QuestionAnswerDTO questionAnswer = new QuestionAnswerDTO();
		questionAnswer.setAnsTitle(title);
		questionAnswer.setAnsBody(replyAnswer);
//		questionAnswer.setAndWriterAdminNo(adminNo);
		
		 QuestionService questionService = new QuestionService();
 	     int result =  questionService.insertQuestionAnswer(questionAnswer);
 	    
 	     System.out.println("quest : " + questionAnswer);
 	     System.out.println("result : " + result);
 	     String path = "";
 	     
 	     if(result > 0 ) {
 	    	 path = "/WEB-INF/views/main/success.jsp";
 	    	 request.setAttribute("successCode", "insertReply");
 	    
 	     }else{
 	    	 path="/WEB-INF/views/common/failed.jsp";
 	    	 request.setAttribute("message", "댓글작성실패!");
 	     }
//        SoccerVO sVo = new SoccerVO();
// 
//        sVo = (SoccerVO) session.getAttribute("sessionId");
//        
//        sVo.setCid(sVo.getId());
//        sVo.setCcontent(request.getParameter("c_content"));
//        sVo.setParentnum(Integer.parseInt(request.getParameter("pnum")));
//        
//        
//        SoccerDAO sDao = SoccerDAO.getInstance();
//        sDao.hitDown(request.getParameter("pnum"));
//        sDao.commentWrite(sVo);
//        
//        response.sendRedirect("BoardServlet?command=board_view&num="+ request.getParameter("pnum"));
    }
 
}