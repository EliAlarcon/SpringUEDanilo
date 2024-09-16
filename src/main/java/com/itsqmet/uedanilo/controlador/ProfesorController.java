package com.itsqmet.uedanilo.controlador;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.itsqmet.uedanilo.modelo.entidades.Profesor;
import com.itsqmet.uedanilo.servicios.impl.ProfesorServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;

    //READ
    @GetMapping("/profesores")
    public String getProfesores(Model model) {
        List<Profesor> profesores = profesorServiceImpl.getProfesores();
        model.addAttribute("profesores", profesores);
        return "profesor/listarProfesores";
    }

    //CREATE
    @GetMapping("/profesor/registro")
    public String formulario(Model model){
        model.addAttribute("profesor", new Profesor());
        return "profesor/formProfesor";
    }

    @PostMapping("/profesor/registro")
    public String createProfesor(Profesor profesor) {
        profesorServiceImpl.createProfesor(profesor);
        
        return "redirect:/profesores";
    }

    //UPDATE
    @GetMapping("/profesor/editar/{id}")
    public String updateProfesor(@PathVariable Integer id, Model model){
        Optional<Profesor> profesor = profesorServiceImpl.getProfesorId(id);
        model.addAttribute("profesor", profesor);
        return "profesor/formProfesor";
    }

    //DELETE
    @GetMapping("/profesor/eliminar/{id}")
    public String deleteProfesor(@PathVariable Integer id){
        profesorServiceImpl.deleteProfesor(id);
        return "redirect:/profesores";
    }
    
    
    
}
