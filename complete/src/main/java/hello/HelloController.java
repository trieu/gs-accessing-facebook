package hello;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private HelloWorldService helloWorldService;

    private Facebook facebook;

    @Inject
    public HelloController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloFacebook(Model model) {
        if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute(facebook.userOperations().getUserProfile());
        User userProfile = facebook.userOperations().getUserProfile();
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("userProfile", userProfile);

        return "hello";
    }

}
