package com.diovani.gerenciamento_de_veiculos.repository;

import com.diovani.gerenciamento_de_veiculos.model.Carro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    Page<Carro> findAllByModeloId(Long modeloId, Pageable pageable);
    Page<Carro> findAllByModeloMarcaId(Long marcaId, Pageable pageable);
}
