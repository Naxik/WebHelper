package ru.another.business.service;

import ru.another.business.dto.HoursInWeekDto;

/**
 * @author Another
 *         date: 17.08.2016.
 */
public interface IHoursInWeekService {

	HoursInWeekDto save(HoursInWeekDto hoursInWeekDto);

	HoursInWeekDto get(Long id);

	void delete(Long id);
}
