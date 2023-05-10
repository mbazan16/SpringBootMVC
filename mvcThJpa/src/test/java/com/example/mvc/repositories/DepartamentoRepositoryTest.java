package com.example.mvc.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.mvc.entities.Departamento;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartamentoRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartamentoRepository employeeRepository;

	@Test
	public void findById() {
	    // given
	    Departamento departamento = new Departamento();
	    departamento.setId(1000);
	    departamento.setNombre("miDepartamento");
	    departamento.setManagerId(100);
	    departamento.setDireccionId(100);
	    entityManager.persist(departamento);
	    entityManager.flush();

	    // when
	    Departamento found = employeeRepository.findById(1000).get();

	    // then
	    assertThat(found.getNombre())
	      .isEqualTo(departamento.getNombre());
	}

}
