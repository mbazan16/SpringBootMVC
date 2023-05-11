package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Libro;
import com.example.demo.exceptions.CodeError;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.repositories.LibroRepository;

@Service
public class LibroServicio implements Servicio<Libro> {

	Logger log = LoggerFactory.getLogger(LibroServicio.class);
	@Autowired
	LibroRepository repositorio;

	@Override
	public List<Libro> listar() throws ServicioException {

		log.info("[listLibros]");

		List<Libro> listaLibros = new ArrayList<Libro>();

		try {

			listaLibros = repositorio.findAll();

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_SERVICIO, e);
		}

		return listaLibros;
	}

	@Override
	public Optional<Libro> conseguirPorId(Integer id) throws ServicioException {

		log.info("[conseguirLibro]");
		log.debug("[id: " + id + "]");

		Optional<Libro> libro;

		try {

			libro = repositorio.findById(id);

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_SERVICIO, e);
		}

		return libro;
	}

	@Override
	public Libro grabar(Libro registro) throws ServicioException {

		log.info("[grabarLibro]");
		log.debug("[libro: " + registro.toString() + "]");

		try {

			repositorio.save(registro);

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_SERVICIO, e);
		}

		return registro;
	}

	@Override
	public void eliminarPorId(Integer id) throws ServicioException {

		log.info("[eliminarLibro]");
		log.debug("[id: " + id + "]");

		try {

			repositorio.deleteById(id);

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_SERVICIO, e);
		}
	}
}
