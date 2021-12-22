package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class DetailController {

	@Autowired
	private BoardDaoInter daoInter;

	@RequestMapping("detail")
	public ModelAndView detailProcess(@RequestParam("num") String num, @RequestParam("page") String page) {
		//상세보기 할 때 조회수 증가 후 num에 해당되는 레코드를 읽어 detail.jsp 를 호출
		//boolean b = daoInter.updateReadcnt(num);
		daoInter.updateReadcnt(num);
		
		ModelAndView andView = new ModelAndView("detail");
		andView.addObject("data",daoInter.getDetail(num));
		andView.addObject("page", page);
		return andView;
	}

}
