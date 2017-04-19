package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helpPainter")
public class HelpPainterController extends AbstractController {

	public HelpPainterController(){
		super();
	}
	
	@RequestMapping("show")
	public ModelAndView show() {

		return new ModelAndView("helpPainter/show");
	}
}
