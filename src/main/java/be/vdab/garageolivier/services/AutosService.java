package be.vdab.garageolivier.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;

public interface AutosService {

	Page<Auto> findByKlant(Klant klant, Pageable pageable);
	List<Auto> findByKlant(Klant klant);
	public void create(Auto auto);
	public List<Auto> findAll();
	public Page<Auto> findByNummerplaatContains(String nummerplaat, Pageable pageable);
	public Page<Auto> findAll(Pageable pageable);
	void update(@Valid Auto auto);

}
