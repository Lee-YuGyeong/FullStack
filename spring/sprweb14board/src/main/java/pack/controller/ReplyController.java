package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class ReplyController {

	@Autowired
	private BoardDaoInter daoInter;
	
	@RequestMapping(value = "reply",method = RequestMethod.GET)
	public ModelAndView reply(@RequestParam("num") String num,@RequestParam("page") String page) {
		ModelAndView andView = new ModelAndView("reply");
		andView.addObject("data",daoInter.getDetail(num));
		andView.addObject("page",page);
		return andView;
	}
	
	@RequestMapping(value = "reply",method = RequestMethod.POST)
	public String replySubmit(BoardBean bean, @RequestParam("page") String page) {
		//onum 갱신
		bean.setOnum(bean.getOnum() + 1);
		daoInter.updateOnum(bean);
		
		//댓글 저장
		bean.setBdate();
		bean.setNum(daoInter.currentMaxnum()+1); // 새글 번호
		bean.setNested(bean.getNested()+1); //들여쓰기
		
		if(daoInter.insertReply(bean)) {
			return "redirect:/list?page="+page;	//댓글 추가 후 목록 보기
		}else {
			return "redirect:/error";	
		}
	}
}
