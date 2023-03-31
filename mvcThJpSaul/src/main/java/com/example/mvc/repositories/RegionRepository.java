package com.example.mvc.repositories;

import javax.swing.plaf.synth.Region;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entities.Departamento;

public interface RegionRepository<RegionRepository> extends JpaRepository<Region, Integer> {

}
