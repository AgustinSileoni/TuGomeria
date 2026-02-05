package com.tugomeria.gestion.clientes.service;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteRequestDTO;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.mapper.ClienteMapper;
import com.tugomeria.gestion.clientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = ClienteMapper.DTOtoEntity(clienteRequestDTO);
        clienteRepository.save(cliente);
        return ClienteMapper.EntityToDTO(cliente);
    }

    public Cliente obtenerClienteByID(Long id){
        return clienteRepository.findById(id).orElse(null);
    }
    
    public void eliminarCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }

    public List<ClienteResponseDTO> listarClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> clientesResponseDTO = clientes.stream().map(ClienteMapper::EntityToDTO).toList();
        return clientesResponseDTO;

    }





}
