package be.vdab.garageolivier.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.garageolivier.entities.Klant;

public interface KlantenRepository extends JpaRepository<Klant, Long>{

	List<Klant>findByfamilienaamContaining(String naam);
}
