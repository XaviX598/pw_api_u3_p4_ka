package com.example.demo.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(20);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		this.iEstudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodos();
	}
	


	@Override
	public Estudiante consultarId(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarID(id);
	}

	@Override
	public List<Estudiante> buscarTodosProvincia(String provincia) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodosProvincia(provincia);
	}

	@Override
	public Estudiante insertarYDevolver(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.guardarYDevolver(estudiante);
	}

	@Override
	public List<EstudianteTO> consultarTodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.iEstudianteRepository.buscarTodos();
		List<EstudianteTO> listaTO =  lista.stream().map(estudiante -> this.convertir(estudiante)).collect(Collectors.toList()); //crea una lista de estduianteTO a partir de cada elemento de la lista de estudiantes
		return listaTO;
	}
	
	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estu = new EstudianteTO();
		estu.setId(estudiante.getId());
		estu.setApellido(estudiante.getApellido());
		estu.setCedula(estudiante.getCedula());
		estu.setNombre(estudiante.getNombre());
		estu.setProvincia(estudiante.getProvincia());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		return estu;
	}


}
