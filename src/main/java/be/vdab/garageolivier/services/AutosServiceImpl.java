package be.vdab.garageolivier.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Page<Auto> findByKlant(Klant klant, Pageable pageable) {
		return autosRepository.findByKlant(klant, pageable);
	}

	@Override
	public void create(Auto auto) {
		autosRepository.save(auto);
	}

	@Override
	public List<Auto> findAll() {
		return autosRepository.findAll(new Sort("nummerplaat"));
	}

	@Override
	public Page<Auto> findByNummerplaatContains(String nummerplaat, Pageable pageable) {
		return autosRepository.findByNummerplaatContains(nummerplaat, pageable);
	}

	@Override
	public Page<Auto> findAll(Pageable pageable) {
		return autosRepository.findAll(pageable);
	}

}
