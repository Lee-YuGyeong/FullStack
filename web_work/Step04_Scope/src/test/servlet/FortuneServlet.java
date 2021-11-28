package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직을 수행한다 (수행했다고 가정)
		String fortuneToday="동쪽으로 가면 귀인을 만나요.";
		//2. 로직의 수행결과 데이터(모델) 을 HttpServletRequest 객체에 속성(attribute)로 담는다.
		req.setAttribute("fortuneToday", fortuneToday);
		/*
		   * 3. jsp 페이지로 forward 이동해서 응답한다.
		   * forward 이동은 응답을 위임하는 동작이다.
		   * 응답을 위임할 때는 서블릿에 전달되었던 HttpServletRequest, HttpServletResponse 객체의
		   * 참조값을 전달해 주어야 한다.
		*/
		RequestDispatcher rd=req.getRequestDispatcher("/test/fortune.jsp");
		rd.forward(req, resp);

		
		
	}
}
