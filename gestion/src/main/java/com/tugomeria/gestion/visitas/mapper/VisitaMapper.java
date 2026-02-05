package com.tugomeria.gestion.visitas.mapper;

import com.tugomeria.gestion.vehiculos.mapper.VehiculoMapper;
import com.tugomeria.gestion.visitas.domain.Visita;
import com.tugomeria.gestion.visitas.dto.VisitaResponseDTO;

public class VisitaMapper {

    public static VisitaResponseDTO EntityToDTO(Visita visita){
        VisitaResponseDTO visitaDTO = new VisitaResponseDTO();

        visitaDTO.setVisita_abierta(visita.getVisita_abierta());
        visitaDTO.setTotal(visita.getTotal());
        visitaDTO.setServiciosRealizados(visita.getServiciosRealizados());
        visitaDTO.setVehiculoResponseDTO(VehiculoMapper.EntityToDTO(visita.getVehiculo()));
        return visitaDTO;
    }


}

