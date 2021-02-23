package com.jihunh.jsp.admin.model.service;

import java.sql.Connection;
import java.util.List;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import com.jihunh.jsp.admin.model.dao.MemberDAO;
import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class MemberService {
	
	private final MemberDAO memDAO;
	
	public MemberService() {
		memDAO = new MemberDAO();
	}

	public int totalMemberList() {
	
		Connection con = getConnection();
		
		int totalMemberList = memDAO.totalMemberList(con); 
		
		close(con);
		
		return totalMemberList;
	}

	public List<MgDTO> mainMemberList(SearchReadyDTO memberList) {
		
		Connection con = getConnection();
		
		List<MgDTO> mgList = memDAO.mainMemberList(con, memberList);
		
		close(con);
		
		return mgList;
	}

	public int totalMemberAdList() {
		
		Connection con = getConnection();
		
		int totalMemberAdList = memDAO.totalMemberAdList(con); 
		
		close(con);
		
		return totalMemberAdList;
	}

	public List<MgAdDTO> mainMemberAdList(SearchReadyDTO memberAdList) {
		
		Connection con = getConnection();
		
		List<MgAdDTO> mgAdList = memDAO.mainMemberAdList(con, memberAdList);
		
		close(con);
		
		return mgAdList;
	}

	public int searchMemberCount(SearchReadyDTO searchRd) {
		
		Connection con = getConnection();
		
		int searchMemberCount = memDAO.searchMemberCount(con, searchRd); 
		
		close(con);
		
		return searchMemberCount;
	}

	public List<MgDTO> searchMemberList(SearchReadyDTO searchRd) {
		
		Connection con = getConnection();
		
		List<MgDTO> searchMemberList = memDAO.searchNoticeList(con, searchRd);
		
		close(con);
		
		return searchMemberList;
	}

	public int searchMemberAdCount(SearchReadyDTO searchRd) {
		
		Connection con = getConnection();
		
		int searchMemberAdCount = memDAO.searchMemberAdCount(con, searchRd); 
		
		close(con);
		
		return searchMemberAdCount;
	}

	public List<MgAdDTO> searchMemberAdList(SearchReadyDTO searchRd) {
		
		Connection con = getConnection();
		
		List<MgAdDTO> mgAdList = memDAO.searchMemberAdList(con, searchRd);
		
		close(con);
		
		return mgAdList;
	}

	public MgDTO viewMemberDetailInfo(int no) {

		Connection con = getConnection();
		MgDTO mgDetail = null;

		mgDetail = memDAO.viewMemberDetailInfo(con, no);
		
		SearchReadyDTO mgBlackCount = new SearchReadyDTO();
		mgBlackCount.setPageInfo(new NoticePageInfoDTO());
		mgBlackCount.getPageInfo().setPageNo(1);
		mgBlackCount.getPageInfo().setTotalCount((memDAO.searchMgBlackCount(con, no)));
		mgBlackCount.getPageInfo().setLimit(10);
		mgBlackCount.getPageInfo().setButtonAmount(5);
		Pagenation.getSearchPage(mgBlackCount);
		
		mgDetail = memDAO.viewMgBlackListlInfo(con, no, mgDetail, mgBlackCount);
		
		System.out.println("이건 짬뽕 맛? : " + mgDetail);
		
		if(mgDetail != null) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return mgDetail;
	}
	
	
	
}
