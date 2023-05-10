package com.example.mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mvc.bussiness.ServicioDepartamento;

@WebMvcTest(ControladorDepartamentos.class)
class ControladorDepartamentosTest {

	/*@MockBean
	ServicioDepartamento servicio;
	
	 
	  @Test
	  void shouldAllowAccessForAnonymousUser() throws Exception {
	    this.mockMvc
	      .perform(get("/departamentos"))
	      .andExpect(status().isOk())
	      .andExpect(view().name("departamentos"))
	      .andExpect(model().attributeExists("departamentos"));
	  }*/

}
