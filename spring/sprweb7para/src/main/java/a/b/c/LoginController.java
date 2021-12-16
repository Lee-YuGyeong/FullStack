package a.b.c;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "kbs/login", params = "type=admin")
	public ModelAndView aa() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("show");
		andView.addObject("msg", "관리자로 로그인 했어요");
		return andView;
	}

	@RequestMapping(value = "kbs/login", params = "type=user")
	public ModelAndView bb() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("show");
		andView.addObject("msg", "일반인으로 로그인 했어요");
		return andView;
	}

	@RequestMapping(value = "kbs/login", params = "!type")
	public ModelAndView cc() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("show");
		andView.addObject("msg", "type 인자가 없군요");
		return andView;
	}

	// 요청 URL에 일부를 정보로 판단해 변수로 받아 처리
	@RequestMapping(value = "mbc/{url}")
	public ModelAndView dd(
			@PathVariable String url,
			@RequestParam("name") String name) {
		//System.out.println(url + " " + name);
		String ss = "url : " + url;
		
		ModelAndView andView = new ModelAndView();
		andView.setViewName("show");
		
		if(url.equalsIgnoreCase("korea")) {
			andView.addObject("msg", ss + " " + name + "님");
		}else if(url.equalsIgnoreCase("usa")) {
			andView.addObject("msg", ss + " " + name + "씨");
		}else {
			andView.addObject("msg"," 기타");
		}

		return andView;
	}
	
	// 요청 URL에 일부를 정보로 판단해 변수로 받아 처리
	@RequestMapping(value = "ent/{co}/singer/{singer}")
	public ModelAndView dd(
			@PathVariable String co,
			@PathVariable String singer,
			@RequestParam("title") String title) {

		String datas = "소속사 : " + co + ", 가수:" +singer +", 타이틀 : "+title;
		
		ModelAndView andView = new ModelAndView();
		andView.setViewName("show");
		andView.addObject("msg",datas);

		return andView;
	}

}
