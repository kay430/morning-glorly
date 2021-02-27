package com.mg.jsp.admin.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.admin.model.dao.AnswerDAO;
import com.jihunh.jsp.admin.model.dao.NoticeDAO;
import com.jihunh.jsp.admin.model.dto.AnswerDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;

public class AnswerService {
	
	private final AnswerDAO answerDAO;
	
	public AnswerService() {
		answerDAO = new AnswerDAO();
	}

	public int insertAnswer(AnswerDTO newNotice) {
		
		Connection con = getConnection();
		
		int result = answerDAO.insertAnswer(con, newNotice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public AnswerDTO selectAnswerDetail(int no) {
		
		Connection con = getConnection();
		AnswerDTO noticeDetail = null;
		
		int result = answerDAO.incrementAnswerCount(con, no);
		
		if(result > 0) {
			noticeDetail = answerDAO.selectAnswerDetail(con, no);
			
			if(noticeDetail != null) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} else {
			rollback(con);
		}
		
		close(con);
		
		return noticeDetail;
	}

	public AnswerDTO updateAnswer(AnswerDTO newNotice) {
		Connection con = getConnection();

		int result = answerDAO.updateAnswer(con, newNotice);

		AnswerDTO updateInfo  = answerDAO.selectAnswerDetail(con, newNotice.getNo());

		System.out.println("result 값 : " + result);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return updateInfo;
	}

	public int selectTotalCount() {
		
	Connection con = getConnection();
		
		int totalCount = answerDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
		
	}

	public List<AnswerDTO> selectAnswerList(NoticePageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<AnswerDTO> answerList = answerDAO.selectAnswerList(con, pageInfo);
		
		close(con);
		
		return answerList;
	}

}










