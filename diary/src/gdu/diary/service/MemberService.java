package gdu.diary.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gdu.diary.dao.MemberDao;
import gdu.diary.dao.MemberQuery;
import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberService {
	private DBUtil dbUtil;
	private MemberDao memberDao;
	private TodoDao todoDao;
	// select 대신 get
	// insert 대신 add
	// update 대신 modify
	// delete 대신 remove
	
	// ID 중복검사 메소드
	public boolean checkMemberIdAndAddMember(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		boolean checkId = false;

		try {
			conn = this.dbUtil.getConnection();
			if(this.memberDao.checkMemberId(conn, member) != null){// 중복된 아이디가 존재, 생성불가
				System.out.println("이미 존재하는 ID 입니다.");
				checkId = false;
			} else { // 중복된 아이디가 없음, 생성 가능
				this.memberDao.insertMemberByKey(conn, member);
				checkId = true;
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			checkId = false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkId;
	}
	
	// 회원정보 수정 메소드
	public int modifyMemberByKey(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		// 초기화
		Connection conn = null;
		int returnMember = 0;
		try {
			conn = this.dbUtil.getConnection();
			returnMember = this.memberDao.updateMemberByKey(conn, member);
			conn.commit();
		} catch (SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnMember;
	}
	
	/* 회원가입 메소드
	public int addMemberByKey(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		// 초기화
		Connection conn = null;
		int returnMember = 0;
		try {
			conn = this.dbUtil.getConnection();
			returnMember = this.memberDao.insertMemberByKey(conn, member);
			conn.commit();
		} catch (SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, null, null);
		}
		return returnMember;
	}
	*/
	
	//삭제 성공하면 true , 삭제실패(롤백)하면 false
	public boolean removeMemberByKey(Member member) {
	// 생성
	this.dbUtil = new DBUtil();
	this.memberDao = new MemberDao();
	this.todoDao = new TodoDao();
	// 초기화
	Connection conn = null;
	int todoRowCnt = 0;
	int memberRowCnt = 0;
	
	try {
		conn = dbUtil.getConnection();
		todoRowCnt = this.todoDao.deleteTodoByMember(conn, member.getMemberNo());
		memberRowCnt = this.memberDao.deleteMemberByKey(conn, member);
		conn.commit(); // 예외가 발생하지 않고 정상적으로 작동한다면 실행
	} catch (SQLException e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} // try절에서 예외가 하나라도 발생한다면 롤백
		e.printStackTrace();
		return false;
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return (todoRowCnt+memberRowCnt) > 0;
	}
	
	
	// 로그인 메소드
	public Member getMemberByKey(Member member) {
		// 생성
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		// 초기화
		Connection conn = null;
		Member returnMember = null;
		
		try {
			conn = this.dbUtil.getConnection();
			returnMember = this.memberDao.selectMemberByKey(conn, member);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return returnMember;
	}
}
