package com.example.mvc.repositories;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.synth.Region;

import com.example.mvc.entities.Departamento;

public interface RegionRepository<Region, Integer> {

	List<Region> findAll();

	Optional<Region> findById(Integer idRegion);

	Region save(Region region);



}
