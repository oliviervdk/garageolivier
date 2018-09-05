package be.vdab.garageolivier.web;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.garageolivier.entities.Klant;
import be.vdab.garageolivier.services.AutosService;
import be.vdab.garageolivier.services.HerstellingenService;
import be.vdab.garageolivier.services.KlantenService;

@Controller
@RequestMapping("/klanten")
class KlantenController {

	private final KlantenService klantenService;

	KlantenController(KlantenService klantenService, AutosService autosService, HerstellingenService herstellingenService) {
		this.klantenService = klantenService;
	}

	private static final String KLANTEN_VIEW = "klanten/klanten";
	private static final String KLANT_TOEVOEGEN_VIEW = "klanten/toevoegen";
	private static final String KLANT_WIJZIGEN_VIEW = "klanten/wijzigen";
	private static final String REDIRECT_NAAR_KLANTEN = "redirect:/klanten?sort=familienaam";
	//private static final String REDIRECT_URL_NA_VERWIJDEREN = "redirect:/klanten/{id}/verwijderd";
	private static final String VERWIJDERD_VIEW = "klanten/verwijderd";
	private static final String REDIRECT_URL_NA_LOCKING_EXCEPTION =
			"redirect:klanten/wijzigen?optimisticlockingexception=true";

	// View
	@GetMapping
	ModelAndView findAll(Pageable pageable) {
		return new ModelAndView(KLANTEN_VIEW, "page", klantenService.findAll(pageable))
				.addObject(new KlantNaamForm());
	}
	//Zoeken op naam
	@GetMapping(params = "naam")
	ModelAndView ZoekOpNaam(@Validated KlantNaamForm klantNaamForm, Pageable pageable, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView(KLANTEN_VIEW);
		}
		return new ModelAndView(KLANTEN_VIEW, "page", klantenService.findByNaamContaining(klantNaamForm.getNaam(), pageable));
	}

	// Toevoegen
	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(KLANT_TOEVOEGEN_VIEW)
				.addObject(new Klant());
	}
	@PostMapping
	String create(@Valid Klant klant, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return KLANT_TOEVOEGEN_VIEW;
		}
		klantenService.create(klant);
		return REDIRECT_NAAR_KLANTEN;
	}
	@InitBinder("klant")
	void initBinderKlant(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

	// verwijderen
	@GetMapping("{klant}/verwijderen")
	ModelAndView deleted(@PathVariable Klant klant) {
		return new ModelAndView(VERWIJDERD_VIEW)
			 .addObject("klant", klant);
	}
	@PostMapping("{klant}/verwijderd")
	String delete(@PathVariable Klant klant, RedirectAttributes redirectAttributes) {
		klantenService.delete(klant); 
		return REDIRECT_NAAR_KLANTEN; 
	}

	// Wijzigen
	@GetMapping("{klant}/wijzigen")
	ModelAndView wijzigForm(@PathVariable Klant klant) {
		return new ModelAndView(KLANT_WIJZIGEN_VIEW)
				.addObject(klant);
	}
	@PostMapping("{klant}/wijzigen")
	String update(@Valid Klant klant, BindingResult bindinResult) {
		if(bindinResult.hasErrors()) {
			return KLANT_WIJZIGEN_VIEW;
		}
		try {
			klantenService.update(klant);
			return REDIRECT_NAAR_KLANTEN;
		}catch (ObjectOptimisticLockingFailureException ex) {
			return REDIRECT_URL_NA_LOCKING_EXCEPTION;
		}
	}
	
}