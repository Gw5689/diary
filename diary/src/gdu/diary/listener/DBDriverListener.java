package gdu.diary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DBDriverListener implements ServletContextListener {

	// 생성자
    public DBDriverListener() {
        
    }

	// 톰캣 종료 시
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

    // 	톰캣이 켜졌을 때	
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println(this.getClass()+ "DB Driver 로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver 로딩 실패");
			e.printStackTrace();
		}
    }
	
}
