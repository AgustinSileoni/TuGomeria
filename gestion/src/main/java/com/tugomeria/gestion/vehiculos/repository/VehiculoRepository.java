package com.tugomeria.gestion.vehiculos.repository;

import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
