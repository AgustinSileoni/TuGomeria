package com.tugomeria.gestion.vehiculos.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculoRequestDTO {

    private Long id_cliente;
    private String marca;
    private String modelo;
    private String color;
    private String patente;
    private String observaciones;
    private Boolean estado;


}
