package com.jihunh.jsp.admin.model.product.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.admin.model.product.model.dao.MgGoodsDAO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsTypeDTO;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
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

}
