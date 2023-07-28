package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		List<Materia> lista = this.iMateriaRepository.buscarPorCedulaEstudiante(cedula);
		List<MateriaTO> listaTO = lista.stream().map(materia -> this.convertir(materia)).collect(Collectors.toList());
		return listaTO;
	}

	private MateriaTO convertir(Materia m) {
		MateriaTO mat = new MateriaTO();
		mat.setId(m.getId());
		mat.setNombre(m.getNombre());
		mat.setNumeroCreditos(m.getNumeroCreditos());
		return mat;
	}

	@Override
	public MateriaTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Materia m = this.iMateriaRepository.buscarPorId(id);
		return this.convertir(m);
	}

}
