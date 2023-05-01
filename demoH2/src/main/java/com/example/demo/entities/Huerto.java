package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "Huerto.encuentraPorNombreNamedQuery",query="Select h from Huerto h where h.name=:name")
public class Huerto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	@ManyToMany
	@JoinTable(name="personas_huertos", 
			   joinColumns= @JoinColumn(name="persona_id"),
			   inverseJoinColumns = @JoinColumn(name="huerto_id"))
	@JsonIgnore
	private Set<Persona> personas;
		

	/* Constructor obligatorio*/
	public Huerto() {
		super();
	}
	
	

	public Huerto(String name) {
		super();
		this.name = name;
	}


	/* Metodos de acceso. Getter/Setter. Obligatorios*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Set<Persona> getPersonas() {
		return personas;
	}



	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}



	@Override
	public String toString() {
		return "Huerto [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
