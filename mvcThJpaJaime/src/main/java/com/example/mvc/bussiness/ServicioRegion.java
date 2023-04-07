package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Region;
import com.example.mvc.entities.Region;
import com.example.mvc.repositories.RegionRepository;

@Service
public class ServicioRegion implements ServicioEntidades<Region>{
	
	Logger log = LoggerFactory.getLogger(ServicioRegion.class);
	
	@Autowired
	RegionRepository repository;

	@Override
	public List<Region> list() throws ServicioException {
		
		log.info("[listaRegiones]");
		List<Region> regiones;
		
		try {
			regiones= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return regiones;

		
		
	}

	@Override
	public Region conseguirPorId(Integer idRegion) throws ServicioException {
		log.info("[conseguirRegion]");
		log.debug("[idRegion: "+idRegion+"]");
		
		Region region;
		
		try {
			
			Optional<Region> departamentoOp= repository.findById(idRegion);
			if(!departamentoOp.isPresent()) throw new ServicioException(CodeError.DEPARTAMENTO_NOT_FOUND);
			region= departamentoOp.get();
			
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return region;
		
				
	}

	@Override
	public Region grabar(Region region) throws ServicioException {
		log.info("[grabarRegion]");
		log.debug("[region: "+region.toString()+"]");
		
		try{
			region =repository.save(region);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return region;
				
	}

	@Override
	public void eliminarPorId(Integer idRegion) throws ServicioException {
		
		log.info("[eliminarRegion]");
		log.debug("[idRegion: "+idRegion+"]");
		
			try {
			repository.deleteById(idRegion);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
