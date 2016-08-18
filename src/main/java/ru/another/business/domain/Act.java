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
@Table(name = "acts")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Act {
	@Id
	@Column
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq", sequenceName = "act_id_seq", allocationSize = 1)
	private Long id;

	@OneToOne
	@JoinColumn(name = "work_calendar_id")
	private WorkCalendar workPeriod;

	@Column
	private String title;
}
