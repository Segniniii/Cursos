
package com.pagina.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="grupo")
public class Grupo implements Serializable{
 

    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Long idGrupo;
    private int espacio;
    
    @OneToMany
    @JoinColumn(name="id_grupo", insertable= false,updatable=false)
    List<Estudiante> estudiantes;

    public Grupo() {
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Grupo( int espacio) {
        
        this.espacio = espacio;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    
    
    
}

