package com.jihunh.jsp.eugeneYi.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.admin.model.dto.AttaNoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.eugeneYi.model.DAO.TransitDAO;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitDTO;

public class TransitService {
	
	private final TransitDAO transitDAO;
	
	public TransitService() {
		transitDAO = new TransitDAO();
	}

	public TransitDTO selectTransitDetail(int no) {
		
		Connection con = getConnection();
		TransitDTO transitDetail = null;
		
		int result = transitDAO.incrementTransitCount(con, no);
		
		if(result > 0) {
			transitDetail = transitDAO.selectTransitDetail(con, no);
			
			if(transitDetail != null) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} else {
			rollback(con);
		}
		
		close(con);
		
		return transitDetail;
	}

	public TransitDTO updateTransit(TransitDTO newTransit) {
		Connection con = getConnection();

		int result = transitDAO.updateTransit(con, newTransit);

		TransitDTO updateInfo  = transitDAO.selectTransitDetail(con, newTransit.getNo());

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

}










