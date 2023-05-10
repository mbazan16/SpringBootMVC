package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Libro;
import com.example.demo.repositories.LibroRepository;

@Service
public class LibroServicio implements Servicio<Libro>{
	
	@Autowired
	LibroRepository repositorio;

	@Override
	public List<Libro> listar() {
		List<Libro> listaLibros = repositorio.findAll();
		
		return listaLibros;
	}

	@Override
	public Optional<Libro> conseguirPorId(Integer id) {
		Optional<Libro> libro = repositorio.findById(id);
		return libro;
	}

	@Override
	public Libro grabar(Libro registro) {
		repositorio.save(registro);
		return registro;
	}

	@Override
	public void eliminarPorId(Integer id) {
		repositorio.deleteById(id);	
	}

	

}
