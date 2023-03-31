package com.example.mvc.entities;

public class Region {

	private Integer id;

	private String nombre;

	private Integer managerId;
	

	private Integer direccionId;
	
	
	
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



	public Integer getManagerId() {
		return managerId;
	}



	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	public Integer getDireccionId() {
		return direccionId;
	}



	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}



	@Override
	public String toString() {
		return "Region [id=" + id + ", nombre=" + nombre + ", managerId=" + managerId + ", direccionId="
				+ direccionId + "]";
	}



	


	

	
	
	

}
