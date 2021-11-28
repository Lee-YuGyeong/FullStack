package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MemberDao;
/*
 *	/member/delete?num=x
 * 
 * 	와 같은 형식으로 삭제할 회원의 번호가 Get방식 파라미터로 전달이 된다.
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 *  num이라는 파라미터명으로 전송된 문자열을 읽어내서 실제 정수로 변환해서 변수에 담기
		 */
		int num = Integer.parseInt(req.getParameter("num"));
		//DB에서 삭제하기
		new MemberDao().delete(num);
		//응답하기
		//응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		//응답 컨텐츠 type 설정 (웹브라우저에 어떤 컨텐츠를 응답할것인지 알려서 준비를 시킨다)
		resp.setContentType("text/html;charset=utf-8");

		//요청을한 클라이언트에게 응답할수 있는 객체의 참조값 얻어오기
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>알림 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<script>");
		pw.println("alert('삭제했습니다!');");
		pw.println("location.href='list';");
		pw.println("</script>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
