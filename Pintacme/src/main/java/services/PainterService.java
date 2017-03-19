package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Customer;
import domain.Painter;
import repositories.PainterRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class PainterService {

	@Autowired
	private PainterRepository painterRepository;

	public PainterService() {
		super();
	}
	
	public Painter getPainterByUsername(String username) {
		return painterRepository.getPainterByUsername(username);
	}
	
	public Painter getLogged() {
		Painter result;
		UserAccount user;
		user = LoginService.getPrincipal();
		result = getPainterByUsername(user.getUsername());
		return result;
	}
}
