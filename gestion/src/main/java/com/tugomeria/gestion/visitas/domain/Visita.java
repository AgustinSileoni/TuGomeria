package com.tugomeria.gestion.visitas.domain;

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
@Table(name = "visitas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visita_id;

    private Boolean visita_abierta;

    private Date fecha;

    private float total;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", nullable = false)
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "visita", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ServicioRealizado> serviciosRealizados;

    public void agregarServicioRealizado(ServicioRealizado servicio_realizado) {
        this.serviciosRealizados.add(servicio_realizado);
        servicio_realizado.setVisita(this);
    }

    public void removerServicioRealizado(ServicioRealizado servicio_realizado) {
        this.serviciosRealizados.remove(servicio_realizado);
        servicio_realizado.setVisita(null);
    }

}
