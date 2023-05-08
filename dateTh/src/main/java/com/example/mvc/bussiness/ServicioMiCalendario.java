package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.MiCalendario;

public interface ServicioMiCalendario {

	List<MiCalendario> listMiCalendarios() throws ServicioException;

	MiCalendario conseguirMiCalendario(Integer idMiCalendario) throws ServicioException;

	MiCalendario grabarMiCalendario(MiCalendario miCalendario) throws ServicioException;

	void eliminarMiCalendario(Integer idMiCalendario) throws ServicioException;

}