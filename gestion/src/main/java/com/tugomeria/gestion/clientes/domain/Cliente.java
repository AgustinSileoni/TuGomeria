package com.tugomeria.gestion.clientes.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String razon_social;

    private String cuit;

    @Column(nullable = false)
    private String telefono;

    private String email;

    private String direccion;

    private String observaciones;

    private boolean activo;

    public Cliente(String razonSocial, String telefono) {
        this.razon_social = razonSocial;
        this.telefono = telefono;
    }


}
