package com.pagina.dao;

import com.pagina.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfesorDao extends JpaRepository<Profesor, Long> {
    List<Profesor> findByEstadoPostulacion(String estadoPostulacion);
}
