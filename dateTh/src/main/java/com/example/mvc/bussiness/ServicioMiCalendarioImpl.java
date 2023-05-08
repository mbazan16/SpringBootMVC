package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.MiCalendario;
import com.example.mvc.repositories.MiCalendarioRepository;

@Service
public class ServicioMiCalendarioImpl implements ServicioMiCalendario {
	
	Logger log = LoggerFactory.getLogger(ServicioMiCalendarioImpl.class);
	
	@Autowired
	MiCalendarioRepository repository;
	
	
	@Override
	public List<MiCalendario> listMiCalendarios() throws ServicioException{
		log.info("[listMiCalendarios]");
		
		List<MiCalendario> miCalendarios;
		
		try {
			miCalendarios= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return miCalendarios;
		
	}
	
	
	@Override
	public MiCalendario conseguirMiCalendario(Integer idMiCalendario) throws ServicioException{
		log.info("[conseguirMiCalendario]");
		log.debug("[idMiCalendario: "+idMiCalendario+"]");
		
		MiCalendario miCalendario;
		
		try {
			Optional<MiCalendario> miCalendarioOp= repository.findById(idMiCalendario);
			if(!miCalendarioOp.isPresent()) throw new ServicioException(CodeError.DEPARTAMENTO_NOT_FOUND);
			miCalendario= miCalendarioOp.get();
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return miCalendario;
		
	}
	
	@Override
	public MiCalendario grabarMiCalendario(MiCalendario miCalendario) throws ServicioException{
		log.info("[grabarMiCalendario]");
		log.debug("[miCalendario: "+miCalendario.toString()+"]");
		
		
		try{
			miCalendario =repository.save(miCalendario);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return miCalendario;
		
	}
	
	
	@Override
	public void eliminarMiCalendario(Integer idMiCalendario) throws ServicioException{
		log.info("[eliminarMiCalendario]");
		log.debug("[idMiCalendario: "+idMiCalendario+"]");
		
			try {
			repository.deleteById(idMiCalendario);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
