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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsqmet.uedanilo.modelo.entidades.Asignacion;
import com.itsqmet.uedanilo.servicios.impl.AsignacionServiceImpl;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {

    @Autowired
    private AsignacionServiceImpl asignacionServiceImpl;

    @PostMapping
    public ResponseEntity<Asignacion> createAsignacion(@RequestBody Asignacion asignacion) {
        try {
            Asignacion savedAsignacion = asignacionServiceImpl.createAsignacion(asignacion);
            return new ResponseEntity<>(savedAsignacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity<Asignacion> updateAsignacion(@RequestBody Asignacion asignacion) {
        try {
            Asignacion savedAsignacion = asignacionServiceImpl.updateAsignacion(asignacion);
            return new ResponseEntity<>(savedAsignacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<List<Asignacion>> getAsignaciones() {
        return new ResponseEntity<>(asignacionServiceImpl.getAsignaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignacion> getAsignacionById(@PathVariable Integer id) {
        Optional<Asignacion> asignacion = asignacionServiceImpl.getAsignacionId(id);
        if (asignacion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asignacion.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignacion(@PathVariable Integer id) {
        Optional<Asignacion> asignacion = asignacionServiceImpl.getAsignacionId(id);
        if (asignacion.isPresent()) {
            asignacionServiceImpl.deleteAsignacion(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
