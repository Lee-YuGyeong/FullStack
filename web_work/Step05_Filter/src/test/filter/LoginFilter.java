package test.filter;

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

//web.xml 필터 설정을 대신해서 어노테이션으로 동작하게 할 수 있다.
@WebFilter("/private/*")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1. 로그인된 클라이언트인지 확인( HttpSession이 필요 => HttpServletRequest가 필요)
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session = req.getSession();
		String id=(String)session.getAttribute("id");
		
		//2. 만일 로그인된 상태라면 관여하지 않고 요청의 흐름을 이어가면되고
		if(id!=null){
			chain.doFilter(request, response);
		}else {
			//3. 로그인된 상태가 아니라면 로그인 폼으로 리다이렉트 이동시킨다. (HttpServletResponse 필요)
			HttpServletResponse res=(HttpServletResponse)response;
			String cPath=req.getContextPath();
			res.sendRedirect(cPath+"/test/loginform.jsp");
			
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
