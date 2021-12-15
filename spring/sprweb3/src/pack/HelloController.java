package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/*
public class HelloController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 실행");

		ModelAndView andView = new ModelAndView();
		andView.setViewName("list1");
		andView.addObject("msg","첫번째 요청에 대한 처리 완료");
		return andView;
	}
}
*/

@org.springframework.stereotype.Controller
public class HelloController{
	@RequestMapping({"hello","hi"})	//h*도 가능
	public ModelAndView aa() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("list1");
		andView.addObject("msg", "첫번째 요청에 대한 처리 완료");
		return andView;
	}
}