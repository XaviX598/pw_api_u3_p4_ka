package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {

	public List<Materia> buscarPorNombre(String nombre);

	public void insertar(Materia materia);

	public void actualizar(Materia materia);

	public void actualizarParcial(String horasActual, String horasNuevo);

	public void borrar(Integer id);
	
	public Materia buscarID(Integer id);

}
