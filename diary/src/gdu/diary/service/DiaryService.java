package gdu.diary.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DiaryService {
	public Map<String, Object> getDiary(String targetYear, String targetMonth) {
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
		
		/*
		if(targetYear != null) {
			target.set(Calendar.YEAR, Integer.parseInt(targetYear));
		}
		if(targetMonth != null) {
			target.set(Calendar.MONTH, Integer.parseInt(targetMonth));
		}
		*/
		
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
			target.set(Calendar.MONTH, numTargetMonth-1);
		}
		
		
		target.set(Calendar.DATE,1);
		
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
		map.put("targetMonth", target.get(Calendar.MONTH)+1);
		//map.put("totalCell", totalCell);
		
		return map;
		

	}
}