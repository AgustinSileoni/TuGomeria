package com.tugomeria.gestion.servicios.domain;

import com.tugomeria.gestion.visitas.domain.Visita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "servicios_realizados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicio_realizado_id;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "visita_id")
    private Visita visita;

    private Integer cantidad;

    private Float precio_aplicado;

    private Float precio_total;

}
