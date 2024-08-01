package com.pagina.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;
    

    @Column(name = "nombre_profesor", nullable = false)
    private String nombreProfesor;

    @Column(name = "apellido_profesor", nullable = false)
    private String apellidoProfesor;

    @Column(name = "email_profesor", nullable = false)
    private String emailProfesor;
    
    @Column(name = "estado_postulacion", nullable = false)
    private String estadoPostulacion;

    // Getters y Setters
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    public String getEstadoPostulacion() {
        return estadoPostulacion;
    }

    public void setEstadoPostulacion(String estadoPostulacion) {
        this.estadoPostulacion = estadoPostulacion;
    }
}
