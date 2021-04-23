package gdu.diary.service;

public class GuGuService {
	public String getGuGu() {
		StringBuffer sb = new StringBuffer();
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				sb.append(i+"X"+j+"="+i*j+"\t");
			}
			sb.append("\n");
		}
		return getGuGu();
	}
}
