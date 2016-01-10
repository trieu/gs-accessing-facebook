package hello;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private Facebook facebook;
	private ConnectionRepository repository;

	@Autowired
	private HelloWorldService helloService;

	@Inject
	public LoginController(Facebook facebook, ConnectionRepository repository) {
		this.facebook = facebook;
		this.repository = repository;
	}

	@RequestMapping("/login")
	public String index(Model model) {
		if (repository.findConnections("facebook").isEmpty() || !facebook.isAuthorized()) {
			return "redirect:/connect/facebook";
		}

		User userProfile = facebook.userOperations().getUserProfile();
		model.addAttribute("userProfile", userProfile);
		System.out.println(helloService.getHelloMessage());

		return "hello";
	}


}
