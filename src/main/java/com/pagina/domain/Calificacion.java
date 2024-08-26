/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagina.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;


/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable{
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    
    private Long idCalificacion;
    private boolean Revisado;
    private float calificacion;

    public Calificacion() {
    }
     
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    Estudiante estudiante;

    @OneToOne
    @JoinColumn(name = "id_Tarea")
    Tarea tarea;

    public Calificacion(boolean Revisado, float calificacion, Estudiante estudiante, Tarea tarea) {
        this.Revisado = Revisado;
        this.calificacion = calificacion;
        this.estudiante = estudiante;
        this.tarea = tarea;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

   

    public boolean isRevisado() {
        return Revisado;
    }

    public void setRevisado(boolean Revisado) {
        this.Revisado = Revisado;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}
