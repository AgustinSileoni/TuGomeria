package com.tugomeria.gestion.servicios.controller;

import com.tugomeria.gestion.servicios.dto.ServicioRealizadoRequestDTO;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;
import com.tugomeria.gestion.servicios.mapper.ServicioRealizadoMapper;
import com.tugomeria.gestion.servicios.service.ServicioRealizadoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ServicioRealizado")
@AllArgsConstructor
public class ServicioRealizadoController {

    private ServicioRealizadoService servicioRealizadoService;

    @PostMapping("/agregar")
    public ServicioRealizadoResponseDTO servicioRealizado(@RequestBody ServicioRealizadoRequestDTO servicioRealizadoRequestDTO){
            return servicioRealizadoService.crearServicioRealizado(servicioRealizadoRequestDTO);
    }

}
