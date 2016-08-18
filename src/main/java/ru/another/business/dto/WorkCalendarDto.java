package ru.another.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Another
 *         date: 16.08.2016.
 */
@Getter
@Setter
public class WorkCalendarDto {

	Long id;
	Integer year;
	Integer month;
	HoursInWeekDto hoursInWeek;

	public WorkCalendarDto() {}
}
