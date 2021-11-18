package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  /hello 요청에 대해 응답할 객체를 생성할 클래스 정의하기
 *  
 *  1. HttpServlet 클래스를 상속받는다.
 *  2. service() 메소드를 오버라이드 한다.
 *  3. service() 메소드 안에 원하는 동작을 코딩한다.
 *  4. WEB-INF/web.xml 문서를 Generate 한다.
 *  (프로젝트에 마우스 우클릭 => Java EE Tools => Generate Deployment Descriptor Stub 선택)
 *  5. web.xml 문서안에 우리가 만든 HelloServlet이 어떤 경로 요청이 왔을 때 동작을 할지 설정(맵핑)을 한다.
 */
public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트에게 문자열을 출력할 수 있는 객체의 참조값 얻어오기
		PrintWriter pw = resp.getWriter();
		//문자열 두줄 출력하기
		pw.println("hi client");
		pw.println("What are you want?");
		pw.close();
	}
	
}
