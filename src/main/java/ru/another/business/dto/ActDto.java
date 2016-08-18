package ru.another.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Getter
@Setter
public class ActDto {

	Long id;
	WorkCalendarDto workCalendar;
	String title;

	public ActDto() {}
}
