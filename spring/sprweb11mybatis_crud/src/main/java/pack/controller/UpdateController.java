package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemDaoInter;
import pack.model.MemDto;

@Controller
public class UpdateController {

	@Autowired
	private MemDaoInter daoInter;

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView up(@RequestParam("num") String num) {
		MemDto dto = daoInter.selectPart(num);
		return new ModelAndView("upform", "dto",dto); // 수정화면용 jsp를 forward 방식으로 호출 (서버에서 서버의 파일을 직접 호출 후 클라이언트에 전송)
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String submit(MemBean bean) {
		System.out.println(bean.getNum() + " " + bean.getName() + " " + bean.getAddr());

		boolean b = daoInter.updateData(bean);
		if (b) {
			return "redirect:/list"; // 수정 후 회원보기로 이동. 클라이언트를 통해 서버에게 파일을 요청
		} else {
			return "redirect:/error";
		}

	}

}
