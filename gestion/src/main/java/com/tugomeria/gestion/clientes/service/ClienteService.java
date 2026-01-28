package com.tugomeria.gestion.clientes.service;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void agregarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }




}
