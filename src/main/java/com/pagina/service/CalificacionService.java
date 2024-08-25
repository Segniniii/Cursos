/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pagina.service;

import com.pagina.domain.Calificacion;
import java.util.List;


/**
 *
 * @author Usuario
 */
public interface CalificacionService {
    
    public List<Calificacion> getCalificacions();

    public Calificacion getCalificacion(Calificacion calificacion);

    
    public void save(Calificacion calificacion);

    
    
    public void delete(Calificacion calificacion);
}
