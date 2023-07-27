package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public Factura seleccionarPorCodigo(String codigo);

	public void insertar(Factura factura);

	public Factura guardarYDevolver(Factura factura);

	public void actualizar(Factura factura);

	public void actualizarParcial(String codigoActual, String codigoNuevo);

	public void borrar(Integer id);

	public List<Factura> buscarTodos();

	public Factura buscarID(Integer id);

}
