package com.itsqmet.uedanilo.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Curso implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String grado;
    private char paralelo;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Aula> aulas = new ArrayList<>();
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones = new ArrayList<>();

}
