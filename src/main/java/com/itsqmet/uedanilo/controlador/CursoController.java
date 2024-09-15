package com.itsqmet.uedanilo.controlador;

import java.util.List;
import java.util.Optional;

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

import com.itsqmet.uedanilo.modelo.entidades.Curso;
import com.itsqmet.uedanilo.servicios.impl.CursoServiceImpl;

@RestController
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoServiceImpl;

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        try {
            Curso savedCurso = cursoServiceImpl.createCurso(curso);
            return new ResponseEntity<>(savedCurso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso){
        try {
           Curso updatedCurso = cursoServiceImpl.updateCurso(curso);
           return new ResponseEntity<>(updatedCurso, HttpStatus.OK); 
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos(){
        return new ResponseEntity<>(cursoServiceImpl.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Integer id){
        Optional<Curso> curso = cursoServiceImpl.getCursoId(id);
        if (curso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Integer id){
        Optional<Curso> curso = cursoServiceImpl.getCursoId(id);
        if (curso.isPresent()) {
            cursoServiceImpl.deleteCurso(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
