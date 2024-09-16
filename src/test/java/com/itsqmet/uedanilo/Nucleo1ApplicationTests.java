package com.itsqmet.uedanilo;

//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.itsqmet.uedanilo.modelo.entidades.Profesor;
//import com.itsqmet.uedanilo.servicio.IProfesorService;

@SpringBootTest(classes = Nucleo1Application.class)
class Nucleo1ApplicationTests {

	@Autowired
	//private IProfesorService servicio;

	@Test
	void contextLoads() {

		/*Profesor nuevo = new Profesor();
		nuevo.setNombreProfesor("Boris");
		nuevo.setApellidoProfesor("Luna");
		nuevo.setEmail("boris@gmail.com");
		nuevo.setEspecialidad("Físico Matemático");
		servicio.createProfesor(nuevo);

		List<Profesor> resultado = servicio.getProfesores();
		for(Profesor profesor: resultado){
			System.out.println(profesor.getNombreProfesor()+" "+profesor.getApellidoProfesor());
		}*/
	}

}
