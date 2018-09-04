package be.vdab.garageolivier.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;
import be.vdab.garageolivier.repositories.HerstellingenRepository;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class HerstellingenServiceImpl implements HerstellingenService {
	
	private final HerstellingenRepository herstellingenrepository;
	public HerstellingenServiceImpl(HerstellingenRepository herstellingenrepository) {
		this.herstellingenrepository = herstellingenrepository;
	}

	@Override
	public Page<Herstelling> findByAuto(Auto auto, Pageable pageable) {
		return herstellingenrepository.findByAuto(auto, pageable);
	}

	@Override
	public void create(Herstelling herstelling) {
		herstellingenrepository.save(herstelling);
	}

	@Override
	public Page<Herstelling> findAll(Pageable pageable) {
		return herstellingenrepository.findAll(pageable);
	}

}
