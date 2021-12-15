package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
public class WorldController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WorldController 실행");

		ModelAndView andView = new ModelAndView();
		andView.setViewName("list2");
		andView.addObject("msg","두번째 요청에 대한 처리 완료");
		return andView;
	}
}
*/
@org.springframework.stereotype.Controller
@RequestMapping("world")
public class WorldController{
	//@RequestMapping("world")	//get, post 모두 처리
	//@RequestMapping(value= "world", method=RequestMethod.GET)	//get만 처리
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView bb() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("list2");
		andView.addObject("msg","두번째 요청에 대한 처리 완료(Anno) - get");
		return andView;
	}
	
	//@RequestMapping(value= "world", method=RequestMethod.POST)	//get만 처리
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cc() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("list2");
		andView.addObject("msg","두번째 요청에 대한 처리 완료(Anno) - post");
		return andView;
	}
}