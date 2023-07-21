package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestful {

	@Autowired
	private IHorarioService iHorarioService;

	@GetMapping(path = "/{codigo}")
	public Horario consultarPorCodigo(@PathVariable String codigo) {
		return this.iHorarioService.buscarPorCodigo(codigo);
	}

	@GetMapping
	public ResponseEntity<List<Horario>>  consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(this.iHorarioService.buscarTodos());
	}

	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.iHorarioService.ingresar(horario);
	}

	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);
		this.iHorarioService.actualizar(horario);
	}

	@PatchMapping(path = "{identificador}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) {
		Horario estu1 = this.iHorarioService.buscarID(identificador);
		estu1.setId(identificador);
		estu1.setNombreProfesor(horario.getNombreProfesor());
		this.iHorarioService.actualizar(estu1);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iHorarioService.eliminar(id);
	}

}
