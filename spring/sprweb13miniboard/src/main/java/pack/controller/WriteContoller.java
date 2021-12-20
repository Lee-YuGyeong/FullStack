package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class WriteContoller {

	@Autowired
	private BoardDao dao;

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "insform";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String submit(BoardBean bean) {
		boolean b = dao.writeData(bean);

		if (b)
			return "redirect:/list";	//글 추가 후 목록보기
		else
			return "redirect:/error";	//에러 처리

	}
}
