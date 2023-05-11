package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Libro;
import com.example.demo.repositories.LibroRepository;

@Service
public class LibroServicio implements Servicio<Libro>{
	
	Logger log = LoggerFactory.getLogger(LibroServicio.class);
	
	@Autowired
	LibroRepository repositorio;

	@Override
	public List<Libro> listar() {
		
		log.info("[listLibros]");
		
		List<Libro> listaLibros = repositorio.findAll();
		
		return listaLibros;
	}

	@Override
	public Optional<Libro> conseguirPorId(Integer id) {
		
		log.info("[conseguirLibro]");
		log.debug("[id: "+id+"]");
		
		Optional<Libro> libro = repositorio.findById(id);
		return libro;
	}

	@Override
	public Libro grabar(Libro registro) {
		
		log.info("[grabarLibro]");
		log.debug("[libro: "+registro.toString()+"]");
		
		repositorio.save(registro);
		return registro;
	}

	@Override
	public void eliminarPorId(Integer id) {
		
		log.info("[eliminarLibro]");
		log.debug("[id: "+id +"]");
		
		repositorio.deleteById(id);	
	}
}
