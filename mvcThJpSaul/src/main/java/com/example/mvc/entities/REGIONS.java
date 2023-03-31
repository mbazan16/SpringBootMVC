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
@Table(name="Regions")
@NamedQuery(name ="REGIONS.findAll",query = "SELECT d FROM Regions d")
public class REGIONS {
	@Id
	@Column(name="REGION_ID")
	private Integer id;
	@Column(name="REGION_NAME")
	private String nombre;
	
	
	
public REGIONS()
{
	
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
	return "REGIONS [id=" + id + ", nombre=" + nombre + "]";
}


	
	
	
	
	

	


	

	
	
	

}
