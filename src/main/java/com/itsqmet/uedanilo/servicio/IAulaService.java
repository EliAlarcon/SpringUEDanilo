package com.itsqmet.uedanilo.servicio;

import java.util.List;
import java.util.Optional;

import com.itsqmet.uedanilo.modelo.entidades.Aula;

public interface IAulaService {

    Aula createAula(Aula aula);

    Aula updateAula(Aula aula);

    List<Aula> getAulas();

    Optional<Aula> getAulaId(Integer id);

    void deleteAula(Integer id);
}
