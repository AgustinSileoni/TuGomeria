package com.tugomeria.gestion.vehiculos.dto;

import com.tugomeria.gestion.visitas.domain.Visita;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiculoResponseDTO {

    private String patente;
    private String marca;
    private String modelo;
    private String observaciones;
    private boolean estado;

}
