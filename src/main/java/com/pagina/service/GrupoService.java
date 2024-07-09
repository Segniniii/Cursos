package com.pagina.service;


import com.pagina.domain.Grupo;
import java.util.List;

public interface GrupoService {
    

    
    public List<Grupo> getGrupos();

    public Grupo getGrupo(Grupo grupo);

    
    public void save(Grupo grupo);

   
    public void delete(Grupo grupo);
}
