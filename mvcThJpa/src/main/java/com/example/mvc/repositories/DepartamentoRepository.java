package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
