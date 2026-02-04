package com.tugomeria.gestion.vehiculos.domain;

import com.tugomeria.gestion.clientes.domain.Cliente;
import com.tugomeria.gestion.visitas.domain.Visita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vehiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String patente;

    private String marca;

    private String modelo;

    private String observaciones;

    private Boolean estado;

    @OneToMany(mappedBy = "vehiculo")
    private List<Visita> visitas;

}
