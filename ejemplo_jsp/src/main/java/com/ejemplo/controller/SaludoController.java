package com.ejemplo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/saludo")
public class SaludoController {
	Logger log = LoggerFactory.getLogger(SaludoController.class);
	
	@GetMapping
	public String saludar() {
		log.debug("saludar");
		return "saludo";
	}

}
