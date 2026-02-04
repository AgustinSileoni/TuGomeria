package com.tugomeria.gestion.clientes.mapper;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteRequestDTO;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;

public class ClienteMapper {

        public static ClienteResponseDTO EntityToDTO(Cliente cliente){
                ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
                clienteResponseDTO.setRazonSocial(cliente.getRazon_social());
                clienteResponseDTO.setTelefono(cliente.getTelefono());
                clienteResponseDTO.setCuit(cliente.getCuit());
                clienteResponseDTO.setEmail(cliente.getEmail());
                clienteResponseDTO.setDireccion(cliente.getDireccion());
                clienteResponseDTO.setObservaciones(cliente.getObservaciones());
                clienteResponseDTO.setActivo(cliente.isActivo());
                return clienteResponseDTO;
        }

        public static Cliente DTOtoEntity(ClienteRequestDTO clienteRequestDTO){
            Cliente cliente = new Cliente();
            cliente.setRazon_social(clienteRequestDTO.getRazonSocial());
            cliente.setTelefono(clienteRequestDTO.getTelefono());
            cliente.setCuit(clienteRequestDTO.getCuit());
            cliente.setEmail(clienteRequestDTO.getEmail());
            cliente.setDireccion(clienteRequestDTO.getDireccion());
            cliente.setObservaciones(clienteRequestDTO.getObservaciones());
            cliente.setActivo(clienteRequestDTO.isActivo());
            return cliente;
        }


}
