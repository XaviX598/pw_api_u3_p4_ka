package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService iMateriaService;

	// GET
	@GetMapping(path = "/buscar")
	public List<Materia> consultarPorNombre() {
		String nombre = "programacion";
		return this.iMateriaService.consultarPorNombre(nombre);
	}

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.iMateriaService.guardar(materia);
	}
//	@PutMapping(path = "/actualizar")
//	public void actualizar() {
//		
//	}
//	@PatchMapping(path="/actualizarParcial")
//	public void actualizarParcial() {
//		
//	}
//	@DeleteMapping(path="/borrar")
//	public void borrar() {
//		
//	}

}
