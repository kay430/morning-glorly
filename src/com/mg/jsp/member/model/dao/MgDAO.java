package com.mg.jsp.member.model.dao;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mg.jsp.common.config.ConfigLocation;
import com.mg.jsp.member.model.dto.MgDTO;
public class MgDAO {

	private final Properties prop;

	public MgDAO() {
		prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection con, MgDTO requestMember) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("insertMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getName());
			pstmt.setString(2, requestMember.getId());
			pstmt.setString(3, requestMember.getPwd());
			pstmt.setString(4, requestMember.getPno());
			pstmt.setString(5, requestMember.getGender());
			pstmt.setString(6, requestMember.getEmail());
			pstmt.setString(7, requestMember.getAddress());
			pstmt.setString(8, requestMember.getPhone());
			pstmt.setString(9, requestMember.getSubPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public String selectEncryptPwd(Connection con, MgDTO requestMember) {
		System.out.println("DAO에서 비번 조회하자");
		System.out.println(requestMember.getId());
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String encPwd = null;

		String query = prop.getProperty("selectEncryptPwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getId());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				encPwd = rset.getString("MEMBER_PWD");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(encPwd);
		return encPwd;
	}


	public MgDTO selectLoginMember(Connection con, MgDTO requestMember) {
		System.out.println("멤버 조회 DAO 들어왔나?");
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		MgDTO loginMember = null;

		String query = prop.getProperty("selectLoginMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getId());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				loginMember = new MgDTO();
				loginMember.setNo(rset.getInt("MEMBER_NO"));
				loginMember.setName(rset.getString("MEMBER_NAME"));
				loginMember.setId(rset.getString("MEMBER_ID"));
				loginMember.setPno(rset.getString("MEMBER_PNO"));
				loginMember.setGender(rset.getString("MEMBER_GENDER"));
				loginMember.setEmail(rset.getString("EMAIL"));
				loginMember.setAddress(rset.getString("ADDRESS"));
				loginMember.setPhone(rset.getString("PHONE"));
				loginMember.setSubPhone(rset.getString("SUB_PHONE"));
				loginMember.setPoint(rset.getInt("MEMBER_POINT"));
				loginMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginMember.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				loginMember.setBlackList(rset.getString("CHECK_BLACKLIST"));
				loginMember.setStatus(rset.getString("MEMBER_STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("LOGIN" + loginMember);
		return loginMember;
	}

	public MgDTO selectLoginMember1(Connection con, MgDTO changeInfo) {
		System.out.println("멤버 조회 DAO 들어왔나?");
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		MgDTO loginMember = null;

		String query = prop.getProperty("selectLoginMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changeInfo.getId());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				loginMember = new MgDTO();
				loginMember.setNo(rset.getInt("MEMBER_NO"));
				loginMember.setName(rset.getString("MEMBER_NAME"));
				loginMember.setId(rset.getString("MEMBER_ID"));
				loginMember.setPno(rset.getString("MEMBER_PNO"));
				loginMember.setGender(rset.getString("MEMBER_GENDER"));
				loginMember.setEmail(rset.getString("EMAIL"));
				loginMember.setAddress(rset.getString("ADDRESS"));
				loginMember.setPhone(rset.getString("PHONE"));
				loginMember.setSubPhone(rset.getString("SUB_PHONE"));
				loginMember.setPoint(rset.getInt("MEMBER_POINT"));
				loginMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginMember.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				loginMember.setBlackList(rset.getString("CHECK_BLACKLIST"));
				loginMember.setStatus(rset.getString("MEMBER_STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("LOGIN" + loginMember);
		return loginMember;
	}

	//   public String selectMemberName(Connection con, MgDTO requestMember) {
	//
	//      PreparedStatement pstmt = null;
	//      ResultSet rset = null;
	//      
	//      String Name = null;
	//      
	//      String query = prop.getProperty("selectMemberName");
	//      
	//      try {
	//         pstmt = con.prepareStatement(query);
	//         pstmt.setString(1, requestMember.getId());
	//         
	//         rset = pstmt.executeQuery();
	//         
	//         if(rset.next()) {
	//            Name = rset.getString("MEMBER_NAME");
	//         }
	//         System.out.println(Name);
	//      } catch (SQLException e) {
	//         // TODO Auto-generated catch block
	//         e.printStackTrace();
	//      } finally {
	//         close(pstmt);
	//      }
	//      
	//      return Name;
	//   }

	public MgDTO selectMemberInfo(Connection con, MgDTO requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		MgDTO memberInfo = null;
		String query = prop.getProperty("selectMemberId");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getName());
			pstmt.setString(2, requestMember.getPhone());

			rset = pstmt.executeQuery();
			System.out.println("안녕");

			if(rset.next()) {
				memberInfo = new MgDTO();

				memberInfo.setId(rset.getString("MEMBER_ID"));
				memberInfo.setName(rset.getString("MEMBER_NAME"));
				System.out.println("여기가 최종인데~~" + memberInfo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return memberInfo;
	}

	public MgDTO findPwd(Connection con, MgDTO requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		MgDTO memberInfo2 = null;

		String query = prop.getProperty("findPwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getId());
			pstmt.setString(2, requestMember.getName());
			pstmt.setString(3, requestMember.getPhone());
			pstmt.setString(4, requestMember.getEmail());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				memberInfo2 = new MgDTO();
				memberInfo2.setNo(rset.getInt("MEMBER_NO"));
				memberInfo2.setPwd(rset.getString("MEMBER_PWD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println(memberInfo2);   

		return memberInfo2;
	}

	public int updatePwd(Connection con, MgDTO requestMember) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updatePwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getPwd());
			pstmt.setString(2, requestMember.getPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection con, MgDTO requestMember) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("deleteMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestMember.getNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMember(Connection con, MgDTO changeInfo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changeInfo.getName());
			pstmt.setString(2, changeInfo.getPhone());
			pstmt.setString(3, changeInfo.getEmail());
			pstmt.setString(4, changeInfo.getAddress());
			pstmt.setInt(5, changeInfo.getNo());

			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int changePwd(Connection con, MgDTO changePwd) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("changePwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changePwd.getPwd());
			pstmt.setString(2, changePwd.getId());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int memIdOverlap(Connection con, String id) {
		
		System.out.println("DAO에서 id 조회하자");
		System.out.println(id);
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("memIdOverlap");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int memEmailOverlap(Connection con, String emailOverlap) {
		
		System.out.println("DAO에서 id 조회하자");
		System.out.println(emailOverlap);
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("memEmailOverlap");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emailOverlap);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public MgDTO selectRegistMemberSequence(Connection con, MgDTO requestMember) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectRegistMemberSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				requestMember.setNo(rset.getInt("CURRVAL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return requestMember;
	}

	public int InsertRegistMemberPoint(Connection con, MgDTO requestMember) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("InsertRegistMemberPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestMember.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


}






















