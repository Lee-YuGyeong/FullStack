package aa.bb.ex;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ScoreController {

	@Autowired
	private ScoreModel scoreModel;
	
	@RequestMapping(value="score",method = RequestMethod.POST)
	public ModelAndView view(ScoreBean scoreBean) {

		ModelAndView andView = new ModelAndView("result");
		andView.addObject("total",scoreModel.totalCal(scoreBean));
		andView.addObject("avg",scoreModel.avgCal(scoreBean));
		return andView;
		
	}
	
}
