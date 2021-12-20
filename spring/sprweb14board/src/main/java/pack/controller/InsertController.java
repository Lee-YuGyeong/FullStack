package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pack.model.BoardDaoInter;

@Controller
public class InsertController {

	@Autowired
	private BoardDaoInter daoInter;

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String write() {
		return "insform";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String writeSubmit(BoardBean bean) {
		// bean : name, pass, mail, title, cont, bip는 이미 setter를 통해 값이 저장된 상태임
		bean.setBdate();
		int newNum = daoInter.currentMaxnum() + 1; // 새 글번호는 현재 레코드에서 가장 큰 번호를 구해 +1
		bean.setNum(newNum);
		bean.setGnum(newNum);

		boolean b = daoInter.insert(bean);
		if (b)
			return "redirect:/list?page=1";	//추가 후 목록 보기
		else
			return "redirect:/error";
	}

}
