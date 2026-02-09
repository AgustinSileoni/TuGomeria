package com.tugomeria.gestion.vehiculos.repository;

import com.tugomeria.gestion.vehiculos.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query(value = "SELECT * FROM vehiculos WHERE vehiculos.cliente_id = :clienteId", nativeQuery = true)
    List<Vehiculo> findallByClienteId(@Param("clienteId") Long clienteId);

}
