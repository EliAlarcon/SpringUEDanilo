package com.itsqmet.uedanilo.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "aulas")
public class Aula implements Serializable{
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAula;
    private String nombreAula;
    private int capacidadAula;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;
}
