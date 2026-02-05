package com.tugomeria.gestion.servicios.mapper;


import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;

public class ServicioRealizadoMapper {

    public static ServicioRealizadoResponseDTO EntityToDTO(ServicioRealizado servicioRealizado){
        ServicioRealizadoResponseDTO servicioRealizadoDTO = new ServicioRealizadoResponseDTO();

        servicioRealizadoDTO.setCantidad(servicioRealizado.getCantidad());
        servicioRealizadoDTO.setPrecio_aplicado(servicioRealizado.getPrecio_aplicado());
        return servicioRealizadoDTO;
    }


}
