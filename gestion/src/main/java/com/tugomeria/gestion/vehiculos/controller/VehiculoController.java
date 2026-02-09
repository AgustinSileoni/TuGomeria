package com.tugomeria.gestion.vehiculos.controller;


import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoRequestDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
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
    public ResponseEntity<List<VehiculoResponseDTO>> findAllVehiculo(){
        List<VehiculoResponseDTO> vehiculos =  vehiculoService.findAll();
        return ResponseEntity.ok().body(vehiculos);
    }

    @GetMapping("/{idVehiculo}/cliente")
    public ResponseEntity<ClienteResponseDTO> obtenerduenioVehiculo(@PathVariable Long idVehiculo){
        ClienteResponseDTO clienteResponseDTO = vehiculoService.obtenerDuenio(idVehiculo);
        return ResponseEntity.ok().body(clienteResponseDTO);
    }

    @GetMapping("/{idVehiculo}/visitas")
    public ResponseEntity<List<VisitaResponseDTO>> obtenerVisitas(@PathVariable Long idVehiculo){
        List<VisitaResponseDTO> visitas = vehiculoService.findAllVisitas(idVehiculo);
        return ResponseEntity.ok().body(visitas);
    }

    @GetMapping("/all/{idCliente}")
    public ResponseEntity<List<VehiculoResponseDTO>> obtenerVehiculosCliente(@PathVariable Long idCliente){
        List<VehiculoResponseDTO> vehiculosCliente = vehiculoService.findByIdCliente(idCliente);
        return ResponseEntity.ok().body(vehiculosCliente);
    }

}
