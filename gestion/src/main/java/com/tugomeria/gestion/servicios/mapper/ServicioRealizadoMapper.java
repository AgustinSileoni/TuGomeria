package com.tugomeria.gestion.servicios.mapper;


import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoRequestDTO;
import com.tugomeria.gestion.servicios.dto.ServicioRealizadoResponseDTO;
import com.tugomeria.gestion.servicios.repository.ServicioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ServicioRealizadoMapper {

    public static ServicioRealizadoResponseDTO EntityToDTO(ServicioRealizado servicioRealizado){
        ServicioRealizadoResponseDTO servicioRealizadoDTO = new ServicioRealizadoResponseDTO();
        servicioRealizadoDTO.setServicioResponseDTO(ServicioMapper.entityToDTO(servicioRealizado.getServicio()));
        servicioRealizadoDTO.setCantidad(servicioRealizado.getCantidad());
        servicioRealizadoDTO.setPrecio_aplicado(servicioRealizado.getPrecio_aplicado());
        return servicioRealizadoDTO;
    }

    public static ServicioRealizado DTOToEntity(ServicioRealizadoRequestDTO servicioRealizadoRequestDTO){
        ServicioRealizado servicioRealizado = new ServicioRealizado();
        servicioRealizado.setCantidad(servicioRealizadoRequestDTO.getCantidad());
        servicioRealizado.setPrecio_aplicado(servicioRealizadoRequestDTO.getPrecio_aplicado());
        servicioRealizado.calcularTotal();
        return servicioRealizado;
    }

}
