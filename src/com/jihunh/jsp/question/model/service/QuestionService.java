package com.jihunh.jsp.question.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.question.model.dao.QuestionDAO;
import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.dto.QuestionPageInfoDTO;

public class QuestionService {
	
	private final QuestionDAO questionDAO;
	
	public QuestionService() {
		questionDAO = new QuestionDAO();
	}
	
	public List<QuestionDTO> selectAllQuestionList(QuestionPageInfoDTO QuestionPageInfo) {
		
		Connection con = getConnection();
		
		List<QuestionDTO> questionList = questionDAO.selectAllQuestionService(con, QuestionPageInfo);
		
		close(con);
		
		return questionList;
	}

	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = questionDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public QuestionDTO selectQuestionDetail(int no) {
		
		Connection con = getConnection();
		QuestionDTO questionDetail = null;
		
		int result = questionDAO.incrementQuestionCount(con, no);
		
		if(result > 0) {
			questionDetail = questionDAO.selectQuestionDetail(con, no);
			
			if(questionDetail != null) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} else {
			rollback(con);
		}
		
		close(con);
		
		return questionDetail;
	}

	public int insertQuestion(QuestionDTO newQuestion) {
		
		Connection con = getConnection();
		
		int result = questionDAO.insertQuestion(con, newQuestion);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//검색결과 조회용
	public int searchQuestionCount(String searchCondition, String searchValue) {
		
		Connection con = getConnection();
		
		int searchQuestionCount = questionDAO.searchQuestionCount(con, searchCondition, searchValue);
		
		close(con);
		
		return searchQuestionCount;
	}

	//게시판 검색결과 조회용 메소드
	public List<QuestionDTO> searchQuestionList(String searchCondition, String searchValue,
			QuestionPageInfoDTO questionInfo) {
		
			Connection con = getConnection();
			
			List<QuestionDTO> questionList = questionDAO.searchQuestionList(con, searchCondition, searchValue, questionInfo);
			
			close(con);
			
			return questionList;
	}

	public QuestionDTO updateQuestion(QuestionDTO newQuestion) {
		
		Connection con = getConnection();

		int result = questionDAO.updateQuestion(con, newQuestion);

		QuestionDTO updateQuestion  = questionDAO.selectQuestionDetail(con, newQuestion.getNo());

		System.out.println("result 값 : " + result);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return updateQuestion;
	}



}
