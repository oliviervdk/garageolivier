package be.vdab.garageolivier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Klant;
import be.vdab.garageolivier.repositories.AutosRepository;
import be.vdab.garageolivier.repositories.HerstellingenRepository;
import be.vdab.garageolivier.repositories.KlantenRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class KlantenServiceImpl implements KlantenService {
	private final KlantenRepository klantenRepository;
	private final AutosRepository autosRepository;
	private final HerstellingenRepository herstellingenRepository;

	KlantenServiceImpl(KlantenRepository klantenRepository, AutosRepository autosRepository, HerstellingenRepository herstellingenRepository) {
		this.klantenRepository = klantenRepository;
		this.autosRepository = autosRepository;
		this.herstellingenRepository = herstellingenRepository;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Klant klant) {
		klantenRepository.save(klant);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void update(Klant klant) {
		klantenRepository.save(klant);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void delete(Klant klant) {
		List<Auto> klantAutos = autosRepository.findByKlant(klant);
		for(Auto auto : klantAutos) {
			herstellingenRepository.deleteByAuto(auto);
			autosRepository.delete(auto);
		}
		klantenRepository.delete(klant);
	}

	public List<Klant> findAll() {
		return klantenRepository.findAll(new Sort("familienaam"));
	}

	public Optional<Klant> read(long id) {
		return Optional.ofNullable(klantenRepository.getOne(id));
	}

	@Override
	public Page<Klant> findAll(Pageable pageable) {
		return klantenRepository.findAll(pageable);
	}

	@Override
	public Page<Klant> findByNaamContaining(String naam, Pageable pageable) {
		return klantenRepository.findByFamilienaamContaining(naam, pageable);
	}
}
