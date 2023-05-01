package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.entities.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

}
