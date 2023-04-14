package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="persona_id")
	private int id;
	
	private String name;

	@ManyToMany(mappedBy = "personas")
	@JsonIgnoreProperties("personas")
	private Set<Huerto> huertos;
	
	
	public Persona() {
		super();
	}
		

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


	public Set<Huerto> getHuertos() {
		return huertos;
	}


	public void setHuertos(Set<Huerto> huertos) {
		this.huertos = huertos;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + "]";
	}
	

}
