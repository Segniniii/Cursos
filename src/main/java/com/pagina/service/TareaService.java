/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pagina.service;

import com.pagina.domain.Tarea;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TareaService {
    
    public List<Tarea> getTareas();

    public Tarea getTarea(Tarea tarea);

    
    public void save(Tarea tarea);

   
    public void delete(Tarea tarea);
    
}
