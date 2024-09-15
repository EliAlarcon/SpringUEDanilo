package com.itsqmet.uedanilo.servicio;

import java.util.List;
import java.util.Optional;

import com.itsqmet.uedanilo.modelo.entidades.Curso;

public interface ICursoService {

    Curso createCurso(Curso curso);

    Curso updateCurso(Curso curso);

    List<Curso> getCursos();

    Optional<Curso> getCursoId(Integer id);

    void deleteCurso(Integer id);
}
