package aa.bb.cc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@RequestMapping(value = "member",method = RequestMethod.GET)
	public String formback() {
		return "myform";	//jsp 파일을 forwarding(해당 파일을 클라이언트 브라우저에 push)
	}
	
	@RequestMapping(value = "member",method = RequestMethod.POST)
	//public String submit(@RequestParam) 
	//public String submit(HttpServletRequest request)
	@ResponseBody	//data(자바 객체)를 클라이언트 브라우저로 전송
	public String submit(@RequestBody String formData) {	//HTTP 요청 body를 자바로 전달 받기
		System.out.println("formData : " + formData);
		return formData;
	}
}
