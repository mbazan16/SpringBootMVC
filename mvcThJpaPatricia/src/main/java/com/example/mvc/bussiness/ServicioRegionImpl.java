package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Region;
import com.example.mvc.repositories.RegionRepository;

public class ServicioRegionImpl implements ServicioRegion{
	Logger log = LoggerFactory.getLogger(ServicioRegionImpl.class);
	
	@Autowired
	RegionRepository repository;
	
	@Override
	public List<Region> listRegiones() throws ServicioException{
		log.info("[listRegiones]");
		
		List<Region> regiones;
		
		try {
			regiones= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return regiones;
		
		@Override
		public Region conseguirRegion(Integer idRegion) throws ServicioException{
			log.info("[conseguirRegion]");
			log.debug("[idRegion: "+idRegion+"]");
			
			Region region;
			
			try {
				Optional<Region> regionOp= repository.findById(idRegion);
				if(!regionOp.isPresent()) throw new ServicioException(CodeError.REGION_NOT_FOUND);
				region= regionOp.get();
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
		public Region grabarRegion(Region region) throws ServicioException{
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
		public void eliminarRegion(Integer idRegion) throws ServicioException{
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
