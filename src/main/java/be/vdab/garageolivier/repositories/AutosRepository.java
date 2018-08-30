package be.vdab.garageolivier.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;

public interface AutosRepository extends JpaRepository<Auto, Long> {

	List<Auto> findByNummerplaatContains(String nummerplaat);
	List<Auto> findByKlant(Klant klant);
}
