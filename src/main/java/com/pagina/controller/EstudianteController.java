package com.pagina.controller;

import com.pagina.domain.Estudiante;
import com.pagina.domain.Grupo;
import com.pagina.service.EstudianteService;
import com.pagina.service.GrupoService;
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

    @Autowired
    private GrupoService grupoService;
    
    @GetMapping("/verEstudiantes")
    public String inicio(Model model) {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("totalEstudiantes", estudiantes.size());
        return "/estudiantes/listaEstudiantes";
    }

    @GetMapping("/agregar")
    public String estudianteNuevo(Estudiante estudiante,Model model) {
        List<Grupo> grupos = grupoService.getGrupos();
        model.addAttribute("grupos", grupos);
        return "/estudiantes/agregar-estudiante";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(Estudiante estudiante) {
        estudianteService.save(estudiante);
        return "redirect:/estudiante/verEstudiantes";
    }



    @GetMapping("/eliminar/{idEstudiante}")
    public String estudianteEliminar(Estudiante estudiante) {
        estudianteService.delete(estudiante);
        return "redirect:/estudiante/verEstudiantes";
    }

    @GetMapping("/modificar/{idEstudiante}")
    public String estudianteModificar(Estudiante estudiante, Model model) {
        List<Grupo> grupos = grupoService.getGrupos();
        model.addAttribute("grupos", grupos);
        estudiante = estudianteService.getEstudiante(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "/estudiantes/modifica-estudiante";
    }

}
