/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.pagina.controller;

import com.pagina.domain.Calificacion;
import com.pagina.service.CalificacionService;
import com.pagina.service.EstudianteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Usuario
 */
@Controller
@Slf4j
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;
    
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Calificacion> calificacions = calificacionService.getCalificacions();
        model.addAttribute("calificacions", calificacions);
        return "/calificacion/lista-calificaciones";
    }

    @GetMapping("/estudianteCalificacion/{idCalificacion}")
    public String estudiantesCalificacion(Model model, Calificacion calificacion) {
        var estudiantes = calificacionService.getCalificacion(calificacion).getEstudiante();
        model.addAttribute("estudiante", estudiantes);
        return "/calificacions/lista-calificacion-estudiantes";
    }

    @GetMapping("/agregar")
    public String calificacionNuevo(Calificacion calificacion) {
        return "/calificacions/agregar-calificacion";
    }

    @PostMapping("/guardar")
    public String guardarCalificacion(Calificacion calificacion) {
        calificacionService.save(calificacion);
        return "redirect:/calificacion/listado";
    }

    @GetMapping("/eliminar/{idCalificacion}")
    public String calificacionEliminar(Calificacion calificacion) {
        calificacionService.delete(calificacion);
        return "redirect:/calificacion/listado";
    }

    @GetMapping("/modificar/{idCalificacion}")
    public String calificacionModificar(Calificacion calificacion, Model model) {
        calificacion = calificacionService.getCalificacion(calificacion);
        model.addAttribute("calificacion", calificacion);
        return "/calificacion/modifica-calificacion";
    }

    
}
