package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test/save")
public class SaveServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String nick=req.getParameter("nick");
		//session scope 에 저장하기 (어떻게 저장하지?)
		HttpSession session=req.getSession();
		session.setAttribute("nick", nick);
		
		/*
		 *  클라이언트에게 특정 경로로 요청을 다시하라는 응답
		 *  
		 *  redirect 이동
		 */
		
		//context 경로를 HttpServletRequest 객체의 메소드를 이용해서 얻어온다. 
		String cPath=req.getContextPath();
		//요청을 다시하라는 응답을 한다. 
		resp.sendRedirect(cPath+"/index.jsp");
	}
}



























