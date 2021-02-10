package com.jihunh.jsp.member.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jihunh.jsp.member.model.dao.MgDAO;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class MgService {

	private final MgDAO mgDAO;
	
	public MgService() {
		mgDAO = new MgDAO();
	}
	
	public int registMember(MgDTO requestMember) {
		
		Connection con = getConnection();
		
		int result = mgDAO.insertMember(con, requestMember);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public MgDTO loginCheck(MgDTO requestMember) {
		
		Connection con = getConnection();
		MgDTO loginMember = null;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원ㅇ늬 비밀번호 조회 */
		System.out.println("비밀번호 조회하러 가즈아");
		String encPwd = mgDAO.selectEncryptPwd(con, requestMember);
		System.out.println("조회완료 if문으로 가자");
		System.out.println("encPwd : " + encPwd);
		System.out.println("비밀번호 전달 받았나? : " + requestMember.getPwd());
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			System.out.println("if문으로 진입");
			/* 3. 비밀번호가 일치하면 회원 정보 조회 */
			loginMember = mgDAO.selectLoginMember(con, requestMember);

		}
		close(con);
		
		return loginMember;
		
	}

	
}
