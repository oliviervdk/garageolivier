package be.vdab.garageolivier.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.garageolivier.entities.Technieker;
import be.vdab.garageolivier.repositories.TechniekersRepository;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class TechniekersServiceImpl implements TechniekersService {

	private final TechniekersRepository techniekersRepository;

	TechniekersServiceImpl(TechniekersRepository techniekersRepository) {
		this.techniekersRepository = techniekersRepository;
	}
	@Override
	public void create(Technieker technieker) {
		techniekersRepository.save(technieker);
	}
	@Override
	public List<Technieker> findAll() {
		return techniekersRepository.findAll(new Sort(Sort.Direction.ASC , "familienaam"));
	}
	@Override
	public Page<Technieker> findAll(Pageable pageable) {
		return techniekersRepository.findAll(pageable);
	}

}
