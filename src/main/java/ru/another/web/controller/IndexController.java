package ru.another.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Another
 *         date: 17.08.2016.
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "forward:html/index.html";
	}
}
