package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Huerto;
import com.example.demo.repositories.HuertoRepository;

@SpringBootTest
class HuertosImplTest {
	
	@Mock
	HuertoRepository dao;
	
	@InjectMocks
	HuertoImpl service; 
	
	
	
	@Test
	void testGetHuertos() {
		
		List<Huerto> listHuertos = new ArrayList<Huerto>();
		listHuertos.add(new Huerto());
		listHuertos.add(new Huerto());
		 // Arrange
        when(dao.findAll()).thenReturn(listHuertos);
        
     // Act & Assert
        assertThat(service.findAll()).hasSize(3);
        verify(dao, times(1)).findAll();
        
       
	}

}
