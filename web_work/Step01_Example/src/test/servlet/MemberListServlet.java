package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.MemberDao;
import test.dto.MemberDto;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
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
      pw.println("<title>회원 목록 페이지</title>");
      pw.println("<link rel='stylesheet' href='/Step01_Example/css/bootstrap.css' >");
      pw.println("</head>");
      pw.println("<body>");
      //출력할 회원 목록 얻어오기
      List<MemberDto> list=new MemberDao().getList();
      //회원목록을 html 형식으로 이쁘게 출력하기
      pw.println("<h1>회원 목록입니다.</h1>");
      pw.println("<table class='table table-striped'>");
         pw.println("<thead>");
            pw.println("<tr>");
               pw.println("<th>번호</th>");
               pw.println("<th>이름</th>");
               pw.println("<th>주소</th>");
               pw.println("<th>삭제</th>");
            pw.println("</tr>");
         pw.println("</thead>");
         pw.println("<tbody>");
         for(MemberDto tmp:list) {
            pw.println("<tr>");
               pw.println("<td>"+tmp.getNum()+"</td>");
               pw.println("<td>"+tmp.getName()+"</td>");
               pw.println("<td>"+tmp.getAddr()+"</td>");
               pw.println("<td><a href='delete?num="+tmp.getNum()+"'>삭제</a></td>");
            pw.println("</tr>");
         }
         pw.println("</tbody>");
      pw.println("</table>");
      pw.println("</body>");
      pw.println("</html>");
      pw.close();
   }
}














