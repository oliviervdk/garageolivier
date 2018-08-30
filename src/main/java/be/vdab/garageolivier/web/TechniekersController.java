package be.vdab.garageolivier.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.entities.Technieker;
import be.vdab.garageolivier.services.TechniekersService;

@Controller
@RequestMapping("/techniekers")
class TechniekersController {

	private final TechniekersService techniekersService;

	TechniekersController(TechniekersService techniekersService) {
		this.techniekersService = techniekersService;
	}
	
	private static final String VIEW = "techniekers/techniekers";
	private static final String TECHNIEKER_TOEVOEGEN_VIEW = "techniekers/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/techniekers";
	
	//View
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(VIEW, "techniekers", techniekersService.findAll());
	}
	
	//Toevoegen
	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(TECHNIEKER_TOEVOEGEN_VIEW)
				.addObject(new Technieker());
	}
	@PostMapping
	String create(@Valid Technieker technieker, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return TECHNIEKER_TOEVOEGEN_VIEW;
		}
		techniekersService.create(technieker);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
	@InitBinder("technieker")
	void initBinderKlant(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
