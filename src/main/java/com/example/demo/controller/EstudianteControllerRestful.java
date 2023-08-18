package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/estudiantes") // aqui ponermos el path de ese controlador, debe estar en PLURAL y con el
								// nombre del modelo
@CrossOrigin
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService iEstudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	// GET
	@GetMapping(path = "/{cedula}", produces = "application/json") // path variable es la tura de la variable, esta api
																	// no consume un body solo lo produce
	// grapper que nos permite envolver el objeto
	@ResponseStatus(HttpStatus.OK) // tambien se puede poner el codigo asi
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.iEstudianteService.consultarPorCedula(cedula);
	}

	// para buscar todos sin filtro
	@GetMapping(produces = "application/json") // path variable es la tura de la variable
	public ResponseEntity<List<Estudiante>> consultarTodos() {
		List<Estudiante> list = this.iEstudianteService.buscarTodos();
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detalleMensaje", "Cuidadanos consultados correctamente");
		cabeceras.add("valorApi", "Incalculable");
		return new ResponseEntity<>(list, cabeceras, 228);
	}

	// lo mismo que arriba pero para filtrar
//	@GetMapping // path variable es la tura de la variable
//	public  ResponseEntity<List<Estudiante>> consultarTodosProvincia(@RequestParam String provincia) {
//		// para buscar seria /buscarTodos?provincia=pichincha
//		List<Estudiante> lista = this.iEstudianteService.buscarTodosProvincia(provincia);
//		
//		//si queremos usar la cabecera para mandar un mensaje 
//		
//	OF
//		return new ResponseEntity<>(lista, cabeceras, 228)
//	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) // enves de  "application/xml" se pued poner tambien lo de aqui
	public void guardar(@RequestBody Estudiante estudiante) { // para indicar que Estduainte debe ir en el cuerpo del //
																// request
		this.iEstudianteService.guardar(estudiante);
	}

	@GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS() {
		List<EstudianteTO> lista = this.iEstudianteService.consultarTodosTO();
		for (EstudianteTO e : lista) {
			// primero construkmos el link de cada objeto estudianteTO
			Link myLink = linkTo(methodOn(EstudianteControllerRestful.class).buscarPorEstudiante(e.getCedula()))
					.withRel("materias");
			e.add(myLink);
		}
		return new ResponseEntity<>(lista, null, 200);

	}

	@GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {
		List<MateriaTO> lista = this.iMateriaService.buscarPorCedulaEstudiante(cedula);
		for (MateriaTO m : lista) {
			Link myLink = linkTo(methodOn(MateriaControllerRestful.class).consultarPorId(m.getId())).withSelfRel();
			m.add(myLink);
		}
		return new ResponseEntity<>(lista, null, 200);
	}

//	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
//	public Estudiante guardarYDevolver(@RequestBody Estudiante estudiante) {
//		return this.iEstudianteService.insertarYDevolver(estudiante);
//	}

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
