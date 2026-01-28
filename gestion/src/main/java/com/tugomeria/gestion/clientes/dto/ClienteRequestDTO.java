package com.tugomeria.gestion.clientes.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    private String razonSocial;
    private String telefono;
    private String cuit;
    private String email;
    private String direccion;
    private String observaciones;
    private boolean activo;

}
