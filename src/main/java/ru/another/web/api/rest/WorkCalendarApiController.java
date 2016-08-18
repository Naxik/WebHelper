package ru.another.web.api.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.another.business.dto.WorkCalendarDto;
import ru.another.business.service.IWorkCalendarService;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Slf4j
@RestController
@RequestMapping("/work_calendar")
public class WorkCalendarApiController {

	private final IWorkCalendarService service;

	@Autowired
	public WorkCalendarApiController(IWorkCalendarService service) {
		this.service = service;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<WorkCalendarDto> save(@RequestBody WorkCalendarDto newWorkCalendarDto) {
		return new ResponseEntity<>(service.save(newWorkCalendarDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<WorkCalendarDto> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<WorkCalendarDto> update(@RequestBody WorkCalendarDto workCalendarDto) {
		return new ResponseEntity<>(service.save(workCalendarDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
