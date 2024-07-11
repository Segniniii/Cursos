package com.pagina.service;

import com.pagina.domain.Profesor;
import java.util.List;

public interface ProfesorService {
    List<Profesor> getProfesores();
    Profesor getProfesor(Profesor profesor);
    void save(Profesor profesor);
    void delete(Profesor profesor);
}
