
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
import domain.Request;
import repositories.RequestRepository;

@Service
@Transactional
public class RequestService {

	@Autowired
	private RequestRepository	requestRepository;
	
	@Autowired
	private CustomerService customerService;



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

	public Request findOne(final int RequestId) {
		Assert.isNull(RequestId);

		return this.requestRepository.findOne(RequestId);
	}

	public Collection<Request> findLoggedRequest() {
		Collection<Request> result = new ArrayList<Request>();
		Customer customer = customerService.getLogged();
		result = requestRepository.findLoggedRequests(customer.getId());
		return result; 
	}
}
