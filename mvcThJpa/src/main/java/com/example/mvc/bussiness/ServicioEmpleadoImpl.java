package com.example.mvc.bussiness;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Empleado;
import com.example.mvc.repositories.DepartamentoRepository;
import com.example.mvc.repositories.EmpleadoRepository;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado {
	
	Logger log = LoggerFactory.getLogger(ServicioEmpleadoImpl.class);
	
	@Autowired
	EmpleadoRepository repository;
	
	
	@Override
	public List<Empleado> listEmpleados() throws ServicioException{
		log.info("[listEmpleados]");
		
		List<Empleado> empleados;
		
		try {
			empleados= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return empleados;		
	}
	
	
	@Override
	public Empleado grabarEmpleado(Empleado empleado) throws ServicioException{
		log.info("[grabarEmpleado]");
		log.debug("[empleado: "+empleado.toString()+"]");		
		
		try{
			empleado =repository.save(empleado);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return empleado;
		
	}

}
