package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import services.CustomerService;
import services.RequestService;



import controllers.AbstractController;

@Controller
@RequestMapping("/dashboard/administrator")
public class DashBoardAdministratorController extends AbstractController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RequestService requestService;
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
			ModelAndView result;			
			
			result = new ModelAndView("administrator/dashboard");
		
			//QUERYS NIVEL C:
			
//			int c1 = parentService.getNumberOfParentRegisterLastMonth();
//			result.addObject("c1", c1);
//			
//			int c2 = babysitterService.getNumberOfBabysitterRegisterLastMonth();
//			result.addObject("c2", c2);
//			
//			Object[] c3 = childrenService.findAvgMinMaxChildrenPerParent();
//			
//			double c3a = (double) c3[0];
//			result.addObject("c3a", c3a);
//		
//			int c3b = (int) c3[1];
//			result.addObject("c3b", c3b);
//			
//			int c3c = (int) c3[2];
//			result.addObject("c3c", c3c);
//		
//			double c3d = (double) c3[3];
//			result.addObject("c3d", c3d);
//
//			double c4 = babysitterService.getAverageBabysitterWithCurriculaNotRegistered();
//			result.addObject("c4", c4);
//		
//			Object[]c5 = activityService.getAvgSttdevActivityPerSession();
//			
//			double c5a = (double) c5[0];
//			result.addObject("c5a", c5a);
//		
//			double c5b = (double) c5[1];
//			result.addObject("c5b", c5b);
//			
//			Object [] c6 = babysitterService.getAverageNumberOfendorses();
//			
//			double c6a = (double) c6[0];
//			result.addObject("c6a", c6a);
//		
//			double c6b = (double) c6[1];
//			result.addObject("c6b", c6b);
//			
//			Object [] c7 = sessionService.getAvgSttdevFromSession();
//			
//			double c7a = (double) c7[0];
//			result.addObject("c7a", c7a);
//		
//			double c7b = (double) c7[1];
//			result.addObject("c7b", c7b);
//			
			return result;
			
	}
	
	
}
