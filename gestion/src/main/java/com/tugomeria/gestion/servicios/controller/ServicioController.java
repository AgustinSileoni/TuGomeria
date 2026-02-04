package com.tugomeria.gestion.servicios.controller;


import com.tugomeria.gestion.servicios.domain.CategoriaServicio;
import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.repository.ServicioRepository;
import com.tugomeria.gestion.servicios.service.CategoriaServicioService;
import com.tugomeria.gestion.servicios.service.ServicioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
@RequestMapping("/servicios")
@AllArgsConstructor
public class ServicioController {

    private final CategoriaServicioService categoriaServicioService;
    private final ServicioService servicioService;

    @GetMapping("/findAll")
    public List<Servicio> listarServicios() {
        return servicioService.listarServicios();
    }


}
