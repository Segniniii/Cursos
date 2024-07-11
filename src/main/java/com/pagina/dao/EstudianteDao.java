package com.pagina.dao;

import com.pagina.domain.Estudiante;

import org.springframework.data.jpa.repository.*;

public interface EstudianteDao extends JpaRepository<Estudiante, Long> {

    
}
