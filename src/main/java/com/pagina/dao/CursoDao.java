package com.pagina.dao;

import com.pagina.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoDao extends JpaRepository<Curso, Long> {
}
