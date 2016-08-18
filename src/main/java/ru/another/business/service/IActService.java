package ru.another.business.service;

import ru.another.business.dto.ActDto;

/**
 * @author Another
 *         date: 17.08.2016.
 */
public interface IActService {

	ActDto save(ActDto actDto);

	ActDto get(Long id);

	void delete(Long id);
}
