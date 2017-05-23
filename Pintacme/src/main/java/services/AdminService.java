package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Administrator;
import repositories.AdminRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;


	public AdminService() {
		super();
	}
	
	public Administrator getLogged() {
		Administrator result;
		UserAccount user;
		user = LoginService.getPrincipal();
		result = getAdministratorByUsername(user.getUsername());
		return result;
	}
	
	public Administrator getAdministratorByUsername(String username) {
		return adminRepository.getAdministratorByUsername(username);
	}
}
