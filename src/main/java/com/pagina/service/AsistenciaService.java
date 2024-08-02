
package com.pagina.service;

import com.pagina.domain.Asistencia;
import java.util.List;


public interface AsistenciaService {
    public List<Asistencia> getAsistencias();

    public Asistencia getAsistencia(Asistencia asistencia);

    
    public void save(Asistencia asistencia);

   
    public void delete(Asistencia asistencia);
}
