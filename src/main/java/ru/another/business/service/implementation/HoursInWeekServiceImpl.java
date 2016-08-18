package ru.another.business.service.implementation;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.another.business.dao.IHoursInWeekDao;
import ru.another.business.domain.HoursInWeek;
import ru.another.business.dto.HoursInWeekDto;
import ru.another.business.service.IHoursInWeekService;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Service
@Transactional
public class HoursInWeekServiceImpl implements IHoursInWeekService {

	private final Mapper mapper;
	private final IHoursInWeekDao dao;

	@Autowired
	public HoursInWeekServiceImpl(IHoursInWeekDao dao, Mapper mapper) {
		this.dao = dao;
		this.mapper = mapper;
	}

	@Override
	public HoursInWeekDto save(HoursInWeekDto hoursInWeekDto) {
		HoursInWeek hoursInWeek = mapper.map(hoursInWeekDto, HoursInWeek.class);
		return mapper.map(dao.save(hoursInWeek), HoursInWeekDto.class);
	}

	@Override
	public HoursInWeekDto get(Long id) {
		return mapper.map(dao.findOne(id), HoursInWeekDto.class);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}
}
