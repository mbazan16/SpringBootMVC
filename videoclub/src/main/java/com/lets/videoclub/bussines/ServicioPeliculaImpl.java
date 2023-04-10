package com.lets.videoclub.bussines;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lets.videoclub.entities.Pelicula;
import com.lets.videoclub.exceptions.CodeError;
import com.lets.videoclub.exceptions.ServicioException;
import com.lets.videoclub.repositories.PeliculaRepository;

@Service
public class ServicioPeliculaImpl implements ServicioPelicula{
	
	Logger log = LoggerFactory.getLogger(ServicioPeliculaImpl.class);
	
	@Autowired
	PeliculaRepository repository;

	@Override
	public List<Pelicula> listPeliculas() throws ServicioException {
		log.info("[listPeliculas]");
		
		List<Pelicula> peliculas;
		
		try {
			peliculas=repository.findAll();
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}
		return peliculas;
	}

	@Override
	public Pelicula conseguirPelicula(Integer idPelicula) throws ServicioException {
		log.info("[conseguirPelicula]");
		log.debug("[idPelicula: "+idPelicula+"]");
		
		Pelicula pelicula;
		
		try {
			Optional<Pelicula> peliculaOp=repository.findById(idPelicula);
			if(!peliculaOp.isPresent())throw new ServicioException(CodeError.PELICULA_NOT_FOUND);
			pelicula=peliculaOp.get();
			
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return pelicula;
	}

	@Override
	public Pelicula grabarPelicula(Pelicula pelicula) throws ServicioException {
		log.info("[grabarPelicula]");
		log.debug("[pelicula: "+pelicula.toString()+"]");
		
		try {
			pelicula=repository.save(pelicula);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return pelicula;
	}

	@Override
	public void eliminarPelicula(Integer idPelicula) throws ServicioException {
		log.info("[eliminarPelicula]");
		log.debug("[idPelicula: "+idPelicula+"]");
		
			try {
			repository.deleteById(idPelicula);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
