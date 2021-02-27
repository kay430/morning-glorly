package com.mg.jsp.transit.model.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.mg.jsp.transit.model.DAO.TransitDAO;
import com.mg.jsp.transit.model.DTO.SearchDTO;
import com.mg.jsp.transit.model.DTO.TransitDTO;
import com.mg.jsp.transit.model.DTO.TransitPageInfoDTO;

public class TransitService {
	
	private final TransitDAO transitDAO;
	
	public TransitService() { 
		transitDAO = new TransitDAO();
	}

	public TransitDTO selectTransitDetail(int no) {
		
		Connection con = getConnection();
		TransitDTO transitDetail = null;

		transitDetail = transitDAO.selectTransitDetail(con, no);

		if(transitDetail != null) {
			commit(con);
		} else {
			rollback(con);
		}

		return transitDetail;
	}

	public TransitDTO updateTransit(TransitDTO newTransit) {
		Connection con = getConnection();

		int result = transitDAO.updateTransit(con, newTransit);

		TransitDTO updateInfo  = transitDAO.selectTransitDetail(con, newTransit.getdNo());

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
		
		int totalCount = transitDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
		
	}

	public List<TransitDTO> selectTransitList(TransitPageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<TransitDTO> transitList = transitDAO.selectTransitList(con, pageInfo);
		
		close(con);
		
		return transitList;
	}
	
	public int searchTransitCount(SearchDTO searchTransit) {
		
		Connection con = getConnection();
		
		int totalTransitCount = transitDAO.searchTransitCount(con, searchTransit); 
		
		close(con);
		
		return totalTransitCount;
	}

	public List<TransitDTO> searchNoticeList(SearchDTO searchTransit) {
		
		Connection con = getConnection();
		
		List<TransitDTO> searchTransitList = transitDAO.searchTransitList(con, searchTransit);
		
		close(con);
		
		return searchTransitList;
	}

	public List<TransitDTO> searchTransitList(SearchDTO searchTransit) {
		Connection con = getConnection();
		
		List<TransitDTO> searchTransitList = transitDAO.searchTransitList(con, searchTransit);
		
		close(con);
		
		return searchTransitList;
	}

}










