package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {

	public List<Materia> consultarPorNombre(String nombre);

	public void guardar(Materia materia);

	public void actualizar(Materia materia);

	public void borrar(Integer id);

	public Materia consultarId(Integer id);
}
