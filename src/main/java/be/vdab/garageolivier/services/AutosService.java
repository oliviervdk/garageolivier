package be.vdab.garageolivier.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;

public interface AutosService {

	Page<Auto> findByKlant(Klant klant, Pageable pageable);
	public void create(Auto auto);
	public List<Auto> findAll();
	public Page<Auto> findByNummerplaatContains(String nummerplaat, Pageable pageable);
	public Page<Auto> findAll(Pageable pageable);
}
