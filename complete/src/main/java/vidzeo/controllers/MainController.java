package vidzeo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by magnus on 18/08/14.
 */

@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping( value="/", method = RequestMethod.GET)
	public String index(Model model) {
    	return "index";
    }
  

}
