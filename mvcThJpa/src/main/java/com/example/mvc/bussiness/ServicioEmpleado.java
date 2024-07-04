package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Empleado;


public interface ServicioEmpleado {

	List<Empleado> listEmpleados() throws ServicioException;
	
	Empleado grabarEmpleado(Empleado empleado)throws ServicioException;

}
