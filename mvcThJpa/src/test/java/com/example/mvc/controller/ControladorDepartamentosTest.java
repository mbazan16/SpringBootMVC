package com.example.mvc.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mvc.bussiness.ServicioDepartamento;
import com.example.mvc.entities.Departamento;

@WebMvcTest(ControladorDepartamentos.class)

class ControladorDepartamentosTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServicioDepartamento servicio;

	@Test
	public void testDepartamentos() throws Exception {
		
		List<Departamento> departamentos = new ArrayList<Departamento>();
		Departamento departamento = new Departamento();
 	    departamento.setId(1000);
 	    departamento.setNombre("miDepartamento");
 	    departamento.setManagerId(100);
 	    departamento.setDireccionId(100);
		departamentos.add(departamento);
		
		
		when(servicio.listDepartamentos()).thenReturn(departamentos);
		
		
		
		this.mockMvc.perform(get("/departamentos"))
				.andExpect(status().isOk())
				.andExpect(view().name("departamentos"))
			    .andExpect(model().attributeExists("departamentos"))
				.andDo(print());
		
		Mockito.verify(servicio, times(1)).listDepartamentos();
		 
	}
   

    @Test
    @Disabled
    public void testDepartamento() throws Exception {
    	Departamento departamento = new Departamento();
 	    departamento.setId(1000);
 	    departamento.setNombre("miDepartamento");
 	    departamento.setManagerId(100);
 	    departamento.setDireccionId(100);
 	    
        // given
    	 Mockito.when(servicio.conseguirDepartamento(1000))
    	 .thenReturn(departamento);

        // when
    	 this.mockMvc
	      .perform(get("/departamentos/1000"))
	      .andExpect(status().isOk())
	      .andExpect(view().name("departamento"))
	      .andExpect(model().attributeExists("departamentoooo"));
    	 
    	 Mockito.verify(servicio, times(1)).conseguirDepartamento(1000);

          
    }


}
