package com.tugomeria.gestion.servicios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioRealizadoRequestDTO {

    private Long  servicio_id;
    private Integer cantidad;
    private Float precio_aplicado;

}
