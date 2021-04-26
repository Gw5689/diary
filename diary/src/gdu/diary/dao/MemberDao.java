package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberDao {

	public String checkMemberId(Connection conn, Member member) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String checkMemberId = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.CHECK_MEMEBER_ID);
			stmt.setString(1, member.getMemberId());
			//디버깅
			System.out.println(stmt+"<-- MemberDao checkMemberId stmt");
			rs = stmt.executeQuery();
			if(rs.next()) {
				checkMemberId = rs.getString("memberId");
			}
			
		} finally {
			stmt.close();
			rs.close();
		}
		return checkMemberId;
	}
	
	public int updateMemberByKey(Connection conn, Member member) throws SQLException {
		
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_MEMBER_BY_KEY);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			// 디버깅
			System.out.println(stmt+"<-- MemberDao updateMemberByKey stmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return rowCnt;
	}
	
	public int insertMemberByKey(Connection conn, Member member) throws SQLException {
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER_BY_KEY);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			// 디버깅
			System.out.println(stmt+"<-- MemberDao insertMemberByKey stmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return rowCnt;
	}
	
	public int deleteMemberByKey(Connection conn, Member member) throws SQLException {
		//초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.DELETE_MEMBER_BY_KEY);
			stmt.setInt(1, member.getMemberNo());
			stmt.setString(2, member.getMemberPw());
			// 디버깅
			System.out.println(stmt+"<-- Member deleteMemberByKey stmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		
		return rowCnt;
	}
	public Member selectMemberByKey(Connection conn, Member member) throws SQLException {
		//초기화
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBER_BY_KEY);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			// 디버깅
			System.out.println(stmt+"<-- MemberDao selectMemberByKey stmt");
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberNo(rs.getInt("memberNo"));
				returnMember.setMemberId(rs.getString("memberId"));
			}
		} finally {
			stmt.close();
			rs.close();
		}
		
		return returnMember;
		
	}
}
