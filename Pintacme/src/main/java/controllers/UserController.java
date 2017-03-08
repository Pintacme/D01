package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import forms.UserRegistrationForm;
import services.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	public UserController() {
		super();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {

		ModelAndView result;
		UserRegistrationForm urf = new UserRegistrationForm();
		result = createEditModelAndView(urf);
		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@ModelAttribute("urf") @Valid UserRegistrationForm urf, BindingResult binding) {

		ModelAndView result;
		User user;

		if (binding.hasErrors()) {
			if (binding.getGlobalError() != null){
				result = createEditModelAndView(urf, binding.getGlobalError().getCode());
			}else{
				result = createEditModelAndView(urf);
			}
		} else {
			try {
				user = userService.reconstruct(urf);
				userService.save(user);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = createEditModelAndView(urf, "register.commit.error");
			}
		}

		return result;
	}

	protected ModelAndView createEditModelAndView(UserRegistrationForm urf) {

		ModelAndView result;

		result = createEditModelAndView(urf, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(UserRegistrationForm urf, String message) {

		ModelAndView result = new ModelAndView("user/register");
		result.addObject("urf", urf);
		result.addObject("message", message);

		return result;
	}
}