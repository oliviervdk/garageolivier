package be.vdab.garageolivier.web;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;
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
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/autos?sort=nummerplaat";
	private static final String AUTO_WIJZIGEN_VIEW = "/autos/wijzigen";

	// View
	@GetMapping
	ModelAndView findAll(Pageable pageable) {
		return new ModelAndView(VIEW).addObject("page", autosService.findAll(pageable))
				.addObject(new NummerplaatForm());
	}

	// Zoeken
	@GetMapping(params = "nummerplaat")
	ModelAndView ZoekOpNaam(@Validated NummerplaatForm nummerplaatForm, Pageable pageable, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(VIEW);
		}
		return new ModelAndView(VIEW, "page",
				autosService.findByNummerplaatContains(nummerplaatForm.getNummerplaat(), pageable));
	}

	@GetMapping("{klant}")
	ModelAndView findByKlant(Klant klant, Pageable pageable) {
		return new ModelAndView(VIEW)
				.addObject("page", autosService.findByKlant(klant, pageable))
				.addObject(new NummerplaatForm());
	}

	// Toevoegen
	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(AUTO_TOEVOEGEN_VIEW).addObject(new Auto()).addObject("klanten",
				klantenService.findAll());
	}
	@PostMapping
	String create(@Valid Auto auto, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return AUTO_TOEVOEGEN_VIEW;
		}
		autosService.create(auto);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
	
	//wijzigen
	@GetMapping("/wijzigen/{auto}")
	ModelAndView wijzigEigenaar(@PathVariable Auto auto) {
		return new ModelAndView(AUTO_WIJZIGEN_VIEW)
				.addObject("auto", auto)
				.addObject("klanten", klantenService.findAll());
	}
	@PostMapping
	String wijzigEigenaar(@Valid Auto auto, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return AUTO_WIJZIGEN_VIEW;
		}
		autosService.update(auto);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
}
