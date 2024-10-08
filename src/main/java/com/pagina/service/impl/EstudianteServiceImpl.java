package com.pagina.service.impl;

import com.pagina.dao.EstudianteDao;
import com.pagina.domain.Estudiante;

import com.pagina.service.EstudianteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getEstudiantes() {
        var lista = estudianteDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante getEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getIdEstudiante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }

}
