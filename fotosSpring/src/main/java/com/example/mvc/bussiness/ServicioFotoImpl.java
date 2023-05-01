package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Foto;
import com.example.mvc.repository.FotoRepository;

@Service
public class ServicioFotoImpl implements ServicioFoto {
	
	Logger log = LoggerFactory.getLogger(ServicioFotoImpl.class);
	
	@Autowired
	FotoRepository repository;
	
	
	@Override
	public List<Foto> listFotos() throws ServicioException{
		log.info("[listFotos]");
		
		List<Foto> fotos;
		
		try {
			fotos= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return fotos;
		
	}
	
	
	@Override
	public Foto conseguirFoto(Long idFoto) throws ServicioException{
		log.info("[conseguirFoto]");
		log.debug("[idFoto: "+idFoto+"]");
		
		Foto foto;
		
		try {
			Optional<Foto> fotoOp= repository.findById(idFoto);
			if(!fotoOp.isPresent()) throw new ServicioException(CodeError.DEPARTAMENTO_NOT_FOUND);
			foto= fotoOp.get();
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return foto;
		
	}
	
	@Override
	public Foto grabarFoto(Foto foto) throws ServicioException{
		log.info("[grabarFoto]");
		log.debug("[foto: "+foto.toString()+"]");
		
		
		try{
			foto =repository.save(foto);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return foto;
		
	}
	
	
	@Override
	public void eliminarFoto(Long idFoto) throws ServicioException{
		log.info("[eliminarFoto]");
		log.debug("[idFoto: "+idFoto+"]");
		
			try {
			repository.deleteById(idFoto);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
