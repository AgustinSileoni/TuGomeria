package com.tugomeria.gestion.clientes.service;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteRequestDTO;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.exceptions.ClienteNoEncontradoException;
import com.tugomeria.gestion.clientes.mapper.ClienteMapper;
import com.tugomeria.gestion.clientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = ClienteMapper.DTOtoEntity(clienteRequestDTO);
        clienteRepository.save(cliente);
        return ClienteMapper.EntityToDTO(cliente);
    }

    public ClienteResponseDTO obtenerClienteByID(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return ClienteMapper.EntityToDTO(cliente.orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado en la base de datos")));
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
