package com.tugomeria.gestion.visitas.service;

import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;
import com.tugomeria.gestion.servicios.mapper.ServicioRealizadoMapper;
import com.tugomeria.gestion.servicios.repository.ServicioRealizadoRepository;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import com.tugomeria.gestion.vehiculos.repository.VehiculoRepository;
import com.tugomeria.gestion.visitas.domain.Visita;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;
import com.tugomeria.gestion.visitas.mapper.VisitaMapper;
import com.tugomeria.gestion.visitas.repository.VisitaRepository;
import lombok.AllArgsConstructor;
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

    private float calcularTotal(Visita visita){
        List<ServicioRealizadoResponseDTO> serviciosRealizados = visita.getServiciosRealizados();
        float total = (float) serviciosRealizados.stream()
                .mapToDouble(
                        p -> p.getPrecio_aplicado() * p.getCantidad())
                .sum();
        return total;
    }

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

    public VisitaResponseDTO agregarServicioRealizado(Long visita_id, Long servicio_realizado_id) {
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        ServicioRealizado servicioRealizado = servicioRealizadoRepository.findById(servicio_realizado_id).orElse(null);
        visita.agregarServicioRealizado(servicioRealizado);
        visita.setTotal(calcularTotal(visita));
        visitaRepository.save(visita);
        return VisitaMapper.EntityToDTO(visita);
    }

    public Visita removerServicio(Long visita_id, Long servicio_realizado_id) {
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        ServicioRealizado servicioRealizado = servicioRealizadoRepository.findById(servicio_realizado_id).orElse(null);
        visita.removerServicioRealizado(servicioRealizado);
        visita.setTotal(calcularTotal(visita));
        visitaRepository.save(visita);
        return visita;
    }

    public VisitaResponseDTO cerrarVisita(Long visita_id){
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        visita.setVisita_abierta(false);
        visita.setTotal(calcularTotal(visita));
        visitaRepository.save(visita);
        return VisitaMapper.EntityToDTO(visita);
    }


    public List<ServicioRealizadoResponseDTO> obtenerServiciosRealizadosPorVisita(Long visita_id){
        Visita visita = visitaRepository.findById(visita_id).orElse(null);
        return visita.getServiciosRealizados();
    }


}
