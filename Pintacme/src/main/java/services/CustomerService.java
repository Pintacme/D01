package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Customer;
import repositories.CurriculumRepository;
import repositories.CustomerRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;


	public CustomerService() {
		super();
	}


	public Customer getByUsername(String username) {
		return customerRepository.getByUsername(username);
	}
	
	public Customer getLogged() {
		Customer result;
		UserAccount user;
		user = LoginService.getPrincipal();
		result = getByUsername(user.getUsername());
		return result;
	}
}
