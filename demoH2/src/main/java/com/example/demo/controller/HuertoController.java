package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entities.Huerto;
import com.example.demo.services.interfaces.HuertoServ;

@Controller
@RequestMapping("/huerto")
public class HuertoController {
	
	@Autowired	
	HuertoServ servicio;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Iterable<Huerto> verHuertos(){		
		
		return servicio.findAll();
		
	}
	
	@PostMapping("/{name}")
	public @ResponseBody Huerto create(@PathVariable String name){
		
		return servicio.newHuerto(name);
		
	}
	
	@GetMapping(value="/{id}")
	public @ResponseBody Huerto find(@PathVariable Integer id){
		
		return servicio.findHuerto(id);
		
	}
	
	@PutMapping
	public ResponseEntity<Huerto> update(@RequestBody Huerto huerto){
		servicio.updateHuerto(huerto);
		return new ResponseEntity<Huerto>(huerto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		servicio.deleteHuerto(id);
		return ResponseEntity.ok("Huerto deleted");
		
	}
	
	

}
