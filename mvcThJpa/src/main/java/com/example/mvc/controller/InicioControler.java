package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.entities.Departamento;

@Controller
@RequestMapping("/")
public class InicioControler {
	
	@Autowired
	ServicioDepartamento servicio;

	@RequestMapping
	public String xxx() {
		return "inicio";
	}
	@PostMapping
	public String grabarDepartamento(@ModelAttribute Departamento departamento,Model model) throws Exception {
		
		departamento=servicio.grabarDepartamento(departamento);
		
		model.addAttribute("departamento", departamento);	
	return "departamento";
	}
}
