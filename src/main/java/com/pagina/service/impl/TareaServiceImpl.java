/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagina.service.impl;

import com.pagina.dao.TareaDao;
import com.pagina.domain.Tarea;
import com.pagina.service.TareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class TareaServiceImpl implements TareaService{
    
    @Autowired
    private TareaDao tareaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> getTareas() {
        var lista = tareaDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Tarea getTarea(Tarea tarea) {
        return tareaDao.findById(tarea.getIdTarea()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tarea tarea) {
        tareaDao.save(tarea);
    }

    @Override
    @Transactional
    public void delete(Tarea tarea) {
        tareaDao.delete(tarea);
    }
}
