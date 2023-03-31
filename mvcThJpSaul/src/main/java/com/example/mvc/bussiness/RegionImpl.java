package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.synth.Region;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;
import com.example.mvc.repositories.RegionRepository;


public abstract class RegionImpl implements ServicioRegions {

	Logger log = LoggerFactory.getLogger(ServicioRegions.class);
	


	@Autowired
	RegionRepository repository;

	@Override
	public List<Region> listRegions() throws ServicioException {
		log.info("[listDepartamentos]");

		List<Region> departamentos;

		try {
			departamentos = repository.findAll();

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}
		return departamentos;

	}

	@Override
	public Region conseguirRegion(Integer idRegion) throws ServicioException {
		log.info("[conseguirRegion]");
		log.debug("[idRegion: " + idRegion + "]");

		Region region;

		try {
			Optional<Region> regionOp = repository.findById(idRegion);
			if (!regionOp.isPresent())
				throw new ServicioException(CodeError.ERROR_GENERAL);
			region = regionOp.get();
		} catch (ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}
		return region;

	}

	@Override
	public Region grabarDepartamento(Region region) throws ServicioException {
		log.info("[grabarRegion]");
		log.debug("[region: " + region.toString() + "]");

		try {
			region = repository.save(region);
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}
		return region;

	}

	@Override
	public void eliminarDepartamento(Integer idDepartamento) throws ServicioException {
		log.info("[eliminarDepartamento]");
		log.debug("[idDepartamento: " + idDepartamento + "]");

		try {
			repository.deleteById(idDepartamento);
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}

	}

}
