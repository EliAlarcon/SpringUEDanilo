package com.itsqmet.uedanilo.controlador;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itsqmet.uedanilo.modelo.entidades.Estudiante;
import com.itsqmet.uedanilo.servicios.impl.EstudianteServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;





@Controller
public class EstudianteController {

    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;

    //READ
    @GetMapping("/estudiantes")
    public String getEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteServiceImpl.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/listarEstudiantes";
    }

    //CREATE
    @GetMapping("/estudiante/registro")
    public String formulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formEstudiante";
    }

    @PostMapping("/estudiante/registro")
    public String crearEstudiante(Estudiante estudiante) {
        estudianteServiceImpl.createEstudiante(estudiante);
        return "redirect:/estudiantes";
    }
    
    //UPDATE
    @GetMapping("/estudiante/editar/{id}")
    public String formulario(@PathVariable Integer id, Model model){
        Optional<Estudiante> estudiante = estudianteServiceImpl.getEstudianteId(id);
        model.addAttribute("estudiante", estudiante);
        return "estudiante/formEstudiante";
    }

    //DELETE
    @GetMapping("/estudiante/eliminar/{id}")
    public String deleteEstudiante(@PathVariable Integer id) {
        estudianteServiceImpl.deleteEstudiante(id);
        return "redirect:/estudiantes";
    }
    
    
}
