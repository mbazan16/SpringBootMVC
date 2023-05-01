package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entities.Huerto;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HuertoRepositoryTest {
	Logger log = LoggerFactory.getLogger(HuertoRepositoryTest.class);

	@Autowired
	HuertoRepository repository;

	@BeforeEach
	public void antesCadaTest() {
		log.debug("---------EMPIEZA EJECUCIÓN DE TEST----------");
	}

	@Test
	@DisplayName("findAll")
	public void findAll() {

		Iterable<Huerto> huertos = repository.findAll();
		Assertions.assertThat(huertos).isNotEmpty();
	}
	
	@Test
	@DisplayName("encuentraPorNombreNamedQuery")
	public void encuentraPorNombreNamedQuery() {

		Iterable<Huerto> huertos = repository.encuentraPorNombreNamedQuery("Mi HuertoData");
		assertEquals("Mi HuertoData", huertos.iterator().next().getName());
	}
	
	@Test
	@DisplayName("findByNameOrderByNameDesc")
	public void findByNameOrderByNameDesc() {

		Iterable<Huerto> huertos = repository.findByName("Mi HuertoData");
		assertEquals("Mi HuertoData", huertos.iterator().next().getName());
	}
	
	@Test
	@DisplayName("encuentraPorNameJPQL")
	public void encuentraPorNameJPQL() {

		Iterable<Huerto> huertos = repository.encuentraPorNameJPQL("Mi HuertoData");
		Huerto huerto =huertos.iterator().next();
		assertEquals("Mi HuertoData", huerto.getName());
		log.info("----------EAGER vamos a ejecutar la select para buscar a las personas--------------");
		log.info(huerto.getPersonas().toString());
		log.info("-------------------------");
	}
	
	@Test
	@DisplayName("encuentraPorNameNativo")
	public void encuentraPorNameNativo() {

		Iterable<Huerto> huertos = repository.encuentraPorNameNativo("Mi HuertoData");
		assertEquals("Mi HuertoData", huertos.iterator().next().getName());
	}
	
	@Test
	@DisplayName("insertarHuerto")
	public void insertarHuerto() {

		int numeroInserciones = repository.insertarHuerto("Otro Huerto");
		assertEquals(numeroInserciones, 1);
	}
	
	@Test
	@DisplayName("eliminarHuerto")
	public void eliminarHuerto() {

		int numeroEliminaciones = repository.eliminarHuerto(2);
		assertEquals(numeroEliminaciones, 1);
	}
	
	

	@BeforeEach
	public void despuesCadaTest() {
		log.debug("---------TERMINA EJECUCIÓN DE TEST----------");
	}

}
