package aa.bb.cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	//@Qualifier("helloModel") 필요없다
	private HelloModel helloModel;
	
	@RequestMapping("hello")
	public ModelAndView hi() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("list");
		//andView.addObject("msg","졸면 안돼~");
		andView.addObject("msg",helloModel.getHi());
		
		return andView;
	}
	
}
