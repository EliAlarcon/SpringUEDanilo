package com.itsqmet.uedanilo.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "asignaciones")
public class Asignacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignacion;
    private Date fechaAsignacion;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;

}
