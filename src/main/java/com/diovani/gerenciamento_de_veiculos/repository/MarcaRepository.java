package com.diovani.gerenciamento_de_veiculos.repository;

import com.diovani.gerenciamento_de_veiculos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
