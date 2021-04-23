package gdu.diary.dao;

public class MemberQuery {
	public final static String SELECT_MEMBER_BY_KEY;
	public final static String DELETE_MEMBER_BY_KEY; // 회원탈퇴 쿼리
	public final static String INSERT_MEMBER_BY_KEY;
	public final static String UPDATE_MEMBER_BY_KEY;
	
	// 쿼리 분리
	static { // 초기화
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		DELETE_MEMBER_BY_KEY = "DELETE FROM member WHERE member_no=? AND member_pw=PASSWORD(?)";
		INSERT_MEMBER_BY_KEY = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?,PASSWORD(?),NOW())";
		UPDATE_MEMBER_BY_KEY = "";
	}
	
	
	
}
