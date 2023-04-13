package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;

@Controller
@RequestMapping("/dw")
public class ControladorInicio {
	
	@Autowired
	ServicioDepartamento servicio;
	
	@GetMapping
	public String pginaInicio() {
		return "inicio";
	}
	
	@PostMapping
	public String crearDepartamento(@PathVariable Departamento departamento, Model modelo) throws ServicioException  {
		
		servicio.grabar(departamento);
		
		modelo.addAttribute("departamento", departamento);
		
		return"departamento";
	}
	
	

}
