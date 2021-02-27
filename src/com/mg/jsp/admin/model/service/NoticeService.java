package com.jihunh.jsp.admin.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.admin.model.dao.NoticeDAO;
import com.jihunh.jsp.admin.model.dto.AttaNoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;

public class NoticeService {
	
	private final NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}

	public int insertNotice(NoticeDTO newNotice) {
		
		Connection con = getConnection();
		
		int result = noticeDAO.insertNotice(con, newNotice);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public NoticeDTO selectNoticeDetail(int no) {
		
		Connection con = getConnection();
		NoticeDTO noticeDetail = null;
		
		int result = noticeDAO.incrementNoticeCount(con, no);
		
		if(result > 0) {
			noticeDetail = noticeDAO.selectNoticeDetail(con, no);
			
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

	public NoticeDTO updateNotice(NoticeDTO newNotice) {
		Connection con = getConnection();

		int result = noticeDAO.updateNotice(con, newNotice);

		NoticeDTO updateInfo  = noticeDAO.selectNoticeDetail(con, newNotice.getNo());

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
		
		int totalCount = noticeDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
		
	}

	public List<NoticeDTO> selectNoticeList(NoticePageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<NoticeDTO> noticeList = noticeDAO.selectnoticeList(con, pageInfo);
		
		close(con);
		
		return noticeList;
	}

	public int insertThumbnail(NoticeDTO thumbnail) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		int noticeResult = noticeDAO.insertNotice(con, thumbnail);
		
		int noticeNo = noticeDAO.selectNoticeSequence(con);
		
		List<AttaNoticeDTO> fileList = thumbnail.getAttaNotiList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefNotiNo(noticeNo);
		}
		
		int attaNotiResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attaNotiResult += noticeDAO.insertAttaNotice(con, fileList.get(i));
		}
		
		if(noticeResult > 0 && attaNotiResult == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int searchNoticeCount(SearchReadyDTO searchRd) {
		
		Connection con = getConnection();
		
		int totalNoticeCount = noticeDAO.searchNoticeCount(con, searchRd); 
		
		close(con);
		
		return totalNoticeCount;
	}

	public List<NoticeDTO> searchNoticeList(SearchReadyDTO searchRd) {
		
		Connection con = getConnection();
		
		List<NoticeDTO> searchNoticeList = noticeDAO.searchNoticeList(con, searchRd);
		
		close(con);
		
		return searchNoticeList;
	}

}










