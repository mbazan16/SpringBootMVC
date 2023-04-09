package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class ControladorInicio {
	
	@GetMapping
	public String pginaInicio() {
		return "inicio";
	}

}
