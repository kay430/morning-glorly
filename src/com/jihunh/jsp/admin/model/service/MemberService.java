package com.jihunh.jsp.admin.model.service;

import java.sql.Connection;
import java.util.List;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import com.jihunh.jsp.admin.model.dao.MemberDAO;
import com.jihunh.jsp.admin.model.dto.MemberBlackListDTO;
import com.jihunh.jsp.admin.model.dto.MemberModifyDTO;
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
	
	public int viewMgBlackCount(int no) {
		
		Connection con = getConnection();
		
		int viewMgBlackCount = memDAO.viewMgBlackCount(con, no); 
		
		close(con);
		
		return viewMgBlackCount;
	}
	
	
	public int viewMgModifyCount(int no) {
		
		Connection con = getConnection();
		
		int viewMgModifyCount = memDAO.viewMgModifyCount(con, no); 
		
		close(con);
		
		return viewMgModifyCount;
	}
	
	
	public int viewMgPointCount(int no) {
		
		Connection con = getConnection();
		
		int viewMgPointCount = memDAO.viewMgPointCount(con, no); 
		
		close(con);
		
		return viewMgPointCount;
	}
	
	public MgDTO viewMemberDetailInfo(int no, SearchReadyDTO mgBlackCount, SearchReadyDTO mgModifyCount, SearchReadyDTO mgPointCount) {

		Connection con = getConnection();
		MgDTO mgDetail = null;
		
		/* 회원정보 */
		mgDetail = memDAO.viewMemberDetailInfo(con, no);
		
		/* 블랙리스트 */
		mgDetail = memDAO.viewMgBlackListlInfo(con, no, mgDetail, mgBlackCount);
		
		/* 정보변경이력 */
		mgDetail = memDAO.viewMgModifyListlInfo(con, no, mgDetail, mgModifyCount);
		
		/* 포인트변경 이력 */
		mgDetail = memDAO.viewMgPointListlInfo(con, no, mgDetail, mgPointCount);
		
		System.out.println("이건 짬뽕 맛? : " + mgDetail);
		
		if(mgDetail != null) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return mgDetail;
	}

	public String selectMgOriginalInfo(int pageNo) {
		
		Connection con = getConnection();
		
		String selectMgOriginalInfo = memDAO.selectMgOriginalInfo(con, pageNo); 
		
		close(con);

		return selectMgOriginalInfo;
	}

	public int InsertBlackList(MemberBlackListDTO mgBlack) {
		
		Connection con = getConnection();
		
		int InsertBlackList = memDAO.InsertBlackList(con, mgBlack); 
		
		if(InsertBlackList > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);

		return InsertBlackList;
	}

	public int insertMgModify(MemberModifyDTO mgModi) {
		
		Connection con = getConnection();
		
		int updateMgModify = memDAO.insertMgModify(con, mgModi); 
		
		if(updateMgModify > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);

		return updateMgModify;
	}

	public int updateMgBlackColumn(MemberBlackListDTO mgBlack, String modifyInfo) {
		
		Connection con = getConnection();
		
		int updateMgBlackColumn = memDAO.updateMgBlackColumn(con, mgBlack, modifyInfo); 
		
		if(updateMgBlackColumn > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);

		return updateMgBlackColumn;
	}
	
}
