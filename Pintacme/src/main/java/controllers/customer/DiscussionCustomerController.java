package controllers.customer;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Budget;
import domain.Customer;
import domain.Discussion;
import domain.Request;
import services.CustomerService;
import services.DiscussionService;
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
	
	
	// Constructors -----------------------------------------------------------

	public DiscussionCustomerController() {
			super();
	}
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;			
		result = new ModelAndView("discussion/list");
		
		Customer customer = customerService.getLogged();
		
		result.addObject("discussions",discussionService.findAllByCustomerId(customer.getId()));
		result.addObject("requestUri","discussion/customer/list.do");
			
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int requestId) {
		ModelAndView result;
		Discussion  discussion;
		
		Assert.notNull(requestId);
		
		Request request = requestService.findOne(requestId);
		
		Assert.notNull(request);
		
		discussion = discussionService.create(request);
		
		result = createEditModelAndView(discussion);
			
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
