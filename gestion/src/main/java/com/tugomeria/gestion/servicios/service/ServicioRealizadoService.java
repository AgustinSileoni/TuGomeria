package com.tugomeria.gestion.servicios.service;

import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.repository.ServicioRealizadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioRealizadoService {

    private final ServicioRealizadoRepository servicioRealizadoRepository;

    public ServicioRealizado save(ServicioRealizado s){
        return servicioRealizadoRepository.save(s);
    }

    public List<ServicioRealizado> listarServiciosRealizados(){
        return servicioRealizadoRepository.findAll();
    }

    public ServicioRealizado findById(Long id) {
        return servicioRealizadoRepository.findById(id).orElse(null);
    }

}
