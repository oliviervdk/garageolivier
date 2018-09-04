package be.vdab.garageolivier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.garageolivier.entities.Klant;

public interface KlantenService {
	Page<Klant> findByNaamContaining(String naam, Pageable pageable);
	public void create(Klant klant);
	public void update(Klant klant);
	public void delete(Klant klant);
	public List<Klant> findAll();
	public Optional<Klant> read(long id);
	public Page<Klant> findAll(Pageable pageable);
}
