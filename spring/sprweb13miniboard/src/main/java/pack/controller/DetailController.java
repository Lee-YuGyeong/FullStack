package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;
import pack.model.BoardDto;

@Controller
public class DetailController {

	@Autowired
	private BoardDao dao;

	@RequestMapping("detail")
	public ModelAndView search(@RequestParam("num") String num) {
		BoardDto board = dao.detail(num);

		return new ModelAndView("detail", "board", board);
	}

}
