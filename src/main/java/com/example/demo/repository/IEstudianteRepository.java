package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionarPorCedula(String cedula);
	
	public void insertar(Estudiante estudiante);
	
	public Estudiante guardarYDevolver(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public void actualizarParcial(String cedulaActual, String cedulaNueva);
	
	public void borrar(Integer id);
	
	public List<Estudiante> buscarTodosProvincia(String provincia);
	
	public List<Estudiante> buscarTodos();
	
	public Estudiante buscarID(Integer id);

}
