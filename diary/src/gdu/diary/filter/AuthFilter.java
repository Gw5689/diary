package gdu.diary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/_auth/*")
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인이 되어있지 않은 상태에서 "/Auth/"문자로 시작하는 요청이 들어오면 redirect
		// ServletRequest의 자식 타입으로 형변환 필수 
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		//세션 검사
		if(session.getAttribute("sessionMember") == null) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
			return; //새로운 요청발생으로 필터 메소드 종료
		}
		chain.doFilter(request, response);	
	}
   
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
