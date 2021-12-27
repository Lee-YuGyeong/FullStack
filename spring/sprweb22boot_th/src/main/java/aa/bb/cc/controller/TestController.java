package aa.bb.cc.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "thleaf")
public class TestController {
	@GetMapping("/ex1")
	public String abc(Model model) {
		ItemDto dto = new ItemDto();
		dto.setId("ks1");
		dto.setName("마우스");
		dto.setPrice(5000);
		dto.setRegTime(LocalTime.now());

		model.addAttribute("dto", dto);
		return "show1";
	}

	@GetMapping("/ex2")
	public ModelAndView abc2() {
		List<ItemDto> list = new ArrayList<ItemDto>();

		for (int i = 1; i <= 3; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks"+i);
			dto.setName("마우스"+i);
			dto.setPrice(5000*i);
			dto.setRegTime(LocalTime.now());
			list.add(dto);
		}

		ModelAndView andView = new ModelAndView("show2");
		andView.addObject("dtos", list);

		return andView;
	}
}