package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
import pack.model.BoardDto;

@Controller
public class SearchController {

	@Autowired
	private BoardDao dao;

	@RequestMapping("search")
	public ModelAndView search(BoardBean bean) {
		List<BoardDto> list = dao.search(bean.getSearchName(), bean.getSearchValue());

		return new ModelAndView("list", "list", list);
	}

}
