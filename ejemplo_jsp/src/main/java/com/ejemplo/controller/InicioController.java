package com.ejemplo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class  InicioController {
	Logger log = LoggerFactory.getLogger(InicioController.class);
	
	@GetMapping
	public String inicio() {
		log.debug("inicio");
		return "index2";
	}

}
