package be.vdab.garageolivier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.garageolivier.entities.Klant;
import be.vdab.garageolivier.repositories.KlantenRepository;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class KlantenServiceImpl implements KlantenService {
	private final KlantenRepository klantenRepository;

	KlantenServiceImpl(KlantenRepository klantenRepository) {
		this.klantenRepository = klantenRepository;
	}

	public void create(Klant klant) {
		klantenRepository.save(klant);
	}

	public void update(Klant klant) {
		klantenRepository.save(klant);
	}

	public void delete(Klant klant) {
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
