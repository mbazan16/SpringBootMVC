package com.example.mvc.controller;

import java.util.List;

import javax.swing.plaf.synth.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioRegion;
import com.example.mvc.common.exceptions.ServicioException;

@Controller
@RequestMapping("/regiones")
public class ControladorRegiones {
	
	@Autowired
	ServicioRegion servicio;
	
	@GetMapping
	public String paginaRegiones(Model model) throws Exception {
		List<Region> regiones = servicio.listRegiones();
		
		model.addAttribute("regiones", regiones);	
		return "regiones";
	}
	
	
		
	
	
	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute("mensaje","Se ha producido un error");		

		return "error";
    }

}
