package com.tugomeria.gestion.vehiculos.service;

import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import com.tugomeria.gestion.vehiculos.mapper.VehiculoMapper;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoResponseDTO> findAll(){
        return vehiculoRepository.findAll().stream().map(VehiculoMapper::EntityToDTO).toList();
    }



}
