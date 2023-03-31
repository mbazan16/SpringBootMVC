package com.example.mvc.controller;

import java.util.List;

import javax.swing.plaf.synth.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.mvc.bussiness.ServicioRegions;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Regions;

@Controller
@RequestMapping("/regions")
public class ControladorRegions {
	
	@Autowired
	ServicioRegions servicio;
	private Object region;
	
	@GetMapping
	public String paginaRegion(Model model) throws Exception {
		List<Region> regions = servicio.listRegions();
		
		model.addAttribute("regions", regions);	
		return "regions";
	}
	
	@GetMapping("/{id}")
	public String paginaRegion(@PathVariable Integer id,Model model) throws Exception {
		Region region = servicio.conseguirRegion(id);
		
		model.addAttribute("region", region);	
		return "region";
	}
	
	@PostMapping
	public String grabarRegion(@ModelAttribute Region region,Model model) throws Exception {
		
		region=servicio.eliminarRegion(region);
		
		model.addAttribute("region", region);	
		return "Region";
	}
	
	
	@GetMapping("/d/{id}")
	public String eliminarRegion(@PathVariable Integer id,Model model) throws Exception {
		
		servicio.eliminarDepartamento(id);
		
		
		return "redirect:/departamentos";	
	}
		
	
	
	@ExceptionHandler({ ServicioException.class, Exception.class })
    public String  handleException(Model model) {
		
		model.addAttribute("mensaje","Se ha producido un error");		

		return "error";
    }

}
