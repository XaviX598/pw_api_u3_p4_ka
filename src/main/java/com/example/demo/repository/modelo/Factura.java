package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "Factura")
@Table(name = "factura")
public class Factura {
	
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura")

	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)

	@Column(name = "fact_id")

	private Integer id;

	@Column(name = "fact_codigo_factura")

	private String codigoFactura;
	
	@Column(name = "fact_fecha_emision")

	private LocalDateTime fechaEmision;
	
	@Column(name = "fact_fecha_expiracion")

	private LocalDateTime fechaExpiracion;

	@Column(name = "fact_detalles")

	private String detalles;

	@Column(name = "fact_total")

	private Integer total;

	@Column(name = "fact_codigo_barras")
	
	private String codigoDeBarras;

	@Override
	public String toString() {
		return "Factura [id=" + id + ", codigoFactura=" + codigoFactura + ", fechaEmision=" + fechaEmision
				+ ", fechaExpiracion=" + fechaExpiracion + ", detalles=" + detalles + ", total=" + total
				+ ", codigoDeBarras=" + codigoDeBarras + "]";
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	
	

}
