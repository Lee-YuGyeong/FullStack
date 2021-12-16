package aa.bb.cc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.pack.model.DataDao;
import kr.pack.model.SangpumDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@RequestMapping("testdb")
	public ModelAndView listProcess() {
		ArrayList<SangpumDto> list = dataDao.getDataAll();
		return new ModelAndView("show","list",list);
	}
}
