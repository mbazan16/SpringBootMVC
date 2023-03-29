package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hola")
public class HolaMundoController {
	
	
	@ResponseBody
	@GetMapping
	public String saludo() {
		return "Hola Mundo";
	}

}
