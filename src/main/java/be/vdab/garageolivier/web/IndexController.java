package be.vdab.garageolivier.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class IndexController {

	private static final String VIEW = "index";
	
	@GetMapping
	String index() {
		return VIEW;
	}
}
