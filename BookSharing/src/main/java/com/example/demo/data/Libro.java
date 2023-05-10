package com.example.demo.data;

import com.example.demo.common.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name="Libros")
public class Libro {
	
	 
	@Id
	@Column(name="Libros")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 @Column(name="nombre")
	private String nombre;
	
	@Column(name="tipo")
	private Tipo tipo;
	
	@Column(name="localizacion")
	private String localizacion;
	
	
	public Libro() {
		
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	

}
