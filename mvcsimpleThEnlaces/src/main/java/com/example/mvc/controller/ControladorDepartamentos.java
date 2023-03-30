package com.example.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.entities.Departamento;

@Controller 
@RequestMapping("/departamentos")
public class ControladorDepartamentos {
	
	@RequestMapping
	public String paginaDepartamentos(Model model) {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		Departamento departamento = new Departamento();
		departamentos.add(departamento);
		departamento = new Departamento();
		departamentos.add(departamento);
		departamento = new Departamento();
		departamentos.add(departamento);
		
		model.addAttribute("pepe", departamentos);	
		return "departamentos";
	}

}
