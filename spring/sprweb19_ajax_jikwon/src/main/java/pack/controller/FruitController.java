package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FruitController {

	@RequestMapping(value="fruit",method = RequestMethod.GET)
	public ModelAndView cal(@RequestParam("name") String name,
			@RequestParam("price") int price,
			@RequestParam("quality") String quality,
			@RequestParam("count") int count) {
		
		ModelAndView andView = new ModelAndView("result");
		int cal = 0;
		if(quality.equals("상")) {
			cal = price*2;
		}else if(quality.equals("하")) {
			cal = price*1;
		}
		cal = cal*count;
		andView.addObject("cal", cal);
		return andView;
	}
	
}
