package com.pagina.service.impl;

import com.pagina.dao.GrupoDao;
import com.pagina.domain.Grupo;
import com.pagina.service.GrupoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GrupoServiceImpl implements  GrupoService{
        
    @Autowired
    private GrupoDao grupoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Grupo> getGrupos() {
        var lista = grupoDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Grupo getGrupo(Grupo grupo) {
        return grupoDao.findById(grupo.getIdGrupo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Grupo grupo) {
        grupoDao.save(grupo);
    }

    @Override
    @Transactional
    public void delete(Grupo grupo) {
        grupoDao.delete(grupo);
    }
}

