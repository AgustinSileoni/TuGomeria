package com.tugomeria.gestion.visitas.service;

import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.repository.ServicioRealizadoRepository;
import com.tugomeria.gestion.visitas.domain.Visita;
import com.tugomeria.gestion.visitas.repository.VisitaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitaService {

    private VisitaRepository visitaRepository;
    private ServicioRealizadoRepository servicioRealizadoRepository;

    public Visita findById(Long id) {
        return visitaRepository.findById(id).orElse(null);
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
