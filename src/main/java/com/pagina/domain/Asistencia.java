package com.pagina.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    
    private Long idAsistencia;
    private boolean asistio;
    private LocalDate fecha; 

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    Estudiante estudiante;

    public Asistencia() {
    }

    public Long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiantes(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    

}
