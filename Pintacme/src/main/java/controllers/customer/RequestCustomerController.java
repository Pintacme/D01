package controllers.customer;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import domain.Customer;
import domain.Request;
import domain.TimePreference;
import services.CustomerService;
import services.RequestService;


@Controller
@RequestMapping("/request/customer")

public class RequestCustomerController extends AbstractController {
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private CustomerService customerService;
	
	
	// Constructors -----------------------------------------------------------

	public RequestCustomerController() {
			super();
	}
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;			
		result = new ModelAndView("request/list");
			
		result.addObject("requests",requestService.findLoggedRequest());
		result.addObject("requestUri","request/customer/list.do");
			

		return result;
	}
	
	@RequestMapping(value = "/listDis",method=RequestMethod.GET)
	public ModelAndView listDiscussion() {
		ModelAndView result;			
		result = new ModelAndView("request/listDis");
			
		result.addObject("requests",requestService.findRequestBudgetAcceptedCustomerID());
		result.addObject("requestUri","request/customer/listDis.do");
			

		return result;
	}
	
		
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Request request;
	
	
		request = requestService.create();
		
		result = createModelAndView(request);
			
		return result;
	}

	// edicion -----------------------------------------
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView edit(@RequestParam int id) {
			ModelAndView result;
			Request request;
			
			Customer customer = customerService.getLogged();
			
			
			
			request=requestService.findOne(id);
			
			Assert.isTrue(request.getBudgets().isEmpty());
			
			Assert.isTrue(customer.equals(request.getCustomer()));
			Assert.notNull(request); 
			result = createEditModelAndView(request);

			return result;
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params="save")
		public ModelAndView save(@Valid Request request, BindingResult binding){
			ModelAndView result;
			Date now = new Date(System.currentTimeMillis());
				
			if(binding.hasErrors()){
				result = createEditModelAndView(request);
			}else{
				try{
					if(request.getWork().before(now)){
						result = createEditModelAndView(request, "request.work.error");
					}else{
						requestService.save(request);
						result = new ModelAndView("redirect:list.do");	
					}		
				}catch(Throwable oops){
					result = createEditModelAndView(request, "request.commit.error");
				}
			}
			return result;
		}

		@RequestMapping(value = "/create", method = RequestMethod.POST, params="save")
		public ModelAndView createSave(@Valid Request request, BindingResult binding){
			ModelAndView result;
			Date now = new Date(System.currentTimeMillis());
				
			if(binding.hasErrors()){
				result = createModelAndView(request);
			}else{
				try{
					if(request.getWork().before(now)){
						result = createModelAndView(request, "request.work.error");
					}else{
						requestService.save(request);
						result = new ModelAndView("redirect:list.do");	
					}		
				}catch(Throwable oops){
					result = createModelAndView(request, "request.commit.error");
				}
			}
			return result;
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
		public ModelAndView delete(@Valid Request Request, BindingResult binding) {
			ModelAndView result;
			try {
				requestService.delete(Request);
				result = new ModelAndView("redirect:list.do");		
			} catch (Throwable oops) {
				System.out.println(oops.getMessage());
				result = createEditModelAndView(Request, "request.commit.error");
			}

			return result;
		}

		// auxiliary------------------------------------------------------------

		protected ModelAndView createEditModelAndView(Request request){
			ModelAndView result;
			
			result = createEditModelAndView(request, null);
			
			return result;
		}
		
		protected ModelAndView createEditModelAndView(Request request, String message){
			ModelAndView result;

			List<TimePreference> timePreference = Arrays.asList(TimePreference.values());	
				
			result = new ModelAndView("request/edit");
			
			
			result.addObject("timePreference", timePreference);
			result.addObject("request", request);
			result.addObject("message", message);
			result.addObject("requestURI", "request/customer/create.do");
			
			return result;
		}
		
		protected ModelAndView createModelAndView(Request request){
			ModelAndView result;
			
			result = createEditModelAndView(request, null);
			
			return result;
		}
		
		protected ModelAndView createModelAndView(Request request, String message){
			ModelAndView result;
			

			List<TimePreference> timePreference = Arrays.asList(TimePreference.values());	

				
			result = new ModelAndView("request/edit");
			
			result.addObject("request", request);
			result.addObject("message", message);
			result.addObject("timePreference", timePreference);
			result.addObject("requestURI", "request/customer/edit.do");
			
			return result;
		}
}