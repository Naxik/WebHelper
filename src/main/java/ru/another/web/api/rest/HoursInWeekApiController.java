package ru.another.web.api.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.another.business.dto.HoursInWeekDto;
import ru.another.business.service.IHoursInWeekService;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Slf4j
@RestController
@RequestMapping("/hours_in_week")
public class HoursInWeekApiController {

	private final IHoursInWeekService service;

	@Autowired
	public HoursInWeekApiController(IHoursInWeekService service) {
		this.service = service;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<HoursInWeekDto> save(@RequestBody HoursInWeekDto newHoursInWeekDto) {
		return new ResponseEntity<>(service.save(newHoursInWeekDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<HoursInWeekDto> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<HoursInWeekDto> update(@RequestBody HoursInWeekDto hoursInWeekDto) {
		return new ResponseEntity<>(service.save(hoursInWeekDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
