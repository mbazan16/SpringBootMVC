package com.example.mvc.bussiness;

import java.util.List;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Foto;

public interface ServicioFoto {

	List<Foto> listFotos() throws ServicioException;

	Foto conseguirFoto(Long idFoto) throws ServicioException;

	Foto grabarFoto(Foto foto) throws ServicioException;

	void eliminarFoto(Long idFoto) throws ServicioException;

}