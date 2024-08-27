/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.pagina.controller;

import com.pagina.domain.Tarea;
import com.pagina.service.CalificacionService;
import com.pagina.service.TareaService;
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
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    

    @GetMapping("/vertareas")
    public String inicio(Model model) {
        List<Tarea> tareas = tareaService.getTareas();
        model.addAttribute("tareas", tareas);
        model.addAttribute("totalTareas", tareas.size());
        return "/tareas/lista-tareas";
    }

   
    
    @GetMapping("/agregar")
    public String tareaNuevo(Tarea tarea) {
        return "/tareas/agregar-tarea";
    }

    @PostMapping("/guardar")
    public String guardarTarea(Tarea tarea) {
        tareaService.save(tarea);
        return "redirect:/tarea/vertareas";
    }

    @GetMapping("/eliminar/{idTarea}")
    public String tareaEliminar(Tarea tarea) {
        tareaService.delete(tarea);
        return "redirect:/tarea/vertareas";
    }

    @GetMapping("/modificar/{idTarea}")
    public String tareaModificar(Tarea tarea, Model model) {
        tarea = tareaService.getTarea(tarea);
        model.addAttribute("tarea", tarea);
        return "/tareas/modifica-tarea";
    }
}
