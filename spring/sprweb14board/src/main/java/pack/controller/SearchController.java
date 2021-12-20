package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;
import pack.model.BoardDto;

@Controller
public class SearchController {

	@Autowired
	private BoardDaoInter daoInter;
	
	@RequestMapping("search")
	public ModelAndView searchProcess(BoardBean bean) {
		ArrayList<BoardDto> list = daoInter.getSearch(bean);
		ModelAndView andView = new ModelAndView("list","data",list);
		andView.addObject("page","1");
		return andView;
		
	}
	
}
