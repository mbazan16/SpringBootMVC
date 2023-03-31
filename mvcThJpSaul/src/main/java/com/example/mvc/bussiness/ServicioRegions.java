package com.example.mvc.bussiness;

import java.util.List;

import javax.swing.plaf.synth.Region;

import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.ServicioException;

@Service
public interface ServicioRegions {

	List<Region> listRegions() throws ServicioException;

	Region conseguirRegion(Integer idRegion) throws ServicioException;

	Region grabarDepartamento(Region departamento) throws ServicioException;

	 void eliminarRegion(Region region) throws ServicioException;

	void eliminarDepartamento(Integer id);

}