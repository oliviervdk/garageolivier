package be.vdab.garageolivier.services;

import java.util.List;
import java.util.Optional;

import be.vdab.garageolivier.entities.Klant;

public interface KlantenService {
	List<Klant> findByFamilienaamContaining(String naam);
	public void create(Klant klant);
	public void update(Klant klant);
	public void delete(Klant klant);
	public List<Klant> findAll();
	public Optional<Klant> read(long id);
}
