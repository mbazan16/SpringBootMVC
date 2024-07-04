package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>  {

}
