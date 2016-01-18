package vidzeo.controllers;

//@Controller
public class LoginController {

//	private Facebook facebook;
//	private ConnectionRepository repository;
//
//	@Autowired
//	private HelloWorldService helloService;
//
//	@Inject
//	public LoginController(Facebook facebook, ConnectionRepository repository) {
//		this.facebook = facebook;
//		this.repository = repository;
//	}
//	
//	public final static Map<String, User> facebookSessions = new HashMap<>();
//	
//
//	@RequestMapping("/fblogin")
//	public String login(HttpServletRequest request, Model model) {		
//		String ssid = request.getParameter("ssid");
//		System.out.println("facebookSession: "+facebookSessions.get(ssid));
//		System.out.println("ssid: "+ssid);
//		System.out.println(repository.findConnections("facebook").size());
//		
//		
//		
//		if (repository.findConnections("facebook").isEmpty() || !facebook.isAuthorized()) {
//			return "redirect:/connect/facebook";
//		}
//		
//		
//		String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
//		System.out.println("sessionId: "+sessionId);
//		
//		User userProfile = facebook.userOperations().getUserProfile();
//		facebookSessions.put(sessionId, userProfile);
//		model.addAttribute("userProfile", userProfile);
//		System.out.println(helloService.getHelloMessage());
//
//		return "redirect:/";
//		
//	}


}
