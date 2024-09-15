package com.itsqmet.uedanilo.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.uedanilo.modelo.entidades.Curso;
import com.itsqmet.uedanilo.modelo.repositorios.ICursoRepository;
import com.itsqmet.uedanilo.servicio.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepository;

    @Override
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Integer id) {
        cursoRepository.deleteById(id);
        
    }

    @Override
    public Optional<Curso> getCursoId(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso updateCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

}
