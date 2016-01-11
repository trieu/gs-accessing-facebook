package hello;



import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;

import net.bican.wordpress.FilterPost;
import net.bican.wordpress.Post;
import net.bican.wordpress.Wordpress;

@Controller
public class IndexController {
	
	
	
	@Autowired
	private VidzeoConfig vidzeoConfig;
	public static Wordpress WP;
	
	public Wordpress getWP() throws MalformedURLException {
		if(WP == null){
			String username = vidzeoConfig.getWordpressUsername();
			String password = vidzeoConfig.getWordpressPassword();
			String xmlRpcUrl = vidzeoConfig.getWordpressXmlrpcUrl();
			WP = new Wordpress(username, password, xmlRpcUrl);
		}
		return WP;
	}


	
	boolean isAuthorized(String sessionId){
		System.out.println("facebookSession: "+LoginController.facebookSessions.get(sessionId));
		return LoginController.facebookSessions.containsKey(sessionId);
	}

	@RequestMapping( value="/", method = RequestMethod.GET)
	public String index(Model model) {
		
		String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		System.out.println("==> sessionId " + sessionId);
		model.addAttribute("sessionId", sessionId);
		if (isAuthorized(sessionId)) {
			User userProfile = LoginController.facebookSessions.get(sessionId);
			model.addAttribute("userProfile", userProfile);
			
			try {
				Wordpress WP = getWP();
				FilterPost filter2 = new FilterPost();
				filter2.setPost_type("page");
				WP.getPosts(filter2);
				java.util.List<Post> pages = WP.getPosts(filter2);
				System.out.println("\nHere are the pages:");
				for (Post pageDefinition : pages) {
					System.out.println(pageDefinition.getPost_title());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
		return "index";
	}
}
