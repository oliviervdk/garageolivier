package be.vdab.garageolivier.services;

import java.util.List;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;

public interface AutosService {

	List<Auto> findByKlant(Klant klant);
	public void create(Auto auto);
	public List<Auto> findAll();
	public List<Auto> findByNummerplaatContains(String nummerplaat);
}
