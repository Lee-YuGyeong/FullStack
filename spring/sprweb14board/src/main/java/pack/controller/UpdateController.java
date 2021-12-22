package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;
import pack.model.BoardDto;

@Controller
public class UpdateController {

	@Autowired
	private BoardDaoInter daoInter;

	@RequestMapping(value="update", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("num") String num, @RequestParam("page") String page) {
		//수정할 자료 읽기
		BoardDto dto = daoInter.getDetail(num);
		
		ModelAndView andView = new ModelAndView("update");
		andView.addObject("page",page);
		andView.addObject("data", dto);
		return andView;
	}

	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView editSubmit(BoardBean bean,
			 @RequestParam("page") String page) {
		//비밀번호 일치여부 체크 후 정상이면 수정 아니면 에러 메세지 전달
		String pass = daoInter.selectPass(Integer.toString(bean.getNum()));	//해당 레코드의 비밀번호 읽기
		
		ModelAndView view = new ModelAndView();
		if(pass.equals(bean.getPass())) {
			//수정 작업을 진행
			boolean b = daoInter.update(bean);
			if(b) {
				//view.setViewName("redirect:/list?page="+page); //수정 후 목록보기로 이동
				view.setViewName("redirect:/detail?num="+bean.getNum()+"&page="+page);//수정 후 상세보기로 이동
			}else {
				view.setViewName("redirect:/error");
			}
		}else {
			view.setViewName("update");
			view.addObject("msg", "비밀번호 불일치");
			view.addObject("page", page);
		}
		return view;
	}
}
