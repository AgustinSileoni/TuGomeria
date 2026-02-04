package com.tugomeria.gestion.visitas.controller;


import com.tugomeria.gestion.visitas.domain.Visita;
import com.tugomeria.gestion.visitas.service.VisitaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visita")
@AllArgsConstructor
public class VisitaController {

    private VisitaService visitaService;

    @GetMapping("/findAll")
    public List<Visita> findALl(){
        return visitaService.findAll();
    }


}
