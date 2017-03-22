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
import domain.Request;
import services.BudgetService;
import services.RequestService;


@Controller
@RequestMapping("/budget/customer")
public class BudgetCustomerController extends AbstractController{
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private BudgetService budgetService;
	
	// Constructors -----------------------------------------------------------

		public BudgetCustomerController() {
				super();
		}
		
		
		@RequestMapping(value = "/list",method=RequestMethod.GET)
		public ModelAndView list(@RequestParam int id) {
			ModelAndView result;			
			result = new ModelAndView("budget/list");
				
			result.addObject("budgets",budgetService.findBudgetsForRequestId(id));
			result.addObject("requestUri","budget/customer/list.do");
				

			return result;
		}
		
		
		
	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	 public ModelAndView accept(@RequestParam int id) {
		  ModelAndView result; 
		  
		  Budget budget;
		  int idRequest;
		  
		  budget= budgetService.findOne(id);
		  Assert.notNull(budget);
		  idRequest=budget.getRequest().getId();
		  
		  budget.setStatus("ACCEPTED");
		  
		  budgetService.save(budget);
		  
		  result = new ModelAndView("redirect:list.do?id="+idRequest);
		  
		  return result;
		
 }
	 
	 @RequestMapping(value = "/reject", method = RequestMethod.GET)
	 public ModelAndView reject(@RequestParam int id) {
	  ModelAndView result; 
	  
	  Budget budget;
	  int idRequest;
	  
	  budget= budgetService.findOne(id);
	  Assert.notNull(budget);
	  idRequest=budget.getRequest().getId();
	  
	  budget.setStatus("REJECTED");
	  
	  budgetService.save(budget);
	  
	  result = new ModelAndView("redirect:list.do?id="+idRequest);
	  
	  return result;
	 }

}
