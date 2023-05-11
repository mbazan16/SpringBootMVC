package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.ServicioException;

public interface Servicio <T>{
	
	
	public List <T> listar()throws ServicioException;
	
	public Optional<T> conseguirPorId(Integer id)throws ServicioException;
	
	public T grabar(T registro)throws ServicioException;
	
	public void eliminarPorId(Integer id)throws ServicioException;
	

}
