package com.pagina.controller;

import com.pagina.domain.Asistencia;
import com.pagina.service.AsistenciaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/verAsistencias")
    public String inicio(Model model) {
        List<Asistencia> asistencias = asistenciaService.getAsistencias();
        model.addAttribute("asistencias", asistencias);
        return "/asistencias/lista-asistencia";
    }

    @GetMapping("/agregar")
    public String asistenciaNuevo(Asistencia asistencia) {
        return "/asistencias/agregar-asistencia";
    }

    @PostMapping("/guardar")
    public String guardarAsistencia(Asistencia asistencia) {
        asistenciaService.save(asistencia);
        return "redirect:/asistencia/verAsistencias";
    }

    @GetMapping("/eliminar/{idAsistencia}")
    public String asistenciaEliminar(Asistencia asistencia) {
        asistenciaService.delete(asistencia);
        return "redirect:/asistencia/verAsistencias";
    }

    @GetMapping("/modificar/{idAsistencia}")
    public String asistenciaModificar(Asistencia asistencia, Model model) {
        asistencia = asistenciaService.getAsistencia(asistencia);
        model.addAttribute("asistencia", asistencia);
        return "/asistencias/modifica-asistencia";

    }
}
