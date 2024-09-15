package com.itsqmet.uedanilo.servicio;

import java.util.List;
import java.util.Optional;

import com.itsqmet.uedanilo.modelo.entidades.Asignacion;

public interface IAsignacionService {

    Asignacion createAsignacion (Asignacion asignacion);

    Asignacion updateAsignacion(Asignacion asignacion);

    List<Asignacion> getAsignaciones();

    Optional<Asignacion> getAsignacionId(Integer id);

    void deleteAsignacion(Integer id);
}
