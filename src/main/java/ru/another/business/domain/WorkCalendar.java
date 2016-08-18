package ru.another.business.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @author Another
 *         date: 16.08.2016.
 */
@Getter
@Setter
@Entity
@Table(name = "work_calendar")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WorkCalendar {
	@Id
	@Column
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq", sequenceName = "work_calendar_id_seq", allocationSize = 1)
	private Long id;

	@Column
	private Integer year;

	@Column
	private Integer month;

	@OneToOne
	@JoinColumn(name = "hours_in_week_id")
	private HoursInWeek hoursInWeek;
}
