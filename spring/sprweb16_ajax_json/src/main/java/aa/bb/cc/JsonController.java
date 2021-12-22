package aa.bb.cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("list")
public class JsonController {
	@Autowired
	private MyModel myModel;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public MyModel getJson(@RequestParam("name") String name) {
		//고의적으로 처리시간 지연
		/*
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		myModel.setName(name);
		myModel.setSkills(new String[] {"자바 전문 개발자","DB 관리자"});
		return myModel;
	}
}
