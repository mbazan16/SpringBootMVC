package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Region;

public interface ServicioRegion {
	List<Region> listRegiones() throws ServicioException;

	Region conseguirRegion(Integer idRegion) throws ServicioException;

	Region grabarRegion(Region region) throws ServicioException;

	void eliminarRegion(Integer idRegion) throws ServicioException;
}
