package com.itsqmet.uedanilo.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.uedanilo.modelo.entidades.Profesor;
import com.itsqmet.uedanilo.modelo.repositorios.IProfesorRepository;
import com.itsqmet.uedanilo.servicio.IProfesorService;

@Service
public class ProfesorServiceImpl implements IProfesorService{

    @Autowired
    private IProfesorRepository profesorRepository;

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public void deleteProfesor(Integer id) {
        profesorRepository.deleteById(id);
        
    }

    @Override
    public Optional<Profesor> getProfesorId(Integer id) {
        return profesorRepository.findById(id);
    }

    @Override
    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor updatProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

}
