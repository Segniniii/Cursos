/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pagina.dao;

import com.pagina.domain.Calificacion;


import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Usuario
 */
public interface CalificacionDao extends JpaRepository<Calificacion, Long>{
    //busca el estudiante por nombre para ver la calificacion
    
}
