package com.tugomeria.gestion.clientes.controller;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.node.ObjectNode;

import java.util.List;

@RestController("")
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping("/add")
    public ResponseEntity<ClienteResponseDTO> agregarCliente(@RequestBody ObjectNode json){

        Cliente cliente = new Cliente(json.get("razonSocial").asString(), json.get("telefono").asString() );
        clienteService.agregarCliente(cliente);
        
        return ResponseEntity.ok().body(cliente);

    }


}
