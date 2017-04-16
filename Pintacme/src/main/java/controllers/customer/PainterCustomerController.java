package controllers.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Invoice;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

import controllers.AbstractController;
import domain.Budget;
import domain.Customer;
import services.BudgetService;
import services.CustomerService;
import services.PainterService;
import services.RequestService;


@Controller
@RequestMapping("/painter/customer")
public class PainterCustomerController extends AbstractController{
	
	@Autowired
	private PainterService painterService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;			
		result = new ModelAndView("painter/list");
		
		Boolean res = true;
		
		Customer customer = customerService.getLogged();
			
		result.addObject("res", res);
		result.addObject("painters",painterService.findPaintersWorkedWithCustomerId(customer.getId()));
		result.addObject("requestUri","painter/customer/list.do");
			

		return result;
	}
	

}
