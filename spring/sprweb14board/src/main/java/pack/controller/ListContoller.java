package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.BoardDaoInter;
import pack.model.BoardDto;

@Controller
public class ListContoller {

	@Autowired
	// @Qualifier("boardDaoImpl")
	private BoardDaoInter inter;

	private int tot; // 전체 레코드 수
	private int plist = 10; // 한 페이지당 출력 행 수
	private int pageSu; // 전체 페이지 수

	public ArrayList<BoardDto> getListData(ArrayList<BoardDto> list, int page) {	//12, 1
		ArrayList<BoardDto> result = new ArrayList<BoardDto>();

		int start = (page - 1) * plist;	// 0, 5, 10
		int size = plist <= list.size() - start ? plist : list.size() - start; // 삼항 연산자 //나머지 구하기

		for (int i = 0; i < size; i++) {	//result에 페이지 넣기
			result.add(i, list.get(start + i));
		}

		return result;
	}
	
	public int getPageSu() {	// 총 페이지 수 얻기
		pageSu = tot / plist;
		if(tot%plist > 0) pageSu +=1;	//자투리 페이지 연산
		return pageSu;
	}

	@RequestMapping("list")
	public Model process(Model model, HttpServletRequest request) { // @RequestParam 도 가능
		int page = 0;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		if (page <= 0)
			page = 1;
		//System.out.println("페이지 번호 : " + page);

		//paging 처리용
		tot = inter.totalCnt();// 총 레코드 수 얻기
		
		ArrayList<BoardDto> list = inter.getList();
		ArrayList<BoardDto> result = getListData(list, page);
		
		//model.addAttribute("data", list);	//페이징 처리를 하지 않을 때 구문
		
		model.addAttribute("data", result);
		model.addAttribute("pagesu", getPageSu());
		model.addAttribute("page", page);
		return model;
	}

}
