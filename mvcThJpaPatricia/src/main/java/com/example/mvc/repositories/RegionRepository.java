package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entities.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{

}
