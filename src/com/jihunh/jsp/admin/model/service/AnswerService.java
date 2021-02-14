package com.jihunh.jsp.admin.model.service;

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
	
	private final NoticeDAO noticeDAO;
	private final AnswerDAO answerDAO;
	
	public AnswerService() {
		noticeDAO = new NoticeDAO();
		answerDAO = new AnswerDAO();
	}
	
	/* 공지사항 전체 목록 조회용 메소드 */
	public List<AnswerDTO> selectAllNoticeList() {
		
		Connection con = getConnection();
		
		List<AnswerDTO> noticeList = answerDAO.selectAllNoticeList(con);
		
		close(con);
		
		return noticeList;
	}

	public int insertNotice(AnswerDTO newNotice) {
		
		Connection con = getConnection();
		
		int result = answerDAO.insertNotice(con, newNotice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public AnswerDTO selectNoticeDetail(int no) {
		
		Connection con = getConnection();
		AnswerDTO noticeDetail = null;
		
		int result = answerDAO.incrementNoticeCount(con, no);
		
		if(result > 0) {
			noticeDetail = answerDAO.selectNoticeDetail(con, no);
			
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

	public AnswerDTO updateNotice(AnswerDTO newNotice) {
		Connection con = getConnection();

		int result = answerDAO.updateNotice(con, newNotice);

		AnswerDTO updateInfo  = answerDAO.selectNoticeDetail(con, newNotice.getNo());

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

	public List<AnswerDTO> selectNoticeList(NoticePageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<AnswerDTO> boardList = answerDAO.selectBoardList(con, pageInfo);
		
		close(con);
		
		return boardList;
	}

}










