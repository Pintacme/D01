package controllers.administrator;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import services.CustomerService;
import services.PainterService;



import controllers.AbstractController;
import domain.Painter;

@Controller
@RequestMapping("/dashboard/administrator")
public class DashBoardAdministratorController extends AbstractController {
	
	// Constructors -----------------------------------------------------------

	public DashBoardAdministratorController() {
			super();
	}

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PainterService painterService;
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
			ModelAndView result;
			
			Double avgAgeCustomer;
			Collection<Object> ratioManWoman;
			Collection<Painter> getPaintersOrderByAverageStart;
			
			avgAgeCustomer = this.customerService.avgAgeCustomer();
			ratioManWoman = this.customerService.ratioManWoman();
			getPaintersOrderByAverageStart = this.painterService.getPaintersOrderByAverageStart();
			
			result = new ModelAndView("administrator/dashboard");
			result.addObject("avgAgeCustomer", avgAgeCustomer);
			result.addObject("ratioManWoman", ratioManWoman);
			result.addObject("getPaintersOrderByAverageStart", getPaintersOrderByAverageStart);

			
			return result;
			
	}
	
	
}
