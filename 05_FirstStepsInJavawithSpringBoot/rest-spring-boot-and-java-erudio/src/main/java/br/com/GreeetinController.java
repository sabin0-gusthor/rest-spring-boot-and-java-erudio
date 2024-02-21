package br.com;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeetinController {
	
	private static final String template = "HELLO, %S!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam( value = "name", defaultValue = "World")
			String name) {
		return new Greeting( counter.incrementAndGet(), String.format(template, name));
	}
	
}
