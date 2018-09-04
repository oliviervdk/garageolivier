package be.vdab.garageolivier.web;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;
import be.vdab.garageolivier.services.AutosService;
import be.vdab.garageolivier.services.HerstellingenService;
import be.vdab.garageolivier.services.TechniekersService;

@Controller
@RequestMapping("/herstellingen")
class HerstellingenController {

	private final HerstellingenService herstellingenService;
	private final TechniekersService techniekersService;
	private final AutosService autosService;

	public HerstellingenController(HerstellingenService herstellingenService, TechniekersService techniekersService,
			AutosService autosService) {
		this.herstellingenService = herstellingenService;
		this.techniekersService = techniekersService;
		this.autosService = autosService;
	}

	private static final String VIEW = "herstellingen/herstellingen";
	private static final String HERSTELLING_TOEVOEGEN_VIEW = "herstellingen/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/herstellingen?sort=herstelDatum";

	// View
	@GetMapping
	ModelAndView findAll(Pageable pageable) {
		return new ModelAndView(VIEW).addObject("page", herstellingenService.findAll(pageable));
	}

	// Toevoegen
	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(HERSTELLING_TOEVOEGEN_VIEW).addObject(new Herstelling())
				.addObject("techniekers", techniekersService.findAll()).addObject("autos", autosService.findAll());
	}

	// Zoeken
	@GetMapping("{auto}")
	ModelAndView findByKlant(Auto auto, Pageable pageable) {
		return new ModelAndView(VIEW)
				.addObject("page", herstellingenService.findByAuto(auto, pageable));
	}
	
	//Toevoegen
	@PostMapping
	String create(@Valid Herstelling herstelling, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return HERSTELLING_TOEVOEGEN_VIEW;
		}
		herstellingenService.create(herstelling);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}

	// enkel als je entity een value object(immutable) als attribuut heeft!
	/*
	 * @InitBinder("herstelling") void initBinderKlant(WebDataBinder binder) {
	 * binder.initDirectFieldAccess(); }
	 */
}
