package com.pagina.controller;

import com.pagina.domain.Curso;
import com.pagina.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/vercursos")
    public String verCursos(Model model) {
        model.addAttribute("cursos", cursoService.getCursos());
        return "/cursos/lista-cursos";
    }

    @GetMapping("/agregar")
    public String agregarCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "/cursos/agregar-curso";
    }

    @GetMapping("/modificar/{idCurso}")
    public String modificarCurso(@PathVariable("idCurso") Long idCurso, Model model) {
        Curso curso = cursoService.getCurso(idCurso);
        model.addAttribute("curso", curso);
        model.addAttribute("esModificacion", true);
        return "/cursos/modifica-curso";
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoService.saveCurso(curso);
        return "redirect:/curso/vercursos";
    }

    @GetMapping("/eliminar/{idCurso}")
    public String eliminarCurso(@PathVariable("idCurso") Long idCurso) {
        cursoService.deleteCurso(idCurso);
        return "redirect:/curso/vercursos";
    }
}
