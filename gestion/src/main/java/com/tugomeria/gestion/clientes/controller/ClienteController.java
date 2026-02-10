package com.tugomeria.gestion.clientes.controller;

import com.tugomeria.gestion.clientes.dto.ClienteRequestDTO;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    @GetMapping("/findAll")
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes(){

        List<ClienteResponseDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorID(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteService.obtenerClienteByID(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ClienteResponseDTO> agregarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        ClienteResponseDTO clienteCreadoResponseDTO = clienteService.crearCliente(clienteRequestDTO);
        return ResponseEntity.ok().body(clienteCreadoResponseDTO);
    }



}
