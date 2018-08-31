package be.vdab.garageolivier.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.services.AutosService;
import be.vdab.garageolivier.services.KlantenService;


@Controller
@RequestMapping("/autos")
class AutosController {
	
	private final AutosService autosService;
	private final KlantenService klantenService;

	public AutosController(AutosService autosService, KlantenService klantenService) {
		this.autosService = autosService;
		this.klantenService = klantenService;
	}
	private static final String VIEW = "autos/autos";
	private static final String AUTO_TOEVOEGEN_VIEW = "autos/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/autos";
	
	//View
	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW)
				.addObject("autos", autosService.findAll());
	}
	
	//Toevoegen
	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(AUTO_TOEVOEGEN_VIEW)
				.addObject(new Auto())
				.addObject("klanten", klantenService.findAll());
	}
	@PostMapping
	String create(@Valid Auto auto, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return AUTO_TOEVOEGEN_VIEW;
		}
		autosService.create(auto);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
	
	/*
	@InitBinder("auto")
	void initBinderKlant(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}*/
}
