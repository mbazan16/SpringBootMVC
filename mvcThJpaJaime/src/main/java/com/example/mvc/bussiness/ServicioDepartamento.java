package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;

public interface ServicioDepartamento {

	List<Departamento> listDepartamentos() throws ServicioException;

	Departamento conseguirDepartamento(Integer idDepartamento) throws ServicioException;

	Departamento grabarDepartamento(Departamento departamento) throws ServicioException;

	void eliminarDepartamento(Integer idDepartamento) throws ServicioException;

}