 package com.example.mvc.bussiness;

import java.util.List; 
import java.util.Optional;

import javax.swing.plaf.synth.Region;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;
import com.example.mvc.repositories.DepartamentoRepository;
import com.example.mvc.repositories.RegionRepository;

@Service
public class ServicioRegionImpl implements ServicioRegion {
	
	Logger log = LoggerFactory.getLogger(ServicioRegionImpl.class);
	
	@Autowired
	RegionRepository repository;

	@Override
	public List<Region> listRegiones() throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region conseguirRegion(Integer idRegion) throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region grabarRegion(Region region) throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRegion(Integer idRegion) throws ServicioException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	

}
