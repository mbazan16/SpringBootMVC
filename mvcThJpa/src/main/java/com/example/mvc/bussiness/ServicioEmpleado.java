package com.example.mvc.bussiness;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Empleado;


public interface ServicioEmpleado {

	Page<Empleado> listEmpleados(Pageable pageable) throws ServicioException;
	
	Empleado grabarEmpleado(Empleado empleado)throws ServicioException;

	Empleado getEmpleado(Integer id)throws ServicioException;

}
