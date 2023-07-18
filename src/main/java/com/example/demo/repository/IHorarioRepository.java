package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioRepository {
	
	public Horario seleccionarPorCodigo(String codigo);

	public void insertar(Horario horario);

	public void actualizar(Horario horario);

	public void actualizarParcial(String nombreActual, String nombreNuevo);

	public void borrar(Integer id);

//	public List<Horario> buscarTodosProvincia(String provincia);

	public List<Horario> buscarTodos();

	public Horario buscarID(Integer id);

}
