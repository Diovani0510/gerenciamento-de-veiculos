package com.diovani.gerenciamento_de_veiculos.repository;

import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    Page<Modelo> findAllByMarcaId(Long marca, Pageable pageable);
}
