package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface Servicio <T>{
	
	
	public List <T> listar();
	
	public Optional<T> conseguirPorId(Integer id);
	
	public T grabar(T registro);
	
	public void eliminarPorId(Integer id);
	

}
