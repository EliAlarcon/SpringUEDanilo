package com.itsqmet.uedanilo.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.uedanilo.modelo.entidades.Aula;
import com.itsqmet.uedanilo.modelo.repositorios.IAulaRepository;
import com.itsqmet.uedanilo.servicio.IAulaService;

@Service
public class AulaServiceImpl implements IAulaService{

    @Autowired
    private IAulaRepository aulaRepository;

    @Override
    public Aula createAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public void deleteAula(Integer id) {
        aulaRepository.deleteById(id);
        
    }

    @Override
    public Optional<Aula> getAulaId(Integer id) {
        return aulaRepository.findById(id);
    }

    @Override
    public List<Aula> getAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public Aula updateAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    
}
