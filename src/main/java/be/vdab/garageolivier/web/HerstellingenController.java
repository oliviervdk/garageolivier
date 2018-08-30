package be.vdab.garageolivier.web;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.services.HerstellingenService;

@Controller
@RequestMapping("/herstellingen")
class HerstellingenController {

	private final HerstellingenService herstellingenService;
	
	public HerstellingenController(HerstellingenService herstellingenService) {
		this.herstellingenService = herstellingenService;
	}
	private static final String VIEW = "herstellingen/herstellingen";
	private static final String HERSTELLING_TOEVOEGEN_VIEW = "herstellingen/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/herstellingen";
	private static final Logger LOGGER = Logger.getLogger(HerstellingenController.class.getName());
	
	//View
	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW)
				.addObject("herstellingen", herstellingenService.findAll());
	}
	
	//Toevoegen
	@GetMapping("toevoegen")
	String createForm() {
		return HERSTELLING_TOEVOEGEN_VIEW;
	}
	@PostMapping
	String create() {
		LOGGER.info("herstelling record toevoegen aan database");
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
}
