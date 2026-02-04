package com.tugomeria.gestion.servicios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias_servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoria_id;

    private String nombre;

    private String descripcion;

    private Boolean estado;

    @OneToMany(mappedBy = "categoriaServicio")
    private List<Servicio> servicios;
}
