package com.example.mvc.repositories;

import java.util.List;
import java.util.Optional;

import com.example.mvc.entities.Departamento;

public interface DepartamentoRepository extends RegionRepository<Departamento, Integer> {

	List<Departamento> findAll();

	Optional<Departamento> findById(Integer idDepartamento);

	Departamento save(Departamento departamento);

	void deleteById(Integer idDepartamento);

}
