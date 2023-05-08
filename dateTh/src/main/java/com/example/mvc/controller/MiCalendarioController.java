package com.example.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.bussiness.ServicioMiCalendario;
import com.example.mvc.entities.MiCalendario;

@Controller
@RequestMapping("/")
public class MiCalendarioController {
	Logger log = LoggerFactory.getLogger(MiCalendarioController.class);

	@Autowired
	ServicioMiCalendario servicio;

	@GetMapping
	public String listado(Model model) throws Exception {
		log.debug("[listado]");
		List<MiCalendario> miCalendarios = servicio.listMiCalendarios();

		model.addAttribute("misCalendarios", miCalendarios);
		return "miCalendarios";
	}

	@GetMapping("/{id}")
	public String ver(@PathVariable Integer id, Model model) throws Exception {
		log.debug("[ver]");
		MiCalendario miCalendario = servicio.conseguirMiCalendario(id);

		model.addAttribute("miCalendario", miCalendario);
		return "miCalendario";
	}
	
	@PostMapping
	public String grabarMiCalendario(@ModelAttribute MiCalendario miCalendario, Model model) throws Exception {
		log.debug("[grabarMiCalendario]");
		miCalendario = servicio.grabarMiCalendario(miCalendario);

		model.addAttribute("miCalendario", miCalendario);
		return "miCalendario";
	}

}
