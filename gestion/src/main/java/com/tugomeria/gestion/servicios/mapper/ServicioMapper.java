package com.tugomeria.gestion.servicios.mapper;


import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.dto.ServicioResponseDTO;

public class ServicioMapper {

    public static ServicioResponseDTO entityToDTO(Servicio servicio) {
        ServicioResponseDTO servicioResponseDTO = new ServicioResponseDTO();
        servicioResponseDTO.setNombre(servicio.getNombre());
        servicioResponseDTO.setPrecio_referencial(servicio.getPrecioReferencial());
        return servicioResponseDTO;
    }




}
