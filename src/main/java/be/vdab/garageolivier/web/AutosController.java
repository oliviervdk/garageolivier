package be.vdab.garageolivier.web;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.services.AutosService;

@Controller
@RequestMapping("/autos")
class AutosController {
	
	private final AutosService autosService;

	public AutosController(AutosService autosService) {
		this.autosService = autosService;
	}
	private static final String VIEW = "autos/autos";
	private static final String AUTO_TOEVOEGEN_VIEW = "autos/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/autos";
	private static final Logger LOGGER = Logger.getLogger(AutosController.class.getName());
	
	//View
	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW)
				.addObject("autos", autosService.findAll());
	}
	
	//Toevoegen
	@GetMapping("toevoegen")
	String createForm() {
		return AUTO_TOEVOEGEN_VIEW;
	}
	@PostMapping
	String create() {
		LOGGER.info("auto record toevoegen aan database");
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
}
