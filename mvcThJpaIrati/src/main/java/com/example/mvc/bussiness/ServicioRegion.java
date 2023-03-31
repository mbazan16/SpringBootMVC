package com.example.mvc.bussiness;

import java.util.List;

import javax.swing.plaf.synth.Region;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;

public interface ServicioRegion {

	List<Region> listRegiones() throws ServicioException;

	Region conseguirRegion(Integer idRegion) throws ServicioException;

	Region grabarRegion(Region region) throws ServicioException;

	void eliminarRegion(Integer idRegion) throws ServicioException;

}