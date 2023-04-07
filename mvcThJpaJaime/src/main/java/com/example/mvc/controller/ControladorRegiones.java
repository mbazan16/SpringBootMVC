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
import com.example.mvc.bussiness.ServicioEntidades;
import com.example.mvc.bussiness.ServicioRegion;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Region;

@Controller
@RequestMapping("/regiones")
public class ControladorRegiones {

		@Autowired
		ServicioRegion servicio;
		
		@GetMapping
		public String paginaRegiones(Model model) throws Exception {
			
			List<Region> Regiones = servicio.list();
			
			model.addAttribute("regiones", Regiones);	
			return "regiones";
		}
		
		@GetMapping("/{id}")
		public String paginaRegion(@PathVariable Integer id,Model model) throws Exception {
			Region region = servicio.conseguirPorId(id);
			
			model.addAttribute("region", region);	
			return "region";
		}
		
		@PostMapping
		public String grabarRegion(@ModelAttribute Region region,Model model) throws Exception {
			
			region=servicio.grabar(region);
			
			model.addAttribute("region", region);	
			return "region";
		}
				
		@GetMapping("/d/{id}")
		public String eliminarRegion(@PathVariable Integer id,Model model) throws Exception {
			
			servicio.eliminarPorId(id);
			
			
			return "redirect:/regiones";	
		}
			
		@ExceptionHandler({ ServicioException.class, Exception.class })
	    public String  handleException(Model model) {
			
			model.addAttribute("mensaje","Se ha producido un error");		

			return "error";
	    }

}
