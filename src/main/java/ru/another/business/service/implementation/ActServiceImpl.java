package ru.another.business.service.implementation;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.another.business.dao.IActDao;
import ru.another.business.domain.Act;
import ru.another.business.dto.ActDto;
import ru.another.business.service.IActService;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Service
@Transactional
public class ActServiceImpl implements IActService {

	private final Mapper mapper;
	private final IActDao dao;

	@Autowired
	public ActServiceImpl(IActDao dao, Mapper mapper) {
		this.dao = dao;
		this.mapper = mapper;
	}

	@Override
	public ActDto save(ActDto actDto) {
		Act act = mapper.map(actDto, Act.class);
		return mapper.map(dao.save(act), ActDto.class);
	}

	@Override
	public ActDto get(Long id) {
		return mapper.map(dao.findOne(id), ActDto.class);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}
}
