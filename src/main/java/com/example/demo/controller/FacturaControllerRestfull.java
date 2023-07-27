package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.repository.modelo.Factura;
import com.example.demo.service.IFacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaControllerRestfull {

	@Autowired
	private IFacturaService iFacturaService;
	
	
		@GetMapping(path = "/{codigo}", produces = "application/xml")
		@ResponseStatus(HttpStatus.OK)
		public Factura consultarPorCodigo(@PathVariable String codigo) {
		
			return this.iFacturaService.buscarPorCodigo(codigo);
		}
		
		@GetMapping
		public ResponseEntity<List<Factura>> consultarTodos() {
			List<Factura> list = this.iFacturaService.buscarTodos();
			HttpHeaders cabeceras = new HttpHeaders();
			cabeceras.add("detalleMensaje", "consulta exitosa");
			cabeceras.add("valorApi", "Incalculable");
			return new ResponseEntity<>(list, cabeceras, 228);
		}
		
		@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
		public Factura guardarYDevolver(@RequestBody Factura factura) {
			return this.iFacturaService.guardarYBuscar(factura);
		}

		@PutMapping(path = "/{identificador}")
		public void actualizar(@RequestBody Factura factura, @PathVariable Integer identificador) {
			factura.setId(identificador);
			this.iFacturaService.actualizar(factura);
		}

		@PatchMapping(path = "{identificador}")
		public void actualizarParcial(@RequestBody Factura factura, @PathVariable Integer identificador) {
			Factura fact1 = this.iFacturaService.buscarID(identificador);
			fact1.setId(identificador);
			fact1.setCodigoDeBarras(factura.getCodigoFactura());
			this.iFacturaService.actualizar(fact1);
		}

		@DeleteMapping(path = "/{id}")
		public void borrar(@PathVariable Integer id) {
			this.iFacturaService.eliminar(id);
		}
}
