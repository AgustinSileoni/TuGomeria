package com.tugomeria.gestion.vehiculos.mapper;

import com.tugomeria.gestion.clientes.dto.ClienteResponseDTO;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;

public class VehiculoMapper {

    public static VehiculoResponseDTO EntityToDTO(Vehiculo vehiculo){
        VehiculoResponseDTO vehiculoResponseDTO = new VehiculoResponseDTO();
        vehiculoResponseDTO.setMarca(vehiculo.getMarca());
        vehiculoResponseDTO.setModelo(vehiculo.getModelo());
        vehiculoResponseDTO.setPatente(vehiculo.getPatente());
        vehiculoResponseDTO.setObservaciones(vehiculo.getObservaciones());
        vehiculoResponseDTO.setEstado(true);
        return vehiculoResponseDTO;
    }


}
