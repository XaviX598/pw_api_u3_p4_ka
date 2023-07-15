package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")

	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)

	@Column(name = "mate_id")

	private Integer id;

	@Column(name = "mate_horas")

	private Integer horas;

	@Column(name = "mate_nombre")

	private String nombre;

	@Column(name = "mate_profesor")

	private String profesor;

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", horas=" + horas + ", nombre=" + nombre + ", profesor=" + profesor + "]";
	}
	
		
	
}
