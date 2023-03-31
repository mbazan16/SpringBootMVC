package com.example.mvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="REGIONS")
@NamedQuery(name ="Region.findAll",query = "SELECT d FROM Region d")
public class Region {
	@Id
	@Column(name="REGION_ID")
	private Integer id;
	@Column(name="REGION_NAME")
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



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return "Region [id=" + id + ", nombre=" + nombre + "]";
	}



	


	



	
	


	


	

	
	
	

}
