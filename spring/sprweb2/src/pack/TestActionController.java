package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
public class TestActionController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Controller 인터페이스를 구현하고 handleRequest를 오버라이딩함. 반환 값은 ModelAndView
		System.out.println("TestActionController 수행 ~~~~");
		//뭔가를 하다가...
		
		//return new ModelAndView("list");
		
		ModelAndView andView = new  ModelAndView();
		andView.setViewName("list");
		andView.addObject("say","비오는 초겨울 아침");
		andView.addObject("msg","스프링 세상은 오묘해~");
		//request.setAttribute("say", "비오는 초겨울 아침");	위는 이런 의미
		return andView;
	}

}
*/

@Controller		//자동으로 implements Controller 객체가 생성되고 
public class TestActionController{
	@RequestMapping("index.do")
	public ModelAndView abc() {
		ModelAndView andView = new  ModelAndView();
		andView.setViewName("list");
		andView.addObject("say","비오는 초겨울 아침 지윤 화이팅~~~~ㅠ.ㅠ~~");
		andView.addObject("msg","모두 다 성공하길 바라며...");
		return andView;
	}
}