package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.SangpumInter;

@Controller
//@ComponentScan("pack.model")
public class ListController {

	@Autowired
	// @Qualifier()
	private SangpumInter sangpumInter;

	@RequestMapping("sanglist")
	public Model process(Model model) {
		model.addAttribute("datas",sangpumInter.list());
		return model;
	}
}
