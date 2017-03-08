package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.User;
import forms.UserRegistrationForm;
import repositories.UserRepository;
import security.Authority;
import security.UserAccount;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserService() {
		super();
	}

	public User create() {

		User u = new User();
		UserAccount ua = new UserAccount();
		ua.setUsername("");
		ua.setPassword("");

		Authority auth = new Authority();
		auth.setAuthority("USER");

		ua.addAuthority(auth);
		u.setUserAccount(ua);

		return u;
	}

	public User reconstruct(UserRegistrationForm urf) {

		User u = create();
		UserAccount ua = new UserAccount();
		Authority auth = new Authority();
		
		auth.setAuthority("USER");

		ua.setUsername(urf.getUsername());
		ua.setPassword(urf.getPassword());
		ua.addAuthority(auth);
		u.setUserAccount(ua);

		return u;
	}

	public void save(User u) {
		
		UserAccount ua = u.getUserAccount();
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		String pass = md5PasswordEncoder.encodePassword(ua.getPassword(), null);
		ua.setPassword(pass);
		u.setUserAccount(ua);
		
		userRepository.save(u);
	}
}
