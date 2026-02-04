package com.tugomeria.gestion.servicios.controller;


import com.tugomeria.gestion.servicios.domain.CategoriaServicio;
import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.service.CategoriaServicioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
@RequestMapping("/servicios")
@AllArgsConstructor
public class ServicioController {

    private final CategoriaServicioService categoriaServicioService;

    @GetMapping("/findAll")
    public List<CategoriaServicio> listarServicios(Servicio servicio) {
        return categoriaServicioService.listarCategoriasServicios();
    }


}
