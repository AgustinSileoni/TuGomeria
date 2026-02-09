package com.tugomeria.gestion.vehiculos.service;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.mapper.ClienteMapper;
import com.tugomeria.gestion.clientes.repository.ClienteRepository;
import com.tugomeria.gestion.clientes.service.ClienteService;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.dto.VehiculoRequestDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import com.tugomeria.gestion.vehiculos.mapper.VehiculoMapper;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;
import com.tugomeria.gestion.visitas.mapper.VisitaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final ClienteRepository clienteRepository;

    public VehiculoResponseDTO agregarVehiculo(VehiculoRequestDTO vehiculoRequestDTO){
        Vehiculo nuevo_vehiculo = VehiculoMapper.DTOToEntity(vehiculoRequestDTO);

        //Busco el cliente correspondiente al id y se lo agrego
        Long cliente_id = vehiculoRequestDTO.getId_cliente();
        Cliente cliente = clienteRepository.findById(cliente_id).orElseThrow();
        nuevo_vehiculo.setCliente(cliente);
        Vehiculo vehiculoAgregado = vehiculoRepository.save(nuevo_vehiculo);
        return VehiculoMapper.EntityToDTO(vehiculoAgregado);
    }

    public List<VehiculoResponseDTO> findAll(){
        return vehiculoRepository.findAll().stream().map(VehiculoMapper::EntityToDTO).toList();
    }

    public VehiculoResponseDTO findById(Long id){
        return vehiculoRepository.findById(id).map(VehiculoMapper::EntityToDTO).orElse(null);
    }

    public List<VisitaResponseDTO> findAllVisitas(Long idVehiculo){
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElse(null);
        List<VisitaResponseDTO> visitasRealizadas = vehiculo.getVisitas().stream().map(VisitaMapper::EntityToDTO).toList();
        return visitasRealizadas;
    }

    public ClienteResponseDTO obtenerDuenio(Long id){
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElse(null);
        return ClienteMapper.EntityToDTO( vehiculo.getCliente());
    }


    public List<VehiculoResponseDTO> findByIdCliente(Long idCliente) {
        return vehiculoRepository.findallByClienteId(idCliente).stream().map(VehiculoMapper::EntityToDTO).toList();
    }
}
