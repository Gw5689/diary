package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class DiaryService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	public Map<String, Object> getDiary(int memberNo ,String targetYear, String targetMonth) {
		// 타겟 년,월,일 (타겟이 없다면 오늘날짜)
		// 타겟의 1일 (날짜)
		// 타겟의 말일 -> endDay
		
	// startBlank + endDay + endBlankCount
		// 전체 셀의 갯수 ( 마지막일의 숫자보다는 크고 7로 나누어 떨어져야 한다.)
		// 1일 앞의 빈 셀의 갯수 -> startBlank
		// 숫자가 들어가야 할 셀의 갯수
		// 뒤의 빈셀의 갯수 -> endBlank -> 7 - ((startBlank+endDay)%7)
		
		Map<String, Object> map = new HashMap<String, Object>();
		Calendar target = Calendar.getInstance();
		
		
		if(targetYear != null) {
			target.set(Calendar.YEAR, Integer.parseInt(targetYear));
		}
		if(targetMonth != null) {
			target.set(Calendar.MONTH, Integer.parseInt(targetMonth));
		}
		target.set(Calendar.DATE,1);
		
		
		/*
		int numTargetMonth = 0;
		int numTargetYear = 0;
		if(targetMonth != null && targetYear != null ) {
			numTargetYear = Integer.parseInt(targetYear);
			numTargetMonth = Integer.parseInt(targetMonth);
			if(numTargetMonth == 0) {
				numTargetYear = numTargetYear-1;
				numTargetMonth = 12; 
			} else if(numTargetMonth == 13) {
				numTargetYear = numTargetYear+1;
				numTargetMonth = 1;
			}
			
			target.set(Calendar.YEAR, numTargetYear);
			target.set(Calendar.MONTH, numTargetMonth);
		}
		
			target.set(Calendar.DATE,1);
		*/
		
		// 1일 앞의 공백의 갯수
		int startBlank = target.get(Calendar.DAY_OF_WEEK)-1 ;
		
		// 말일
		int endDay = target.getActualMaximum(Calendar.DATE);
		
		// 말일 뒤에 붙는 셀의 갯수
		int endBlank = 0;
		if((startBlank + endDay) %7 !=0) { // 7로 나누어 떨어지지 않을경우에만 실행
			endBlank = 7 - (startBlank + endDay) %7;
		}
		
		// 전체 셀의 갯수
		int totalCell = startBlank + endDay + endBlank;
		
		map.put("startBlank", startBlank);
		map.put("endDay", endDay);
		map.put("endBlank", endBlank);
		map.put("targetYear", target.get(Calendar.YEAR));
		map.put("targetMonth", target.get(Calendar.MONTH));
		//map.put("totalCell", totalCell);
		
		// 2. todo 목록 가져와서 추가하기
		// 3. dday 목록 가져오기
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		List<Todo> todoList = null;
		List<Map<String, Object>> ddayList = null;
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			todoList = this.todoDao.selectTodoListByDate(conn, memberNo, target.get(Calendar.YEAR), target.get(Calendar.MONTH)+1);
			ddayList = this.todoDao.selectTodoDdayList(conn, memberNo);
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
				e.printStackTrace();
			}
		}
		map.put("todoList", todoList);
		map.put("ddayList", ddayList);
		
		return map;
		

	}
}