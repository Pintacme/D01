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
import domain.Request;
import services.BudgetService;
import services.CustomerService;
import services.RequestService;


@Controller
@RequestMapping("/budget/customer")
public class BudgetCustomerController extends AbstractController{
	
	@Autowired
	private CustomerService customerService;
	
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
			
			Customer customer = customerService.getLogged();
			Request request= requestService.findOne(id);
			
			Assert.isTrue(request.getCustomer().equals(customer));
			
			result.addObject("budgets",budgetService.findBudgetsForRequestId(id));
			result.addObject("requestUri","budget/customer/list.do");
				

			return result;
		}
		
	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	 public ModelAndView accept(@RequestParam int id) {
		  ModelAndView result; 
		  
		  Budget budget;
		  
		  if( id < 0)
		 		new Throwable("Bad id for budget");
		  
		  budget= budgetService.findOne(id);
		  Assert.notNull(budget);
		  
		  Customer customer = customerService.getLogged();
		  
		  Request request = budget.getRequest();
		  
		  Assert.isTrue(request.getCustomer().equals(customer));
		 
		  
		  budget.setStatus("ACCEPTED");
		  
		  budgetService.save(budget);
		  
		  budgetService.rejectedOtherBudgets(budget);
		  
		  result = new ModelAndView("redirect:display.do?id="+budget.getId());
		  
		  return result;
		
 }
	int iD;
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display(@RequestParam int id) {
		ModelAndView result;
		Budget budget;
	
		budget = budgetService.findOne(id);
		result = createEditModelAndView1(budget);
		
		iD=id;
		
		return result;
	}
	
	@RequestMapping(value = "/paymentDone", method = RequestMethod.GET)
	public ModelAndView paymentDone() {
		ModelAndView result;
		Budget budget;
	
		budget = budgetService.findOne(iD);
		result = createEditModelAndView2(budget);
		
		
		return result;
	}
	
	@RequestMapping("/makePayPaypal")
	public ModelAndView makePayPaypal() throws IOException, PayPalRESTException
	{
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");

		String accessToken = new OAuthTokenCredential("AS-SLQeckobn4OOw94wLRm07fWEXbkuOOfNNAdlO4u7POztpKvvh9lhJS9Pjxf7V0lWq5VVJOSiFENAw", "EMWXJ183KZD0nL2xZQ0sCpsgTqvhpxMyqDdUtfoxOY_gDWLEgrKIgNvO4CuWzi731aqZRkiHfdN5BMei", sdkConfig).getAccessToken();
		APIContext apiContext = new APIContext(accessToken);
		apiContext.setConfigurationMap(sdkConfig);

		Amount amount = new Amount();
		amount.setCurrency("EUR");
		
		String s = new Double(budgetService.findOne(iD).getAmount()).toString();
		
		amount.setTotal(s);

		Transaction transaction = new Transaction();
		transaction.setDescription("Pictame Service paid");
		transaction.setAmount(amount);
		

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://devtools-paypal.com/guide/pay_paypal?cancel=true");
		redirectUrls.setReturnUrl("http://ispp1617.cloud.hostnet.nl/Pintacme/budget/customer/paymentDone.do");
		payment.setRedirectUrls(redirectUrls);
		
		Payment createdPayment = payment.create(apiContext);	
		
		ModelAndView redirect=new ModelAndView("redirect:"+createdPayment.getLinks().get(1).getHref()+"&useraction=commit");
		
			return redirect;
		
		
		}

	@RequestMapping("/executePayment")
	public ModelAndView makePayPaypal(@RequestParam String PayerID, @RequestParam String paymentId) throws IOException, PayPalRESTException
	{
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		String accessToken = new OAuthTokenCredential("AS-SLQeckobn4OOw94wLRm07fWEXbkuOOfNNAdlO4u7POztpKvvh9lhJS9Pjxf7V0lWq5VVJOSiFENAw", "EMWXJ183KZD0nL2xZQ0sCpsgTqvhpxMyqDdUtfoxOY_gDWLEgrKIgNvO4CuWzi731aqZRkiHfdN5BMei", sdkConfig).getAccessToken();
		APIContext apiContext = new APIContext(accessToken);
		
		apiContext.setConfigurationMap(sdkConfig);
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		Payment payment = new Payment();
		payment.setId(paymentId);
		
		
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId(PayerID);
		payment.execute(apiContext, paymentExecute);
		
		
		//Collection<Budget> invoices=budgetService.findBudgetsByCustomerId();
		
		/*Invoice invoice=null;
		
		
		for (Invoice c :invoices){
			
			
			if(c.getDatePay()==null){
				
				invoice=c;
			}
		}
		
		invoice.setDatePay(new Date());
		
		invoiceService.save(invoice);
		
		Customer e =customerService.findByPrincipal();
		
		e.setDebtor(false);
		
		ModelAndView result =seeInvoices();
		return result;
		
		*/
		
		return null;
		
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
		
		
		//DISPLAY
		
		 protected ModelAndView createEditModelAndView1(Budget budget){
				ModelAndView result;
				
				result = createEditModelAndView1(budget, null);
				
				return result;
			}
			
			protected ModelAndView createEditModelAndView1(Budget budget, String message){
				ModelAndView result;
				
				Collection<String> priorities = new ArrayList<String>();
				
				priorities.add("ACCEPTED");
				priorities.add("PENDING");
				priorities.add("REJECTED");
					
				result = new ModelAndView("budget/display");
				
				
				result.addObject("priorities", priorities);
				result.addObject("budget", budget);
				result.addObject("message", message);
				
				return result;
			}
			
			//Payment
			
			 protected ModelAndView createEditModelAndView2(Budget budget){
					ModelAndView result;
					
					result = createEditModelAndView2(budget, null);
					
					return result;
				}
				
				protected ModelAndView createEditModelAndView2(Budget budget, String message){
					ModelAndView result;
					
					Collection<String> priorities = new ArrayList<String>();
					
					priorities.add("ACCEPTED");
					priorities.add("PENDING");
					priorities.add("REJECTED");
						
					result = new ModelAndView("budget/payment");
					
					
					result.addObject("priorities", priorities);
					result.addObject("budget", budget);
					result.addObject("message", message);
					
					return result;
				}

}
