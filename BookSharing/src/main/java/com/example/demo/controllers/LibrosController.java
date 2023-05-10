package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.Libro;
import com.example.demo.service.LibroServicio;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	
	@Autowired
	LibroServicio servicio;
	
	@GetMapping
	public String paginaLibros(Model modelo) {
		
		List<Libro> listaLibros = servicio.listar();		
		modelo.addAttribute(listaLibros);
		
		return "paginaLibros";
	}
	
	

}
