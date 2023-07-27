package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Factura;

public interface IFacturaService {
	
	public Factura buscarPorCodigo(String codigo);

	public void ingresar(Factura factura);

	public Factura guardarYBuscar(Factura factura);

	public void actualizar(Factura factura);

	public void actualizarParcial(String codigoActual, String codigoNuevo);

	public void eliminar(Integer id);

	public List<Factura> buscarTodos();

	public Factura buscarID(Integer id);

}
