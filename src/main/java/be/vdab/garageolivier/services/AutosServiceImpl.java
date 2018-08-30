package be.vdab.garageolivier.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;
import be.vdab.garageolivier.repositories.AutosRepository;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class AutosServiceImpl implements AutosService {

	private final AutosRepository autosRepository;

	AutosServiceImpl(AutosRepository autosRepository) {
		this.autosRepository = autosRepository;
	}
	
	@Override
	public List<Auto> findByKlant(Klant klant) {
		return autosRepository.findByKlant(klant);
	}

	@Override
	public void create(Auto auto) {
		autosRepository.save(auto);
	}

	@Override
	public List<Auto> findAll() {
		return autosRepository.findAll();
	}

	@Override
	public List<Auto> findByNummerplaatContains(String nummerplaat) {
		return autosRepository.findByNummerplaatContains(nummerplaat);
	}

}
