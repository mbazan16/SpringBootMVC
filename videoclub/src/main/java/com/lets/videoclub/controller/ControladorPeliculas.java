package com.lets.videoclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lets.videoclub.bussines.ServicioPelicula;
import com.lets.videoclub.entities.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class ControladorPeliculas {
	
	@Autowired
	ServicioPelicula servicio;
	
	@GetMapping("/crearPelicula")
	public String paginaCrearPelicula (Model model) {
		return "crearPelicula";
		
	}
	
	@PostMapping("/crearPelicula")
	public String crearPelicula(@ModelAttribute Pelicula pelicula, Model model) throws Exception {
		
		pelicula=servicio.grabarPelicula(pelicula);
		model.addAttribute("pelicula", pelicula);
		return "crearPelicula";
	}
	
}
