package com.tugomeria.gestion.servicios.service;

import com.tugomeria.gestion.servicios.domain.CategoriaServicio;
import com.tugomeria.gestion.servicios.repository.CategoriaServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServicioService {

    private final CategoriaServicioRepository categoriaServicioRepository;

    public CategoriaServicio save(CategoriaServicio categoriaServicio){
        return categoriaServicioRepository.save(categoriaServicio);
    }

    public List<CategoriaServicio> listarCategoriasServicios(){
        return categoriaServicioRepository.findAll();    }

    public CategoriaServicio findById(Long id) {
        return categoriaServicioRepository.findById(id).orElse(null);
    }


}
