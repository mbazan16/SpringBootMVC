 package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;

@Controller
@RequestMapping("/departamentos")
public class ControladorDepartamentos {
	
	@Autowired
	ServicioDepartamento servicio;
	
	@GetMapping
	public String paginaDepartamentos(Model model) throws Exception {
		List<Departamento> departamentos = servicio.list();
		
		model.addAttribute("departamentos", departamentos);	
		return "departamentos";
	}
	
	@GetMapping("/{id}")
	public String paginaDepartamento(@PathVariable Integer id,Model model) throws Exception {
		Departamento departamento = servicio.conseguirPorId(id);
		
		model.addAttribute("departamento", departamento);	
		return "departamento";
	}
	
	@GetMapping("/modificarDepartamento/{id}")
	public String paginaModificar(@PathVariable Integer id,Model model) throws Exception {
		Departamento departamento = servicio.conseguirPorId(id);
		
		model.addAttribute("departamento", departamento);	
		return "modificarDepartamento";
	}
	
	@PostMapping
	public String grabarDepartamento(@ModelAttribute Departamento departamento,Model model) throws Exception {
		
		departamento=servicio.grabar(departamento);
		
		model.addAttribute("departamento", departamento);	
		return "departamento";
	}
	
	
	@GetMapping("/d/{id}")
	public String eliminarDepartamento(@PathVariable Integer id,Model model) throws Exception {
		
		servicio.eliminarPorId(id);
		
		
		return "redirect:/departamentos";	
	}
		
	
	
	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute("mensaje","Se ha producido un error");		

		return "error";
    }

}
