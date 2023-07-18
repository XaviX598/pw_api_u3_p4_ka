package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService{
	
	@Autowired
	private IHorarioRepository iHorarioRepository;

	@Override
	public Horario buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iHorarioRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public void ingresar(Horario horario) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.actualizar(horario);
	}


	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iHorarioRepository.borrar(id);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iHorarioRepository.buscarTodos();
	}

	@Override
	public Horario buscarID(Integer id) {
		// TODO Auto-generated method stub
		return this.iHorarioRepository.buscarID(id);
	}
	
	

}
