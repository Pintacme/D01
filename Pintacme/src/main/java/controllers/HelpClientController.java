package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helpClient")
public class HelpClientController extends AbstractController {

	public HelpClientController(){
		super();
	}
	
	@RequestMapping("show")
	public ModelAndView show() {

		return new ModelAndView("helpClient/show");
	}
}
