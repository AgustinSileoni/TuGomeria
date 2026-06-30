package com.tugomeria.gestion.servicios.service;

import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoRequestDTO;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;
import com.tugomeria.gestion.servicios.mapper.ServicioRealizadoMapper;
import com.tugomeria.gestion.servicios.repository.ServicioRealizadoRepository;
import com.tugomeria.gestion.servicios.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioRealizadoService {

    private final ServicioRealizadoRepository servicioRealizadoRepository;
    private final ServicioRepository servicioRepository;

    public ServicioRealizadoResponseDTO crearServicioRealizado(ServicioRealizadoRequestDTO servicioRealizadoRequestDTO){
        ServicioRealizado servicioRealizado = ServicioRealizadoMapper.DTOToEntity(servicioRealizadoRequestDTO);
        servicioRealizado.setServicio(servicioRepository.findById(servicioRealizadoRequestDTO.getServicio_id()).orElse(null));
        servicioRealizadoRepository.save(servicioRealizado);
        return ServicioRealizadoMapper.EntityToDTO(servicioRealizado);
    }

    public List<ServicioRealizado> listarServiciosRealizados(){
        return servicioRealizadoRepository.findAll();
    }

    public ServicioRealizado findById(Long id) {
        return servicioRealizadoRepository.findById(id).orElse(null);
    }

}
