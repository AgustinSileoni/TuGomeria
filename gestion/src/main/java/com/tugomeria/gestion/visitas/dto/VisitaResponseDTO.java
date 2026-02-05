package com.tugomeria.gestion.visitas.dto;

import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;
import com.tugomeria.gestion.vehiculos.dto.VehiculoResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VisitaResponseDTO {


    private float total;
    private boolean visita_abierta;
    private List<ServicioRealizadoResponseDTO>  serviciosRealizados;
    private VehiculoResponseDTO vehiculoResponseDTO;



}
