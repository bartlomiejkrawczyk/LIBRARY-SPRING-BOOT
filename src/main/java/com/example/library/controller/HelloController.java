package com.example.library.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/greet")
@RestController
public class HelloController {

	@GetMapping({"/{name}", "", "/"})
	public String greet(@PathVariable(required = false) String name) {
		String greet = Optional.ofNullable(name).orElse("World");
		return String.format("Hello, %s!", greet);
	}
}
