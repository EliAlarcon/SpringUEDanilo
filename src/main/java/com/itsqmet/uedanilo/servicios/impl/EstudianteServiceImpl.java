package com.itsqmet.uedanilo.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.uedanilo.modelo.entidades.Estudiante;
import com.itsqmet.uedanilo.modelo.repositorios.IEstudianteRepository;
import com.itsqmet.uedanilo.servicio.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteEstudiante(Integer id) {
        estudianteRepository.deleteById(id);
        
    }

    @Override
    public Optional<Estudiante> getEstudianteId(Integer id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante updateEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
}
