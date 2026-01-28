package com.tugomeria.gestion.clientes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.tugomeria.gestion.clientes.domain.Cliente;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
