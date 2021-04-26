package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.ADao;
import gdu.diary.dao.BDao;
import gdu.diary.util.DBUtil;

public class ABService {
	private DBUtil dbUtil;
	private ADao aDao;
	private BDao bDao;
	
	public void insert() {
		this.dbUtil = new DBUtil();
		this.aDao = new ADao();
		this.bDao = new BDao();
		
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			conn.setAutoCommit(false);
			// aDao, bDao 는 예외가 나지 않음 , 왜냐하면 Dao에서 catch절에서 예외를 처리했기 때문.
			aDao.insert(conn);
			bDao.insert(conn);
			// 2개 모두 성공하면 커밋 , 한개라도 실패하면 catch절로 가서 롤백
			conn.commit();
		} catch (SQLException e) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
