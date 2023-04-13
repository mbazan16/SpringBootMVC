package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;

public interface ServicioEntidades <T> {
	
	public List<T> list() throws ServicioException;
	
	public T conseguirPorId(Integer id) throws ServicioException;
	
	public T grabar(T registro) throws ServicioException;
	
	public void eliminarPorId(Integer id) throws ServicioException;
	
	
	

}
