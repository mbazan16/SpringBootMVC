package com.lets.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lets.videoclub.entities.Pelicula;

public interface PeliculaRepository extends JpaRepository <Pelicula, Integer>{

}
