package com.pagina.dao;

import com.pagina.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorDao extends JpaRepository<Profesor, Long> {
}
