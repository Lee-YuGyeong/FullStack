package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NiceController {
	@RequestMapping("nice")
	public ModelAndView mbc() {
		ModelAndView andView = new ModelAndView("list");
		andView.addObject("say","흠 느낌 있는데");
		andView.addObject("msg","자신감 뿜뿜");
		return andView;
	}
}
