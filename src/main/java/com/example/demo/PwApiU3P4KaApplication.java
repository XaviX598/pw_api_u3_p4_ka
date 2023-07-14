package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;




@SpringBootApplication
public class PwApiU3P4KaApplication implements CommandLineRunner{
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IMateriaService iMateriaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P4KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(this.iEstudianteService.consultarPorCedula("1724441041"));	
//		System.out.println(this.iMateriaService.consultarPorNombre("programacion"));	
	}

}
