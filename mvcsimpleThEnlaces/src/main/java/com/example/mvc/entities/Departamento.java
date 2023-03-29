package com.example.mvc.entities;

public class Departamento {
	
	private Integer id;	
	private String nombre;	
	private Integer managerId;		
	private Integer locationId;
	
	
	
	public Departamento() {
		
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



	public Integer getManagerId() {
		return managerId;
	}



	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}



	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}



	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", managerId=" + managerId + ", locationId="
				+ locationId + "]";
	}

	

}
