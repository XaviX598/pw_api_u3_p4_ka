package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_horario")
	@SequenceGenerator(name = "seq_horario", sequenceName = "seq_horario", allocationSize = 1)
	@Column(name = "hora_id")
	private Integer id;

	@Column(name = "hora_codigo_clase")
	private String codigoClase;

	@Column(name = "hora_nombre_profesor")
	private String nombreProfesor;

	@Column(name = "hora_aula")
	private String aula;

	@Override
	public String toString() {
		return "Horario [id=" + id + ", codigoClase=" + codigoClase + ", nombreProfesor=" + nombreProfesor + ", aula="
				+ aula + "]";
	}

	// get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoClase() {
		return codigoClase;
	}

	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

}
