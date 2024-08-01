package com.pagina.controller;

import com.pagina.domain.Profesor;
import com.pagina.service.ProfesorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/verprofesores")
    public String verProfesores(Model model) {
        List<Profesor> profesores = profesorService.getProfesores();
        model.addAttribute("profesores", profesores);
        model.addAttribute("totalProfesores", profesores.size());
        return "/profesores/lista-profesores";
    }

    @GetMapping("/agregar")
    public String agregarProfesor(Profesor profesor) {
        return "/profesores/agregar-profesor";
    }

    @PostMapping("/guardar")
    public String guardarProfesor(Profesor profesor) {
        profesorService.save(profesor);
        return "redirect:/profesor/verprofesores";
    }

    @GetMapping("/eliminar/{idProfesor}")
    public String eliminarProfesor(@PathVariable("idProfesor") Long idProfesor) {
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(idProfesor);
        profesorService.delete(profesor);
        return "redirect:/profesor/verprofesores";
    }

    @GetMapping("/modificar/{idProfesor}")
    public String modificarProfesor(@PathVariable("idProfesor") Long idProfesor, Model model) {
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(idProfesor);
        profesor = profesorService.getProfesor(profesor);
        model.addAttribute("profesor", profesor);
        model.addAttribute("esModificacion", true); // Indicador de modo modificación
        return "/profesores/modifica-profesor";
    }
}
