package com.example.mvc.bussiness;


import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mvc.common.exceptions.ServicioException;
import com.example.mvc.entities.Departamento;
import com.example.mvc.repositories.DepartamentoRepository;


//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ServicioDepartamentoImplTest {
	
	
	@Mock
    DepartamentoRepository mockRepository;
	
	@InjectMocks
	ServicioDepartamentoImpl servicio;
	
	Departamento departamento;
	
	@BeforeEach
	public void cargarDepartamento() {
		 departamento = new Departamento();
	    departamento.setId(1000);
	    departamento.setNombre("miDepartamento");
	    departamento.setManagerId(100);
	    departamento.setDireccionId(100);
	}
	
    
    @Test
    public void conseguirDepartamento() throws ServicioException {
    	
	    
        Mockito.when(mockRepository.findById(1000)).thenReturn(Optional.of(departamento));

        

        Assertions.assertEquals(1000, servicio.conseguirDepartamento(1000).getId());
        //verify(mockRepository, times(1)).count();
    }
    
    @DisplayName("JUnit test para conseguirDepartamento con ServiceExcepcion")
    @Test
    public void conseguirDepartamentoServiceException(){
        
    	 Mockito.when(mockRepository.findById(80))
                .thenReturn(null);

       

        // when -  action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(ServicioException.class, () -> {
            servicio.conseguirDepartamento(80);
        });

        
    }
    
   
}
