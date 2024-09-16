package com.itsqmet.uedanilo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.itsqmet.uedanilo.modelo.entidades.Curso;
import com.itsqmet.uedanilo.modelo.entidades.Profesor;
import com.itsqmet.uedanilo.servicios.impl.CursoServiceImpl;
import com.itsqmet.uedanilo.servicios.impl.ProfesorServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoServiceImpl;

    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;

    //READ
    @GetMapping("/cursos")
    public String getCursos(Model model) {
        List<Curso> cursos = cursoServiceImpl.getCursos();
        model.addAttribute("cursos", cursos);
        return "curso/listarCursos";
    }
    
    //CREATE
    @GetMapping("/curso/registro")
    public String formulario(Model model) {
        List<Profesor> profesores = profesorServiceImpl.getProfesores();
        model.addAttribute("curso", new Curso());
        model.addAttribute("profesoresList", profesores);
        return "curso/formCurso";
    }

    /*@PostMapping("/curso/registro")
    public String postMethodName(Curso curso) {
        cursoServiceImpl.createCurso(curso);
        
        return "redirect:/cursos";
    }*/
    
    
}
