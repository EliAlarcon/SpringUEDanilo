package com.itsqmet.uedanilo.controlador;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itsqmet.uedanilo.modelo.entidades.Profesor;
import com.itsqmet.uedanilo.servicios.impl.ProfesorServiceImpl;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;

    @PostMapping("/profesor")
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor){
        try {
            Profesor savedProfesor = profesorServiceImpl.createProfesor(profesor);
            return ResponseEntity.ok(savedProfesor);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/profesor")
    public ResponseEntity<Profesor> updateProfesor(@RequestBody Profesor profesor){
        try {
            Profesor updatedProfesor = profesorServiceImpl.updatProfesor(profesor);
            return ResponseEntity.ok(updatedProfesor);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> getProfesores(){
        return new ResponseEntity<>(profesorServiceImpl.getProfesores(), HttpStatus.OK);
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Integer id){
        Optional<Profesor> profesor = profesorServiceImpl.getProfesorId(id);
        if (profesor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profesor.get(), HttpStatus.OK);
    }

    @DeleteMapping("/profesor/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Integer id){
        Optional<Profesor> profesor = profesorServiceImpl.getProfesorId(id);
        if (profesor.isPresent()) {
            profesorServiceImpl.deleteProfesor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
