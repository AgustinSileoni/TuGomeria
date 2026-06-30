package com.tugomeria.gestion.clientes.service;


import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteRequestDTO;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.repository.ClienteRepository;

import java.util.List;

public interface ClienteService {

    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO);

    public ClienteResponseDTO obtenerClienteByID(Long id);
    
    public void eliminarCliente(Cliente cliente);

    public List<ClienteResponseDTO> listarClientes();





}
