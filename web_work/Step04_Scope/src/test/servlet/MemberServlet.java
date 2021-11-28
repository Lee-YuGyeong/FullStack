package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dto.MemberDto;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //1. 회원 한명의 정보를 얻어오는 비즈니스 로직을 수행한다.
      MemberDto dto=new MemberDto(1, "김구라", "노량진"); //DB 에서 읽어온 정보라고 가정하자
      
      //2. 로직 수행 결과 모델(data) 를 request 영역(scope) 에 담는다.
      req.setAttribute("dto", dto);
      
      //3. jsp 페이지로 forward 이동해서 응답
      RequestDispatcher rd=req.getRequestDispatcher("/test/member.jsp");
      rd.forward(req, resp);
   }
}
















