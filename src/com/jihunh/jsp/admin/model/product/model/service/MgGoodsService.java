package com.jihunh.jsp.admin.model.product.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.admin.model.product.model.dao.MgGoodsDAO;
import com.jihunh.jsp.admin.model.product.model.dto.AttachmentDTO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;
public class MgGoodsService {

	private final MgGoodsDAO mgGoodsDAO;
	
	public MgGoodsService() {
		mgGoodsDAO = new MgGoodsDAO();
	}

	/*
	 * public List<MgGoodsDTO> selectAllGoods() { Connection con = getConnection();
	 * 
	 * List<MgGoodsDTO> goodsList = mgGoodsDAO.selectAllGoods(con);
	 * 
	 * close(con);
	 * 
	 * return goodsList; }
	 */
	//페이징을 위한 전체게시물 조회용 메소드
	public int selectTotalCount() {
		Connection con  = getConnection();
		
		int totalCount = mgGoodsDAO.selectTotalCount(con);
		
		close(con);
		return totalCount;
	}
	
	//startRow ~ endRow까지 조회
	public List<MgGoodsDTO> selectAllGoodsList(PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<MgGoodsDTO> goodsList1 = mgGoodsDAO.selectAllGoodsList(con, pageInfo);
		
		close(con);
		
		return goodsList1;
	}

	//검색결과의 조회용
	public int searchProductCount(String searchCondition, String searchValue) {
		
		Connection con = getConnection();
		
		int searchProductCount = mgGoodsDAO.searchProductCount(con, searchCondition, searchValue);
		
		close(con);
		
		return searchProductCount;
	}

	//게시판 검색결과 조회용 메소드
	public List<MgGoodsDTO> searchProductList(String searchCondition, String searchValue, PageInfoDTO pageInfo) {
		Connection con = getConnection();
		
		List<MgGoodsDTO> productList = mgGoodsDAO.searchProductList(con, searchCondition, searchValue, pageInfo);
		
		close(con);
		
		return productList;
	}

	public int insertThumbnail(MgGoodsDTO thumbnail) {
		
		Connection con = getConnection();
			
		int result = 0;
		

		int MgGoodsResult = mgGoodsDAO.insertThumbnailContent(con, thumbnail);
		
		int MgGoodsNo = mgGoodsDAO.selectThumbnailSequence(con);
		
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		for(int i = 0; i <fileList.size(); i++) {
			fileList.get(i).setRefGoodsNo(MgGoodsNo);
			
		}
		
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += mgGoodsDAO.insertAttachment(con,fileList.get(i));
		}
		
		if(MgGoodsResult > 0 && attachmentResult == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		close(con);
		return MgGoodsResult;
	}

}
