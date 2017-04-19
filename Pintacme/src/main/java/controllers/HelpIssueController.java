package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helpIssue")
public class HelpIssueController extends AbstractController {

	public HelpIssueController(){
		super();
	}
	
	@RequestMapping("show")
	public ModelAndView show() {

		return new ModelAndView("helpIssue/show");
	}
}
