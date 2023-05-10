package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.Libro;

public interface LibroRepository extends JpaRepository<Libro,Integer>{

}
