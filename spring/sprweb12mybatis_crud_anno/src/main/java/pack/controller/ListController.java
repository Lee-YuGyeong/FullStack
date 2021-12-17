package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pack.model.MemDaoInter;

@Controller
public class ListController {
	@Autowired
	private MemDaoInter daoInter;
	
	@RequestMapping("list")
	public ModelAndView list() {
		return new ModelAndView("list", "list", daoInter.getDataAll());
	}
}
