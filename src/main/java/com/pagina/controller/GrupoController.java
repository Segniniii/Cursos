
package com.pagina.controller;

import com.pagina.domain.Grupo;
import com.pagina.service.GrupoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/vergrupos")
    public String inicio(Model model) {
        List<Grupo> grupos = grupoService.getGrupos();
        model.addAttribute("grupos", grupos);
        model.addAttribute("totalGrupos", grupos.size());
        return "/partes/Grupos";
    }

    @GetMapping("/agregar")
    public String grupoNuevo(Grupo grupo) {
        return "/partes/agregar";
    }

   

    @GetMapping("/eliminar/{idGrupo}")
    public String grupoEliminar(Grupo grupo) {
        grupoService.delete(grupo);
        return "redirect:/partes/listado";
    }

    @GetMapping("/modificar/{idGrupo}")
    public String grupoModificar(Grupo grupo, Model model) {
        grupo = grupoService.getGrupo(grupo);
        model.addAttribute("grupo", grupo);
        return "/partes/modifica";
    }
}
