package com.tugomeria.gestion.visitas.service;

import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.repository.ServicioRealizadoRepository;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import com.tugomeria.gestion.vehiculos.service.VehiculoService;
import com.tugomeria.gestion.visitas.domain.Visita;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;
import com.tugomeria.gestion.visitas.mapper.VisitaMapper;
import com.tugomeria.gestion.visitas.repository.VisitaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitaService {

    private VisitaRepository visitaRepository;
    private ServicioRealizadoRepository servicioRealizadoRepository;
    private VehiculoRepository vehiculoRepository;

    public VisitaResponseDTO iniciarVisita(Long idVehiculo){
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElse(null);
        Visita visita = new Visita();
        visita.setVehiculo(vehiculo);
        visita.setFecha(new Date());
        visita.setTotal(0);
        visita.setVisita_abierta(true);
        visita.setServiciosRealizados(new ArrayList<ServicioRealizado>());
        visitaRepository.save(visita);
        return VisitaMapper.EntityToDTO(visita);
    }

    public VisitaResponseDTO findById(Long id) {
        return visitaRepository.findById(id).map(VisitaMapper::EntityToDTO).orElse(null);
    }

    public List<Visita> findAll() {
        return visitaRepository.findAll();
    }

    public List<Visita> obtenerVisitasPorVehiculo(Long idVehiculo){
        return visitaRepository.findByVehiculoIdVehiculo(idVehiculo);
    }

    public Visita agregarServicio(Long visita_id, Long servicio_realizado_id) {
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        ServicioRealizado servicioRealizado = servicioRealizadoRepository.findById(servicio_realizado_id).orElse(null);
        visita.agregarServicioRealizado(servicioRealizado);
        visitaRepository.save(visita);
        return visita;
    }

    public Visita removerServicio(Long visita_id, Long servicio_realizado_id) {
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        ServicioRealizado servicioRealizado = servicioRealizadoRepository.findById(servicio_realizado_id).orElse(null);
        visita.agregarServicioRealizado(servicioRealizado);
        visitaRepository.save(visita);
        return visita;
    }

    public Visita cerrarVisita(Long visita_id){
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        visita.setVisita_abierta(false);
        visitaRepository.save(visita);
        return visita;
    }

}
