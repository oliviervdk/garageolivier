package be.vdab.garageolivier.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.garageolivier.services.AutosService;
import be.vdab.garageolivier.services.KlantenService;

@RunWith(MockitoJUnitRunner.class)
public class KlantenControllerTest {

	private KlantenController controller;
	@Mock
	private KlantenService dummyKlantenService;
	@Mock
	private AutosService dummyAutosService;
	private Pageable pageable;
	private KlantNaamForm klantNaamForm;
	@Mock
	private BindingResult bindingResult;
	
	@Before
	public void before() {
		klantNaamForm=new KlantNaamForm();
		controller = new KlantenController(dummyKlantenService, dummyAutosService);
	}
	
	@Test
	public void findAllWerktSamenMetKlantenDotJsp() {
		ModelAndView modelAndView = controller.findAll(pageable);
		assertEquals("klanten/klanten", modelAndView.getViewName());
	}

	@Test
	public void findAllGeeftPageDoor() {
		ModelAndView modelAndView = controller.findAll(pageable);
		assertTrue(modelAndView.getModel().containsKey("page"));
	}
	
	@Test
	public void zoekOpNaamWerktSamenMetKlanten() {
		klantNaamForm.setNaam("a");
		ModelAndView modelAndView = controller.zoekOpNaam(klantNaamForm, pageable, bindingResult);
		assertEquals("klanten/klanten", modelAndView.getViewName());
	}
}
