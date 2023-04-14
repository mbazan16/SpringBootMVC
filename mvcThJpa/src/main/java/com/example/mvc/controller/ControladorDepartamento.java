package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;

@Controller
@RequestMapping("/departamento")
public class ControladorDepartamento {

	@Autowired
	ServicioDepartamento servicio;

	Integer id;

	@PostMapping
	public String verDepartamento(@RequestParam Integer id, Model model) throws ServicioException {

		this.id = id;

		Departamento departamento = servicio.conseguirDepartamento(id);

		model.addAttribute("departamento", departamento);

		return "departamento";

	}

	@GetMapping("/m")
	public String verModificacionDepartamento(Model model) throws ServicioException {


		Departamento departamento = servicio.conseguirDepartamento(id);

		model.addAttribute(departamento);
		
		return "modificaciondepartamento";

	}

}
