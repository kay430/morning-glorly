package com.jihunh.jsp.question.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.question.model.dao.QuestionDAO;
import com.jihunh.jsp.question.model.dto.QuestionDTO;

public class QuestionService {
	
	private final QuestionDAO questionDAO;
	
	public QuestionService() {
		questionDAO = new QuestionDAO();
	}
	
	public List<QuestionDTO> selectAllNoticeList() {
		
		Connection con = getConnection();
		
		List<QuestionDTO> questionList = questionDAO.selectAllQuestionService(con);
		
		close(con);
		
		return questionList;
	}

	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = QuestionDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

}
