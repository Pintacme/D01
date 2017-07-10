
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Budget;
import domain.Customer;
import domain.Painter;
import domain.Request;
import repositories.RequestRepository;

@Service
@Transactional
public class RequestService {

	@Autowired
	private RequestRepository	requestRepository;
	
	@Autowired
	private CustomerService customerService;
	

	@Autowired
	private PainterService painterService;



	public RequestService() {
		super();
	}

	public Request create() {
		Request request = new Request();
		
		Collection <Budget> budgets = new ArrayList<Budget>();
		
		Date moment = new Date(System.currentTimeMillis()-1000);
		
		Customer customer = customerService.getLogged();
		
		request.setCustomer(customer);
		request.setMoment(moment);
		request.setBudgets(budgets);
		
		return request;
	}

	public Request save(final Request Request) {
		Assert.notNull(Request);

		return this.requestRepository.saveAndFlush(Request);

	}
	
	public void delete(Request Request){
		Assert.notNull(Request);
		requestRepository.delete(Request);
	}

	public Request findOne(int RequestId) {
		Assert.notNull(RequestId);
		
		Request result =requestRepository.findOne(RequestId);
		
		return result;
	}

	public Collection<Request> findLoggedRequest() {
		Collection<Request> result = new ArrayList<Request>();
		Customer customer = customerService.getLogged();
		result = requestRepository.findLoggedRequests(customer.getId());
		return result; 
	}

	public Collection<Request> findRequestToBudget() {
		Collection<Request> result = new ArrayList<Request>();
		
	
		
		result = requestRepository.findRequestToBudget();
		
		return result; 
	}
	
	
	public Collection<Request> findRequestWithBudgetAccepted(){
		Collection<Request> res;
		
		res = requestRepository.findRequestWithBudgetAccepted();
		
		return res;
	}
	
	public Collection<Request> findRequestWithBudgetPainterId(){
		Collection<Request> res;
		
		Painter painter = painterService.getLogged();
		
		res = requestRepository.findRequestWithBudgetPainterId(painter.getId());
		
		return res;
	}
	
	public Collection<Request> findRequestBudgetAcceptedCustomerID(){
		Collection<Request>res;
		
		Customer customer = customerService.getLogged();
		
		res = requestRepository.findRequestBudgetAcceptedCustomerID(customer.getId());
		
		return res;
	}
	
	public Collection<Request> findRequestBudgetAcceptedCustomerIDDatePast(){
		Collection<Request>res;
		
		Customer customer = customerService.getLogged();
		
		res = requestRepository.findRequestBudgetAcceptedCustomerIDDatePast(customer.getId());
		
		return res;
	}
}
