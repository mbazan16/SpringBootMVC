package com.lets.videoclub.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="PELICULAS")
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
//TODO: preguntar el @NamedQuery
//TODO: preguntar el th:object="${pelicula/departamento}"
public class Pelicula {
	@Id
	@Column(name="PELICULA_ID")
	private Integer id;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="ANIO")
	private Integer anio;
	@Column(name="DIRECTOR")
	private String director;
	@Column(name="SINOPSIS")
	private String sinopsis;
	@Column(name="GENERO_ID")
	private Integer generoId;
	@Column(name="URL_CARATULA")
	private String urlCaratula;
	
	public Pelicula() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getYear() {
		return anio;
	}

	public void setYear(Integer year) {
		this.anio = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Integer getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Integer generoId) {
		this.generoId = generoId;
	}

	public String getUrlCaratula() {
		return urlCaratula;
	}

	public void setUrlCaratula(String urlCaratula) {
		this.urlCaratula = urlCaratula;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", year=" + anio + ", director=" + director + ", sinopsis="
				+ sinopsis + ", generoId=" + generoId + ", urlCaratula=" + urlCaratula + "]";
	}

}
