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
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author memeq
 */
@Data //atomaticamente los setters and getter
@Entity
@Table(name="estudiante")
public class Estudiante implements Serializable{
 

    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;
    private Long idGrupo;
    private String nombeEstudiante;
    

    public Estudiante() {
    }

    public Estudiante(Long idGrupo, String nombeEstudiante) {
        this.idGrupo = idGrupo;
        this.nombeEstudiante = nombeEstudiante;
    }

    

    
    
    
}
