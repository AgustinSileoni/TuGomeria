package com.tugomeria.gestion.vehiculos.domain;

import com.tugomeria.gestion.visitas.domain.Visita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    private Long id;

    @OneToMany(mappedBy = "vehiculo")
    private List<Visita> visitas;

}
