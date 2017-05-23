package controllers.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Discussion;
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
	public ModelAndView list() {
		ModelAndView result;			
		result = new ModelAndView("discussion/list");
		
		result.addObject("discussions",discussionService.findAll());
		result.addObject("requestUri","discussion/administrator/list.do");
			
		return result;
	}
	
	@RequestMapping(value = "/accept",method=RequestMethod.GET)
	public ModelAndView accept(@RequestParam int discussionId) {
		ModelAndView result;			
		Discussion discussion;
		
		Assert.notNull(discussionId);
		
		discussion = discussionService.findOne(discussionId);
		
		Assert.notNull(discussion);
		
		Assert.isTrue(discussion.getResolution().equals("PENDING"));
		
		discussionService.accept(discussion);

		result = new ModelAndView("redirect:list.do");
			
		return result;
	}
	
	@RequestMapping(value = "/denied",method=RequestMethod.GET)
	public ModelAndView denied(@RequestParam int discussionId) {
		ModelAndView result;			
		Discussion discussion;
		
		Assert.notNull(discussionId);
		
		discussion = discussionService.findOne(discussionId);
		
		Assert.notNull(discussion);
		
		Assert.isTrue(discussion.getResolution().equals("PENDING"));
		
		discussionService.denied(discussion);

		result = new ModelAndView("redirect:list.do");
			
		return result;
	}
	

}
