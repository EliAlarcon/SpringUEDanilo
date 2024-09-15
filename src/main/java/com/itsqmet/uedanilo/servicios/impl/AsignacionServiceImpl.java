package com.itsqmet.uedanilo.servicios.impl;

import java.util.List;
import java.util.Optional;

import com.itsqmet.uedanilo.modelo.entidades.Asignacion;
import com.itsqmet.uedanilo.modelo.repositorios.IAsignacionRepository;
import com.itsqmet.uedanilo.servicio.IAsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionServiceImpl implements IAsignacionService{

    @Autowired
    private IAsignacionRepository asignacionRepository;

    @Override
    public Asignacion createAsignacion(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    @Override
    public void deleteAsignacion(Integer id) {
        asignacionRepository.deleteById(id);
    }

    @Override
    public Optional<Asignacion> getAsignacionId(Integer id) {
        return asignacionRepository.findById(id);
    }

    @Override
    public List<Asignacion> getAsignaciones() {
        return asignacionRepository.findAll();
    }

    @Override
    public Asignacion updateAsignacion(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

}
