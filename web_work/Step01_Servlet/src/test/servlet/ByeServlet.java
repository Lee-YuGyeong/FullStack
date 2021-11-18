package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByeServlet extends HttpServlet{
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //응답 인코딩 설정
      resp.setCharacterEncoding("utf-8");
      //응답 컨텐츠 type 설정 (웹브라우저에 어떤 컨텐츠를 응답할것인지 알려서 준비를 시킨다)
      resp.setContentType("text/html;charset=utf-8");
            
      //요청을한 클라이언트에게 응답할수 있는 객체의 참조값 얻어오기
      PrintWriter pw=resp.getWriter();
      pw.println("<!DOCTYPE html>");
      pw.println("<html>");
      pw.println("<head>");
      pw.println("<meta charset=\"UTF-8\">");
      pw.println("<title>bye 페이지</title>");
      pw.println("</head>");
      pw.println("<body>");
      pw.println("<h1>good bye client!</h1>");
      pw.println("<img src='images/kim1.png' alt='김구라 이미지'/>");
      pw.println("</body>");
      pw.println("</html>");
      pw.close();
   }
}







