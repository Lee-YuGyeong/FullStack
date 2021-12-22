package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoInter;

@Controller
public class DeleteController {
	
	@Autowired
	private BoardDaoInter daoInter;
	
	@RequestMapping("delete")
	public String del(@RequestParam("num") String num,@RequestParam("page") String page) {
		//제대로 하려면 비번 비교 후 삭제해야한다. 수정 코드를 참조
		if(daoInter.delete(num)) return "redirect:/list?page="+page;
		else return "redirect:/error";
	}
	
}
