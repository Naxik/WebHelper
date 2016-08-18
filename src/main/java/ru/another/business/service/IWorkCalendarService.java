package ru.another.business.service;

import ru.another.business.dto.WorkCalendarDto;

/**
 * @author Another
 *         date: 17.08.2016.
 */
public interface IWorkCalendarService {

	WorkCalendarDto save(WorkCalendarDto workCalendarDto);

	WorkCalendarDto get(Long id);

	void delete(Long id);
}
