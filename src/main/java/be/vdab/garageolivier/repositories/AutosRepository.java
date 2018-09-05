package be.vdab.garageolivier.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;

public interface AutosRepository extends JpaRepository<Auto, Long> {

	Page<Auto> findByNummerplaatContains(String nummerplaat, Pageable pageable);
	Page<Auto> findByKlant(Klant klant, Pageable pageable);
	List<Auto> findByKlant(Klant klant);
}
