package com.tugomeria.gestion.visitas.domain;

import com.tugomeria.gestion.servicios.domain.Servicio;
import com.tugomeria.gestion.servicios.domain.ServicioRealizado;
import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visita {
    @Id
    private Long visita_id;

    private Boolean visita_abierta;

    private Date fecha;

    private float total;

    @ManyToOne
    @JoinColumn(name = "visita_id", nullable = false)
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "visita")
    private List<ServicioRealizado> servicio_realizado;



}
