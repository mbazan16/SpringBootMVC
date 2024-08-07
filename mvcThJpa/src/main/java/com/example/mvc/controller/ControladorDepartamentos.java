package com.example.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value={"/","/departamentos"})
public class ControladorDepartamentos {
	Logger log = LoggerFactory.getLogger(ControladorDepartamentos.class);
	
	@Autowired
	ServicioDepartamento servicio;
	
	@GetMapping
	public String paginaDepartamentos(Model model) throws Exception {
		log.info("[paginaDepartamentos]");
		List<Departamento> departamentos = servicio.listDepartamentos();
		
		model.addAttribute("departamentos", departamentos);	
		return "departamentos";
	}
	
	@GetMapping("/{id}")
	public String paginaDepartamento(@PathVariable Integer id,Model model) throws Exception {
		log.info("[paginaDepartamento]");
		log.debug("[id:"+id+"]");
		Departamento departamento = servicio.conseguirDepartamento(id);
		
		model.addAttribute("departamento", departamento);	
		return "departamento";
	}
	
	@PostMapping
	public String grabarDepartamento(@ModelAttribute Departamento departamento,Model model) throws Exception {
		log.info("[grabarDepartamento]");
		log.debug("[departamento:"+departamento.toString()+"]");
		
		departamento=servicio.grabarDepartamento(departamento);
		
		model.addAttribute("departamento", departamento);	
		return "departamento";
	}
	
	
	@GetMapping("/d/{id}")
	public String eliminarDepartamento(@PathVariable Integer id,Model model) throws Exception {
		log.info("[eliminarDepartamento]");
		log.debug("[id:"+id+"]");
		
		servicio.eliminarDepartamento(id);
		
		
		return "redirect:/departamentos";	
	}
	
	

}
