package pack.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BuserDto;
import pack.model.DataDao;

@Controller
public class BuserController {

	@Autowired
	private DataDao dataDao;
	
	/*
	@RequestMapping("buserinfo")
	public ModelAndView buserProcess() {
		//List<BuserDto> blist = dataDao.buserList();
		//return new ModelAndView("list","blist",blist);
	
	}
	*/
	
	
	//로그인 처리한 경우만 자료 보기
	@RequestMapping("buserinfo")
	public ModelAndView buserProcess(HttpSession session) {
		
		if(session.getAttribute("idkey")==null) {
			return new ModelAndView("redirect:/login");
		}else {
			List<BuserDto> blist = dataDao.buserList();
			return new ModelAndView("list","blist",blist);
		}

		
		
	}
}
