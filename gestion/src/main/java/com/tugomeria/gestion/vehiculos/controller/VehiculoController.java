package com.tugomeria.gestion.vehiculos.controller;


import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import com.tugomeria.gestion.vehiculos.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@AllArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping("/all")
    public ResponseEntity<List<VehiculoResponseDTO>> findAllByTipoVehiculo(){
        List<VehiculoResponseDTO> vehiculos =  vehiculoService.findAll();
        return ResponseEntity.ok().body(vehiculos);
    }


}
