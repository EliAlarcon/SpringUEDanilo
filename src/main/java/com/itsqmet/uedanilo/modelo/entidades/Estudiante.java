package com.itsqmet.uedanilo.modelo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;

    private String nombreEstudiante;

    private String apellidoEstudiante;

    private Date fechaNacimiento;

    private String email;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones = new ArrayList<>();
}
