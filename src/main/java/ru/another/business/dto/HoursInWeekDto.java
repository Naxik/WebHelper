package ru.another.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Another
 *         date: 16.08.2016.
 */
@Getter
@Setter
public class HoursInWeekDto {

	Long id;
	String weekType;
	Integer hours;

	public HoursInWeekDto() {}
}
