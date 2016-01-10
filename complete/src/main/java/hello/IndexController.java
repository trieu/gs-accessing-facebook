package hello;



import java.net.MalformedURLException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bican.wordpress.FilterPost;
import net.bican.wordpress.Post;
import net.bican.wordpress.Wordpress;

@Controller
public class IndexController {
	
	private Facebook facebook;
	private ConnectionRepository repository;
	
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


	@Inject
	public IndexController(Facebook facebook, ConnectionRepository repository) {
		this.facebook = facebook;
		this.repository = repository;
	}
	
	boolean isAuthorized(){
		return !repository.findConnections("facebook").isEmpty() && facebook.isAuthorized();
	}

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("==> getWordpressUsername " + vidzeoConfig.getWordpressUsername() );
		if (isAuthorized()) {
			User userProfile = facebook.userOperations().getUserProfile();
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
