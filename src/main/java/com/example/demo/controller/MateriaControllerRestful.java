package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService iMateriaService;
//
	// GET
//	@GetMapping(path = "/buscar/{nombre}")
//	public ResponseEntity<List<Materia>>  consultarPorNombre(@PathVariable String nombre) {
//		List<Materia> list = this.iMateriaService.consultarPorNombre(nombre);
//		return  ResponseEntity.status(HttpStatus.OK).body(list);//para revisar que codigos tiene es HttpStatus
//	}

	@GetMapping(path = "{identificador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaTO> consultarPorId(@PathVariable Integer identificador) {
		return new ResponseEntity<>(this.iMateriaService.buscarPorId(identificador), null, 200);
	}

//	@PostMapping(path = "/guardar")
//	public void guardar(@RequestBody Materia materia) {
//		this.iMateriaService.guardar(materia);
//	}
//
//	@PutMapping(path = "/actualizar/{identificador}")
//	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
////		Integer identificador = 1; //el identificador de un estudiante de momento quemado
//		materia.setId(identificador);
//		this.iMateriaService.actualizar(materia);
//	}
//
//	@PatchMapping(path = "/actualizarParcial/{identificador}")
//	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {
////		Integer identificador = 1; //el identificador de un estudiante de momento quemado
//		Materia m1 = this.iMateriaService.consultarId(identificador);
//		m1.setId(identificador);
//		m1.setNombre(materia.getNombre());
//		this.iMateriaService.actualizar(m1);
//	}
//
//	@DeleteMapping(path = "/eliminar/{identificador}")
//	public void eliminar(@PathVariable Integer identificador) {
////		System.out.println(identificador);
////		Materia m = this.iMateriaService.consultarId(identificador);
//		this.iMateriaService.borrar(identificador);
//	}

}
