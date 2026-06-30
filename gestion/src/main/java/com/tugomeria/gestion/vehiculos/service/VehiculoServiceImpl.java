package com.tugomeria.gestion.vehiculos.service;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.clientes.exceptions.ClienteNoEncontradoException;
import com.tugomeria.gestion.clientes.mapper.ClienteMapper;
import com.tugomeria.gestion.clientes.repository.ClienteRepository;
import com.tugomeria.gestion.clientes.service.ClienteService;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.dto.VehiculoRequestDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import com.tugomeria.gestion.vehiculos.exceptions.PatenteExistenteException;
import com.tugomeria.gestion.vehiculos.exceptions.VehiculoNoEncontradoException;
import com.tugomeria.gestion.vehiculos.mapper.VehiculoMapper;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;
import com.tugomeria.gestion.visitas.mapper.VisitaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final ClienteRepository clienteRepository;

    public VehiculoResponseDTO agregarVehiculo(VehiculoRequestDTO vehiculoRequestDTO){
        Vehiculo nuevo_vehiculo = VehiculoMapper.DTOToEntity(vehiculoRequestDTO);
        corroborarPatenteDuplicada(vehiculoRequestDTO);
        //Busco el cliente correspondiente al id y se lo agrego
        Long cliente_id = vehiculoRequestDTO.getIdCliente();
        Cliente cliente = clienteRepository.findById(cliente_id).orElseThrow();
        nuevo_vehiculo.setCliente(cliente);
        Vehiculo vehiculoAgregado = vehiculoRepository.save(nuevo_vehiculo);
        return VehiculoMapper.EntityToDTO(vehiculoAgregado);
    }

    public VehiculoResponseDTO editarVehiculo(Long id, VehiculoRequestDTO vehiculoRequestDTO){
        //Valido existencia
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new PatenteExistenteException("Registro de vehiculo no encontrado"));
        //Actualizar campos
        vehiculo.setCliente(clienteRepository.findById(vehiculoRequestDTO.getIdCliente()).orElseThrow(() -> new ClienteNoEncontradoException("Registro de cliente no encontrado")                                             ));
        vehiculo.setPatente(vehiculoRequestDTO.getPatente());
        vehiculo.setMarca(vehiculoRequestDTO.getMarca());
        vehiculo.setModelo(vehiculoRequestDTO.getModelo());
        vehiculo.setObservaciones(vehiculoRequestDTO.getObservaciones());
        vehiculo.setPatente(vehiculoRequestDTO.getPatente());
        //Almaceno y retorno
        Vehiculo vehiculoActualizado =  vehiculoRepository.save(vehiculo);
        return VehiculoMapper.EntityToDTO(vehiculoActualizado);
    }

    private void corroborarPatenteDuplicada(VehiculoRequestDTO vehiculoRequestDTO) throws PatenteExistenteException {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findVehiculoByPatente(vehiculoRequestDTO.getPatente());
        if(vehiculo.isPresent()){
            throw new PatenteExistenteException("Patente existente");
        }
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
