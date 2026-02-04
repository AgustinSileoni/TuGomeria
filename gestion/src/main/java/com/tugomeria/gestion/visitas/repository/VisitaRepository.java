package com.tugomeria.gestion.visitas.repository;

import com.tugomeria.gestion.visitas.domain.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitaRepository extends JpaRepository<Visita, Long> {

    List<Visita> findByVehiculoIdVehiculo(Long idVehiculo);

}
