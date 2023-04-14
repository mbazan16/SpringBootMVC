package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Huerto;
import com.example.demo.repositories.HuertoRepository;
import com.example.demo.services.interfaces.HuertoServ;

@Service
public class HuertoImpl implements HuertoServ {
	Logger log = LoggerFactory.getLogger(HuertoImpl.class);
	
	@Autowired
	HuertoRepository repository;
	
	@Override
	public Iterable<Huerto> findAll(){
		 
		 List<Huerto> listHuertos = repository.findAll();
	     listHuertos.add(new Huerto());
	   return listHuertos;
	}
	
		
	@Override
	@Transactional
	public Huerto findHuerto(Integer id){
		
		Huerto huerto= repository.findById(id).get();
		log.info("-------------------Invocamos a personas---------------------");
		log.info(huerto.getPersonas().toString());
		return huerto;
		
	}
	
	@Override
	public Huerto newHuerto(String name){
		Huerto huerto = new Huerto(name);
		
		return repository.save(huerto);
	}
	
	@Override
	public void updateHuerto(Huerto huerto){
				
		repository.save(huerto);
	}
	
	@Override
	public void deleteHuerto(Integer id){
		
		repository.deleteById(id);
	}


}
