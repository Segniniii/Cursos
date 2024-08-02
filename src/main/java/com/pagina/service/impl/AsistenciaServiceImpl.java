
package com.pagina.service.impl;

import com.pagina.dao.AsistenciaDao;
import com.pagina.domain.Asistencia;
import com.pagina.service.AsistenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AsistenciaServiceImpl implements AsistenciaService{
    
     @Autowired
    private AsistenciaDao asistenciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asistencia> getAsistencias() {
        var lista = asistenciaDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Asistencia getAsistencia(Asistencia asistencia) {
        return asistenciaDao.findById(asistencia.getIdAsistencia()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Asistencia asistencia) {
        asistenciaDao.save(asistencia);
    }

    @Override
    @Transactional
    public void delete(Asistencia asistencia) {
        asistenciaDao.delete(asistencia);
    }
}
