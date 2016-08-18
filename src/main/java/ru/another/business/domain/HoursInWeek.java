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
@Table(name = "hours_in_week")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HoursInWeek {

	@Id
	@Column
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq", sequenceName = "hours_in_week_id_seq", allocationSize = 1)
	private Long id;

	@Column
	private String weekType;

	@Column
	private Integer hours;
}
