package com.tugomeria.gestion.visitas.controller;


import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;
import com.tugomeria.gestion.visitas.domain.Visita;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;
import com.tugomeria.gestion.visitas.service.VisitaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idVisita}")
    public VisitaResponseDTO findById(@PathVariable Long idVisita){
        return visitaService.findById(idVisita);
    }

    @PutMapping("/{idVehiculo}")
    public VisitaResponseDTO iniciarVisita(@PathVariable Long idVehiculo){
        return visitaService.iniciarVisita(idVehiculo);
    }

    @PostMapping("/{idVisita}/cerrar")
    public VisitaResponseDTO finalizarVisita(@PathVariable Long idVisita){
        return visitaService.cerrarVisita(idVisita);
    }

    @PostMapping("/{idVisita}/{idServicioRealizado}")
    public VisitaResponseDTO agregarServicioRealizado(@PathVariable Long idVisita, @PathVariable Long idServicioRealizado){
        return visitaService.agregarServicioRealizado(idVisita,idServicioRealizado);
    }

    @GetMapping("/serviciosRealizados/{idVisita}")
    public List<ServicioRealizadoResponseDTO> obtenerServiciosRealizadosPorVisita(@PathVariable Long idVisita){
        return visitaService.obtenerServiciosRealizadosPorVisita(idVisita);
    }
    
}
