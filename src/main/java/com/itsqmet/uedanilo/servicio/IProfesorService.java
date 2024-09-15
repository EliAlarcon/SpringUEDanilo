package com.itsqmet.uedanilo.servicio;

import java.util.List;
import java.util.Optional;

import com.itsqmet.uedanilo.modelo.entidades.Profesor;

public interface IProfesorService {

    Profesor createProfesor(Profesor profesor);

    Profesor updatProfesor(Profesor profesor);

    List<Profesor> getProfesores();

    Optional<Profesor> getProfesorId(Integer id);

    void deleteProfesor(Integer id);
}
