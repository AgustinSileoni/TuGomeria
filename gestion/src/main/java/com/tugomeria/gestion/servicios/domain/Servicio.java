package com.tugomeria.gestion.servicios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicio_id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaServicio categoriaServicio;

    private Float precioReferencial;

    private Boolean estado;

    @OneToMany(mappedBy = "servicio")
    private List<ServicioRealizado> serviciosRealizados;
}
