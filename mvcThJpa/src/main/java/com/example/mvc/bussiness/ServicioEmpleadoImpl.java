package com.example.mvc.bussiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Empleado;
import com.example.mvc.repositories.EmpleadoRepository;

@Service
public class ServicioEmpleadoImpl implements ServicioEmpleado {
	
	Logger log = LoggerFactory.getLogger(ServicioEmpleadoImpl.class);
	
	@Autowired
	EmpleadoRepository repository;
	
	
	@Override
	public Page<Empleado> listEmpleados(Pageable pageable) throws ServicioException{
		log.info("[listEmpleados]");
		
		Page<Empleado> empleados;
		
		try {
			empleados= repository.findAll(pageable);
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return empleados;		
	}
	
	
	@Override
	public Empleado getEmpleado(Integer id) throws ServicioException {
		log.info("[getEmpleado]");
		log.debug("[id: "+id+"]");		
		Empleado empleado;
		try{
			empleado =repository.findById(id).get();
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return empleado;
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
