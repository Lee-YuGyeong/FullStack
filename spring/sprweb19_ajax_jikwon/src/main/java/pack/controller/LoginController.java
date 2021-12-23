package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("idkey") == null ) {	//로그인 하지 않은 경우
			return "redirect:/login.jsp";
		}else {	//로그인 한 경우
			return "redirect:/buserinfo";
		}
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login2(HttpSession session,
						@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		if(id.equals("kor") && pwd.equals("111")) {
			session.setAttribute("idkey", id);	//30분간 세션 유지
			return "redirect:/buserinfo";
		}else {
			return "redirect:/err.jsp";
		}
		
	}
	
	
	//로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//session.invalidate();	//session 내의 모든 key를 삭제
		session.removeAttribute("idkey"); //특정 세션만 지움
		return "redirect:/index.jsp";
	}
}
