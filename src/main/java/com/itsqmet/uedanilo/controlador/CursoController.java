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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @PostMapping("/curso/registro")
    public String crearCurso(Curso curso) {
        cursoServiceImpl.createCurso(curso);
        
        return "redirect:/cursos";
    }

    //UPDATE
    @GetMapping("/curso/editar/{id}/{idProfesor}")
    public String updateCurso(@PathVariable Integer id, @PathVariable Integer idProfesor, Model model){
        Optional<Curso> curso = cursoServiceImpl.getCursoId(id);
        Optional<Profesor> profesor = profesorServiceImpl.getProfesorId(idProfesor);
        model.addAttribute("curso", curso);
        model.addAttribute("profesor", profesor);
        return "curso/formCurso";
    }
    
    //DELETE
    @GetMapping("/curso/eliminar/{id}")
    public String deleteCurso(@PathVariable Integer id){
        cursoServiceImpl.deleteCurso(id);
        return "redirect:/cursos";
    }
}
