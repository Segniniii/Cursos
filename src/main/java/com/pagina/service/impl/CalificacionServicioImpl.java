/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagina.service.impl;

import com.pagina.dao.CalificacionDao;
import com.pagina.domain.Calificacion;
import com.pagina.service.CalificacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class CalificacionServicioImpl implements CalificacionService{
    
    @Autowired
    private CalificacionDao calificacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Calificacion> getCalificacions() {
        var lista = calificacionDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Calificacion getCalificacion(Calificacion calificacion) {
        return calificacionDao.findById(calificacion.getIdCalificacion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Calificacion calificacion) {
        calificacionDao.save(calificacion);
    }

    @Override
    @Transactional
    public void delete(Calificacion calificacion) {
        calificacionDao.delete(calificacion);
    }

    
    
    
}
