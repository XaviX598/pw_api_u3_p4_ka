package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demo.service.IEstudianteService;
import com.example.demo.modelo.Estudiante;

@RestController
@RequestMapping("/estudiantes") // aqui ponermos el path de ese controlador, debe estar en PLURAL y con el
								// nombre del modelo
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService iEstudianteService;
	
	//GET
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1724441041";
		return this.iEstudianteService.consultarPorCedula(cedula);
	}
}
