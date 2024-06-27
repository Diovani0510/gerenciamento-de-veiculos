package com.diovani.gerenciamento_de_veiculos.repository;

import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    Page<Modelo> findAllByMarcaId(Long marcaId, Pageable pageable);
    List<Modelo> findAllByMarcaId(Long marcaId);
}
