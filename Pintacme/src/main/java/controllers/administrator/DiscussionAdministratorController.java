package controllers.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import services.DiscussionService;


@Controller
@RequestMapping("/discussion/administrator")
public class DiscussionAdministratorController extends AbstractController{
	
	@Autowired
	private DiscussionService discussionService;
	
	
	// Constructors -----------------------------------------------------------

		public DiscussionAdministratorController() {
				super();
		}
		
		
		@RequestMapping(value = "/list",method=RequestMethod.GET)
		public ModelAndView list(@RequestParam int id) {
			ModelAndView result;			
			result = new ModelAndView("discussion/list");
			
			result.addObject("discussion",discussionService.findAll());
			result.addObject("requestUri","budget/customer/list.do");
				
			return result;
		}
		

}
