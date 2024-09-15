package com.itsqmet.uedanilo.servicio;

import java.util.List;
import java.util.Optional;

import com.itsqmet.uedanilo.modelo.entidades.Estudiante;

public interface IEstudianteService {

    Estudiante createEstudiante(Estudiante estudiante);

    Estudiante updateEstudiante(Estudiante estudiante);

    List<Estudiante> getEstudiantes();

    Optional<Estudiante> getEstudianteId(Integer id);

    void deleteEstudiante(Integer id);

}
