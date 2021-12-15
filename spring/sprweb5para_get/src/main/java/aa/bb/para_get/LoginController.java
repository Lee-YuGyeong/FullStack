package aa.bb.para_get;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView submit(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		System.out.println("id : "+ id + ", password : "+ password);
		
		ModelAndView andView = new ModelAndView("login");
		
		return andView;
	}
}
*/

/*
@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView submit(
			@RequestParam("id") String id,
			@RequestParam("pwd") String password) {

		System.out.println("id : "+ id + ", password : "+ password);
		
		String data="";
		if(id.equals("aa") && password.equals("123")) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		
		ModelAndView andView = new ModelAndView("login");
		andView.addObject("msg",data);
		return andView;
	}
}
*/

/*
@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public Map<String, Object> submit(
			@RequestParam("id") String id,
			@RequestParam("pwd") String password) {

		System.out.println("id : "+ id + ", password : "+ password);
		
		String data="";
		if(id.equals("aa") && password.equals("123")) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", data);	//view file명은 정해짐(요청명이 view file명이 됨)
		
		
		return map;
	}
}
*/

@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public Model submit(Model model,
			@RequestParam("id") String id,
			@RequestParam("pwd") String password) {

		System.out.println("id : "+ id + ", password : "+ password);
		
		String data="";
		if(id.equals("aa") && password.equals("123")) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		
		
		model.addAttribute("msg",data);	//view file명은 정해짐(요청명이 view file명이 됨)
		
		
		return model;
	}
}