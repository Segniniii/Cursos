package com.pagina.service;


import com.pagina.domain.Estudiante;
import java.util.List;

public interface EstudianteService {
    

    
    public List<Estudiante> getEstudiantes();

    public Estudiante getEstudiante(Estudiante estudiante);

    
    public void save(Estudiante estudiante);

   
    public void delete(Estudiante estudiante);
}
