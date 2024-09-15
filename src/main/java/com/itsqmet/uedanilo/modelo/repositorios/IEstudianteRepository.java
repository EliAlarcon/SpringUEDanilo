
package com.itsqmet.uedanilo.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsqmet.uedanilo.modelo.entidades.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer>{
    
}
