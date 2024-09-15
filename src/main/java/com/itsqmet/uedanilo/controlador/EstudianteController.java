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

import com.itsqmet.uedanilo.modelo.entidades.Estudiante;
import com.itsqmet.uedanilo.servicios.impl.EstudianteServiceImpl;

@RestController
public class EstudianteController {

    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;

    @PostMapping("/estudiante")
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante savedEstudiante = estudianteServiceImpl.createEstudiante(estudiante);
            return new ResponseEntity<>(savedEstudiante, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/estudiante")
    public ResponseEntity<Estudiante> updateEstudiante(@RequestBody Estudiante estudiante){
        try {
            Estudiante updatedEstudiante = estudianteServiceImpl.updateEstudiante(estudiante);
            return new ResponseEntity<>(updatedEstudiante, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return new ResponseEntity<>(estudianteServiceImpl.getEstudiantes(), HttpStatus.OK);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Integer id){
        Optional<Estudiante> estudiante = estudianteServiceImpl.getEstudianteId(id);
        if (estudiante.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estudiante.get(), HttpStatus.OK);
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Integer id){
        Optional<Estudiante> estudiante = estudianteServiceImpl.getEstudianteId(id);
        if (estudiante.isPresent()) {
            estudianteServiceImpl.deleteEstudiante(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
