package controllers.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Budget;
import domain.Customer;
import domain.Discussion;
import domain.Painter;
import domain.Request;
import services.CustomerService;
import services.DiscussionService;
import services.PainterService;
import services.RequestService;


@Controller
@RequestMapping("/discussion/customer")
public class DiscussionCustomerController extends AbstractController{
	
	@Autowired
	private DiscussionService discussionService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PainterService painterService;
	
	
	// Constructors -----------------------------------------------------------

	public DiscussionCustomerController() {
			super();
	}
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;			
		result = new ModelAndView("discussion/list");
		
		result.addObject("discussions",requestService.findRequestBudgetAcceptedCustomerID());
		result.addObject("requestUri","discussion/customer/list.do");
			
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int id) {
		ModelAndView result;
		Discussion  discussion;
		discussion = discussionService.create(id);
		
		result = createEditModelAndView(discussion);
			
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Discussion discussion, BindingResult binding){
		ModelAndView result;
		if(binding.hasErrors()){
			result = createEditModelAndView(discussion);
		}else{
			try{
				if(discussion.getRequest()==null){
					result = createEditModelAndView(discussion, "discussion.request.error");
				}else{
					discussionService.save(discussion);
					result = new ModelAndView("redirect:list.do");	
				}		
			}catch(Throwable oops){
				result = createEditModelAndView(discussion, "discussion.commit.error");
			}
		}
		return result;
	}
	
	 protected ModelAndView createEditModelAndView(Discussion discussion){
			ModelAndView result;
			
			result = createEditModelAndView(discussion, null);
			
			return result;
		}
		
		protected ModelAndView createEditModelAndView(Discussion discussion, String message){
			ModelAndView result;
							
			result = new ModelAndView("discussion/edit");
			
			result.addObject("discussion", discussion);
			result.addObject("message", message);
			
			return result;
		}

	

}
