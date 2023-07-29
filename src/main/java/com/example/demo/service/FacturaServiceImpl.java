package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.modelo.Factura;

//tarea realizada antes pero ya esta subido a github y es por eso este comentario
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public Factura buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public void ingresar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	public Factura guardarYBuscar(Factura factura) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.guardarYDevolver(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.actualizar(factura);
	}

	@Override
	public void actualizarParcial(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.actualizarParcial(codigoActual, codigoNuevo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.borrar(id);
	}

	@Override
	public List<Factura> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarTodos();
	}

	@Override
	public Factura buscarID(Integer id) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarID(id);
	}

}
