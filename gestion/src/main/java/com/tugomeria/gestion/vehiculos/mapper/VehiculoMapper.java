package com.tugomeria.gestion.vehiculos.mapper;

import com.tugomeria.gestion.clientes.mapper.ClienteMapper;
import com.tugomeria.gestion.clientes.service.ClienteService;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.dto.VehiculoRequestDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class VehiculoMapper {


    public static VehiculoResponseDTO EntityToDTO(Vehiculo vehiculo){
        VehiculoResponseDTO vehiculoResponseDTO = new VehiculoResponseDTO();
        vehiculoResponseDTO.setMarca(vehiculo.getMarca());
        vehiculoResponseDTO.setModelo(vehiculo.getModelo());
        vehiculoResponseDTO.setPatente(vehiculo.getPatente());
        vehiculoResponseDTO.setObservaciones(vehiculo.getObservaciones());
        vehiculoResponseDTO.setEstado(true);
        vehiculoResponseDTO.setCliente(ClienteMapper.EntityToDTO(vehiculo.getCliente()));
        return vehiculoResponseDTO;
    }

    public static Vehiculo DTOToEntity(VehiculoRequestDTO vehiculoRequestDTO){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca(vehiculoRequestDTO.getMarca());
        vehiculo.setModelo(vehiculoRequestDTO.getModelo());
        vehiculo.setPatente(vehiculoRequestDTO.getPatente());
        vehiculo.setObservaciones(vehiculoRequestDTO.getObservaciones());
        vehiculo.setEstado(vehiculoRequestDTO.getEstado());
        return vehiculo;
    }


}
