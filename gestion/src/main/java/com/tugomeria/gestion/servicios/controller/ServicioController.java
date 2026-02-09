package com.tugomeria.gestion.servicios.controller;


import com.tugomeria.gestion.servicios.dto.ServicioResponseDTO;
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
    public List<ServicioResponseDTO> listarServicios() {
        return servicioService.listarServicios();
    }


}
