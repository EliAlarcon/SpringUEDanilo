package com.itsqmet.uedanilo.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "profesores")
public class Profesor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfesor;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String email;
    private String especialidad;
    
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Curso> cursos = new ArrayList<>();
}
