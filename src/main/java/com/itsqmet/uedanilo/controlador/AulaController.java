package com.itsqmet.uedanilo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsqmet.uedanilo.modelo.entidades.Aula;
import com.itsqmet.uedanilo.servicios.impl.AulaServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaServiceImpl aulaServiceImpl;

    @PostMapping
    public ResponseEntity<Aula> createAula(@RequestBody Aula aula){
        try {
            Aula savedAula = aulaServiceImpl.createAula(aula);
            return new ResponseEntity<>(savedAula, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Aula> updateAula(@RequestBody Aula aula) {
        try {
            Aula updatedAula = aulaServiceImpl.updateAula(aula);
            return new ResponseEntity<>(updatedAula, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Aula>> getAulas() {
        return new ResponseEntity<>(aulaServiceImpl.getAulas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> getAulaById(@PathVariable Integer id) {
        Optional<Aula> aula = aulaServiceImpl.getAulaId(id);
        if (aula.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aula.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Integer id){
        Optional<Aula> aula = aulaServiceImpl.getAulaId(id);
        if (aula.isPresent()) {
            aulaServiceImpl.deleteAula(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    
}
