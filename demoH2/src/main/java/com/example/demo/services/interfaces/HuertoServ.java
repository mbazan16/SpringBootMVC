package com.example.demo.services.interfaces;

import com.example.demo.entities.Huerto;

public interface HuertoServ {

	Iterable<Huerto> findAll();

	Huerto findHuerto(Integer id);

	Huerto newHuerto(String name);

	void updateHuerto(Huerto huerto);

	void deleteHuerto(Integer id);

}