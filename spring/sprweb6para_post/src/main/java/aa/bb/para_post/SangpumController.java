package aa.bb.para_post;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SangpumController {

	@Autowired
	private SangpumModel sangpumModel;
	
	@RequestMapping(value="sangpum",method = RequestMethod.POST)
	public ModelAndView aaa(SangpumBean bean) {
		System.out.println(bean.getSang() + " " +bean.getSu()+" "+bean.getDan());
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("지찬");
		list.add("유경");
		list.add("병욱");
		list.add("환");
		
		ModelAndView andView = new ModelAndView("result");
		andView.addObject("msg",sangpumModel.compute(bean));
		andView.addObject("team",list);
		return andView;
		
	}
}
