package com.example.mvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Region {
	
	
	@Id
	@Column(name = "REGION_ID")
	private Integer id;
	
	@Column(name = "REGION_NAME")
	private String nombre;
	
	
	
	public Region() {
		
	}


	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String name) {
		this.nombre = name;
	}
	
	
	
	@Override
	public String toString() {
		return "Region [id=" + id + ", nombre=" + nombre + "]";
	
	}
}

