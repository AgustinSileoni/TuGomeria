package com.tugomeria.gestion.vehiculos.controller;


import com.tugomeria.gestion.vehiculos.dto.VehiculoRequestDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import com.tugomeria.gestion.vehiculos.service.VehiculoService;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@AllArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @PostMapping("/add")
    public ResponseEntity<VehiculoResponseDTO> addVehiculo(@RequestBody VehiculoRequestDTO vehiculoRequestDTO){
        VehiculoResponseDTO vehiculoCreadoResponseDTO = vehiculoService.agregarVehiculo(vehiculoRequestDTO);
        return ResponseEntity.ok().body(vehiculoCreadoResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehiculoResponseDTO>> findAllByTipoVehiculo(){
        List<VehiculoResponseDTO> vehiculos =  vehiculoService.findAll();
        return ResponseEntity.ok().body(vehiculos);
    }

    @GetMapping("/visitas")
    public ResponseEntity<List<VisitaResponseDTO>> findAllVisitasByVehiculo(@RequestParam Long idVehiculo){
        List<VisitaResponseDTO> visitas = vehiculoService.findAllVisitas(idVehiculo);
        return ResponseEntity.ok().body(visitas);
    }


}
