package com.example.demo.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entities.Huerto;
import com.example.demo.repositories.HuertoRepository;
import com.example.demo.services.interfaces.HuertoServ;

@WebMvcTest(HuertoController.class)
class HuertoControllerTest {
	Logger log = LoggerFactory.getLogger(HuertoControllerTest.class);
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private HuertoServ service;
	
	

	@Test
	public void list() throws Exception {
		
		List<Huerto> huertos = new ArrayList<Huerto>();
		huertos.add(new Huerto("Mi Huerto"));
		
		
		when(service.findAll()).thenReturn(huertos);
		
		
		
		this.mockMvc.perform(get("/huerto"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(huertos.size()))
				.andDo(print());
		 
	}
	
	
}
