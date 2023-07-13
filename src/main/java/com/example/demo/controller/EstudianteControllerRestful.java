package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;


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
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) { //para indicar que Estduainte debe ir en el cuerpo del request
		this.iEstudianteService.guardar(estudiante);
	}
	@PutMapping(path = "/actualizar")
	public void actualizar() {
		
	}
	@PatchMapping(path="/actualizarParcial")
	public void actualizarParcial() {
		
	}
	@DeleteMapping(path="/borrar")
	public void borrar() {
		
	}
}
