package com.example.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.mvc.common.exceptions.CodeError;
import com.example.mvc.common.exceptions.MsgError;
import com.example.mvc.common.exceptions.ServicioException;

@ControllerAdvice
public class ErrosrHadler {
	Logger log = LoggerFactory.getLogger(ErrosrHadler.class);
	
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String errorGeneralHadler(Model model) {
		log.info("[errorGeneralHadler]");
		log.debug("[msgError:"+MsgError.ERROR_GENERAL +"]");
		model.addAttribute("msgError",MsgError.ERROR_GENERAL );
		return "error";
	}
	
	
	@ExceptionHandler(ServicioException.class)	
	public String servicioExceptionHadler(ServicioException e,Model model) {
		log.info("[servicioExceptionHadler]");
		if(CodeError.DEPARTAMENTO_NOT_FOUND.equals(e.getCodigo())) {
			log.debug("[msgError:"+MsgError.DEPARTAMENTO_NOT_FOUND +"]");
			model.addAttribute("msgError",MsgError.DEPARTAMENTO_NOT_FOUND );
			return "departamentos"; //Volvemos a la vista de departamentos
		}
		log.debug("[msgError:"+MsgError.ERROR_GENERAL +"]");
		model.addAttribute("msgError",MsgError.ERROR_GENERAL );		
		return "error"; //Volvemos a la vista de errores
	}
	
	

}
