package ru.another.web.api.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.another.business.dto.ActDto;
import ru.another.business.service.IActService;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Slf4j
@RestController
@RequestMapping("/act")
public class ActApiController {

	private final IActService service;

	@Autowired
	public ActApiController(IActService service) {
		this.service = service;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<ActDto> save(@RequestBody ActDto newActDto) {
		return new ResponseEntity<>(service.save(newActDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ActDto> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<ActDto> update(@RequestBody ActDto actDto) {
		return new ResponseEntity<>(service.save(actDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
