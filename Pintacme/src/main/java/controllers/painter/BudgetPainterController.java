package controllers.painter;

import java.util.ArrayList;
import java.util.Collection;

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
import domain.Painter;
import domain.Request;
import services.BudgetService;
import services.PainterService;
import services.RequestService;

@Controller
@RequestMapping("/budget/painter")
public class BudgetPainterController extends AbstractController{
	
	@Autowired
	private BudgetService budgetService;
	
	@Autowired
	private PainterService painterService;
	
	@Autowired
	private RequestService requestService;
	
	// Constructors -----------------------------------------------------------

	public BudgetPainterController() {
			super();
	}
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;			
		result = new ModelAndView("budget/list");
			
		result.addObject("budgets",budgetService.findLoggedBudget());
		result.addObject("requestUri","budget/painter/list.do");
			

		return result;
	}
	
		
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int id) {
		ModelAndView result;
		Budget budget;
	
		budget = budgetService.create(id);
		result = createEditModelAndView(budget);
			
		return result;
	}

	// edicion -----------------------------------------
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView edit(@RequestParam int id) {
			ModelAndView result;
			Budget budget;
			
			Painter painter = painterService.getLogged();
			budget=budgetService.findOne(id);
			
			Assert.notNull(budget); 
			Assert.isTrue(painter.equals(budget.getPainter()));
			Assert.isTrue(budget.getStatus().equals("PENDING"));
			result = createEditModelAndView(budget);

			return result;
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params="save")
		public ModelAndView save(@Valid Budget budget, BindingResult binding){
			ModelAndView result;
			if(binding.hasErrors()){
				result = createEditModelAndView(budget);
			}else{
				try{
					Collection<Request> requestsCreateBudget = requestService.findRequestWithBudgetPainterId();
					System.out.println(requestsCreateBudget);
					if(requestsCreateBudget.contains(budget.getRequest())){
						result = createEditModelAndView(budget, "budget.commit.duplicate");
					}else{
						budgetService.save(budget);
						result = new ModelAndView("redirect:list.do");
					}
				}catch(Throwable oops){
					result = createEditModelAndView(budget, "budget.commit.error");
				}
			}
			return result;
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
		public ModelAndView delete(@Valid Budget budget, BindingResult binding) {
			ModelAndView result;
			try {
				budgetService.delete(budget);
				result = new ModelAndView("redirect:list.do");		
			} catch (Throwable oops) {
				System.out.println(oops.getMessage());
				result = createEditModelAndView(budget, "budget.commit.error");
			}

			return result;
		}

		// auxiliary------------------------------------------------------------

		protected ModelAndView createEditModelAndView(Budget budget){
			ModelAndView result;
			
			result = createEditModelAndView(budget, null);
			
			return result;
		}
		
		protected ModelAndView createEditModelAndView(Budget budget, String message){
			ModelAndView result;
			
			Collection<String> priorities = new ArrayList<String>();
			
			priorities.add("ACCEPTED");
			priorities.add("PENDING");
			priorities.add("REJECTED");
				
			result = new ModelAndView("budget/edit");
			
			
			result.addObject("priorities", priorities);
			result.addObject("budget", budget);
			result.addObject("message", message);
			
			return result;
		}

}
