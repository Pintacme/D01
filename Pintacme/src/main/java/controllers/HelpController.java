package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/help")
public class HelpController extends AbstractController {

	public HelpController(){
		super();
	}
	
	@RequestMapping("show")
	public ModelAndView show() {

		return new ModelAndView("help/show");
	}
}
