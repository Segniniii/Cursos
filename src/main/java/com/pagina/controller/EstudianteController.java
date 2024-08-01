package com.pagina.controller;

import com.pagina.domain.Estudiante;
import com.pagina.service.EstudianteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/estudiante")

public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;
    
    @GetMapping("/verEstudiantes")
    public String inicio(Model model) {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("totalEstudiantes", estudiantes.size());
        return "/grupos/listaEstudiantes";
    }
  
    @GetMapping("/agregar")
    public String estudianteNuevo(Estudiante estudiante) {
        return "/partes/agregar";
    }

   

    @GetMapping("/eliminar/{idEstudiante}")
    public String estudianteEliminar(Estudiante estudiante) {
        estudianteService.delete(estudiante);
        return "redirect:/estudiante/verEstudiantes";
    }

    @GetMapping("/modificar/{idEstudiante}")
    public String estudianteModificar(Estudiante estudiante, Model model) {
        estudiante = estudianteService.getEstudiante(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "/partes/modifica";
    }
}
