package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public List<Materia> buscarPorNombre(String nombre);
	
	public void insertar(Materia materia);

}
