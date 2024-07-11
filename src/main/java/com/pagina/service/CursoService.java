package com.pagina.service;

import com.pagina.domain.Curso;
import com.pagina.dao.CursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoDao cursoDao;

    public List<Curso> getCursos() {
        return cursoDao.findAll();
    }

    public Curso getCurso(Long idCurso) {
        return cursoDao.findById(idCurso).orElse(null);
    }

    public void saveCurso(Curso curso) {
        cursoDao.save(curso);
    }

    public void deleteCurso(Long idCurso) {
        cursoDao.deleteById(idCurso);
    }
}
