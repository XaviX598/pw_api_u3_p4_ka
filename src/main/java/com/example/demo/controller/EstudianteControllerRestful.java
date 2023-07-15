package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes") // aqui ponermos el path de ese controlador, debe estar en PLURAL y con el
								// nombre del modelo
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService iEstudianteService;

	// GET
	@GetMapping(path = "/{cedula}") // path variable es la tura de la variable
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.iEstudianteService.consultarPorCedula(cedula);
	}

	// para buscar todos sin filtro
//	@GetMapping // path variable es la tura de la variable
//	public List<Estudiante> consultarTodos() {
//		return this.iEstudianteService.buscarTodos();
//	}

	// lo mismo que arriba pero para filtrar
	@GetMapping // path variable es la tura de la variable
	public List<Estudiante> consultarTodosProvincia(@RequestParam String provincia) {
		// para buscar seria /buscarTodos?provincia=pichincha
		return this.iEstudianteService.buscarTodosProvincia(provincia);
	}

	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) { // para indicar que Estduainte debe ir en el cuerpo del													// request
		this.iEstudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.iEstudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		Estudiante estu1 = this.iEstudianteService.consultarId(identificador);
		estu1.setId(identificador);
		estu1.setCedula(estudiante.getCedula());
		this.iEstudianteService.actualizar(estu1);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iEstudianteService.eliminar(id);
	}

}
