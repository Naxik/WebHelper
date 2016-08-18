package ru.another.business.service.implementation;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.another.business.dao.IWorkCalendarDao;
import ru.another.business.domain.WorkCalendar;
import ru.another.business.dto.WorkCalendarDto;
import ru.another.business.service.IWorkCalendarService;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Service
@Transactional
public class WorkCalendarServiceImpl implements IWorkCalendarService {

	private final Mapper mapper;
	private final IWorkCalendarDao dao;

	@Autowired
	public WorkCalendarServiceImpl(IWorkCalendarDao dao, Mapper mapper) {
		this.dao = dao;
		this.mapper = mapper;
	}

	@Override
	public WorkCalendarDto save(WorkCalendarDto workCalendarDto) {
		WorkCalendar workCalendar = mapper.map(workCalendarDto, WorkCalendar.class);
		return mapper.map(dao.save(workCalendar), WorkCalendarDto.class);
	}

	@Override
	public WorkCalendarDto get(Long id) {
		return mapper.map(dao.findOne(id), WorkCalendarDto.class);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}
}
