package com.mg.jsp.member.model.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mg.jsp.admin.model.dao.MemberDAO;
import com.mg.jsp.admin.model.dto.MemberModifyDTO;
import com.mg.jsp.member.model.dao.MgDAO;
import com.mg.jsp.member.model.dto.MgDTO;

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

	public MgDTO findId(MgDTO requestMember) {
		Connection con = getConnection();

		MgDTO memberInfo = null;


		System.out.println("리퀘스트멤버 겟넹ㅁ " + requestMember.getName());


		memberInfo = mgDAO.selectMemberInfo(con,requestMember);
		System.out.println("이름가지고왔니2" + memberInfo);

		close(con);

		return memberInfo;
	}

	public int findPwd(MgDTO requestMember) {
		Connection con = getConnection();
		
		MgDTO memberInfo2 = null;
		
		System.out.println("왓니 서비스");
		
		/*
		 * memberInfo2 = mgDAO.findPwd(con, requestMember);
		 * System.out.println(memberInfo2);
		 */
		
		int result = mgDAO.updatePwd(con,requestMember);
		
		if(result > 0) {
			commit(con);
		}else {
		rollback(con);
		}
		return result;
	}

	public int deleteMember(MgDTO requestMember) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원의 비밀번호 조회 */
		String encPwd = mgDAO.selectEncryptPwd(con, requestMember);
		
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			/* 3. 비밀번호가 일치하면 회원 정보 삭제 */
			result = mgDAO.deleteMember(con, requestMember);
		}
		
		/* 4. 트랜젝션 제어 */
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public MgDTO updateMember(MgDTO changeInfo) {
		
		Connection con = getConnection();
		
		MgDTO changedMember = null;
		
		String encPwd = mgDAO.selectEncryptPwd(con, changeInfo);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(changeInfo.getPwd(), encPwd)) {
			
			int result = mgDAO.updateMember(con, changeInfo);
			
			changedMember = mgDAO.selectLoginMember1(con, changeInfo);
			System.out.println(result);
			if(result > 0 && changedMember != null) {
				commit(con);
			} else {
				rollback(con);
			}
		}
		
		close(con);
		return changedMember;
	}

	public MemberModifyDTO changePwdCheck(MgDTO requestMember) {

		Connection con = getConnection();
		
		MemberModifyDTO mgModi = null;
		
		/* 1. DB에 저장된 회원 아이디와 일치하는 회원ㅇ늬 비밀번호 조회 */
		String encPwd = mgDAO.selectEncryptPwd(con, requestMember);
		
		System.out.println("encPwd : " + encPwd);
		System.out.println("비밀번호 전달 받았나? : " + requestMember.getPwd());
		
		/* 2. 파라미터로 전달받은 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			mgModi = new MemberModifyDTO();
			mgModi.setOriginInfo(encPwd);
		} else {
			System.out.println("null이 드가려나?ㄴ");
		}
		
		close(con);
		
		System.out.println(mgModi);
		
		return mgModi;

	}
	
	public int changePwd(MgDTO changeInfo, MemberModifyDTO mgModis) {
		
		Connection con = getConnection();
		
		int result = mgDAO.changePwd(con, changeInfo);
		
		int result2 = 0;
		
		if(result > 0) {
			result2 = new MemberDAO().insertMgModify(con, mgModis);
				if(result2 > 0) {
					commit(con);
				} else {
					rollback(con);
				}
					
		} else {
			rollback(con);
		}
		close(con);
		
		return result2;
	}

	public int memIdOverlap(String id) {
		
		Connection con = getConnection();
		
		int result = mgDAO.memIdOverlap(con, id);
		
		close(con);
		
		return result;
	}

	public int memEmailOverlap(String emailOverlap) {
		
		Connection con = getConnection();
		
		int result = mgDAO.memEmailOverlap(con, emailOverlap);
		
		close(con);
		
		return result;
	}


}


