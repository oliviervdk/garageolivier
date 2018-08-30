package be.vdab.garageolivier.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.garageolivier.entities.Klant;
import be.vdab.garageolivier.services.KlantenService;

@Controller
@RequestMapping("/klanten")
class KlantenController {

	private final KlantenService klantenService;

	KlantenController(KlantenService klantenService) {
		this.klantenService = klantenService;
	}

	private static final String KLANTEN_VIEW = "klanten/klanten";
	private static final String KLANT_TOEVOEGEN_VIEW = "klanten/toevoegen";
	private static final String KLANT_WIJZIGEN_VIEW = "klanten/wijzigen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/klanten";
	private static final String REDIRECT_URL_NA_VERWIJDEREN = "redirect:/klanten/{id}/verwijderd";
	private static final String VERWIJDERD_VIEW = "klanten/verwijderd";

	// View
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(KLANTEN_VIEW, "klanten", klantenService.findAll());
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
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
	@InitBinder("klant")
	void initBinderKlant(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

	// verwijderen
	@PostMapping("{id}/verwijderen")
	String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
		Klant klant = klantenService.read(id).get();
		klantenService.delete(klant);
		redirectAttributes.addAttribute("naam", klant.getNaam()); 
		return REDIRECT_URL_NA_VERWIJDEREN; 
	}
	@GetMapping("{id}/verwijderd")
	String deleted() {
	 return VERWIJDERD_VIEW;
	}

	// Wijzigen
	@GetMapping("{id}")
	ModelAndView wijzigForm(@PathVariable long id) {
		Optional<Klant> optionalKlant = klantenService.read(id);
		return new ModelAndView(KLANT_WIJZIGEN_VIEW)
				.addObject(optionalKlant.get());
	}
	@PostMapping("{id}/wijzigen")
	String update(@Valid Klant klant, BindingResult bindinResult) {
		if(bindinResult.hasErrors()) {
			return KLANT_WIJZIGEN_VIEW;
		}
		klantenService.update(klant);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
}