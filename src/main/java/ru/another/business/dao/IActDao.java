package ru.another.business.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.another.business.domain.Act;

/**
 * @author Another
 *         date: 16.08.2016.
 */
@Transactional
public interface IActDao extends CrudRepository<Act, Long> {
}
