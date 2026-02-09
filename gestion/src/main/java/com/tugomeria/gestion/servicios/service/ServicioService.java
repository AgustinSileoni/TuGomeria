package com.tugomeria.gestion.servicios.service;

import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.dto.ServicioResponseDTO;
import com.tugomeria.gestion.servicios.mapper.ServicioMapper;
import com.tugomeria.gestion.servicios.repository.ServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public List<ServicioResponseDTO> listarServicios() {
        return servicioRepository.findAll().stream().map(ServicioMapper::entityToDTO).toList();
    }

    public Servicio getServicioById(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public Servicio desactivarServicio(Long id) {
        Servicio servicio = getServicioById(id);
        servicio.setEstado(false);
        return servicioRepository.save(servicio);
    }

    public Servicio activarServicio(Long id) {
        Servicio servicio = getServicioById(id);
        servicio.setEstado(true);
        return servicioRepository.save(servicio);
    }

}
