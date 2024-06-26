package com.diovani.gerenciamento_de_veiculos.dto.carro;

import com.diovani.gerenciamento_de_veiculos.enums.CombustivelEnum;

public record PutCarroDTO(
        CombustivelEnum combustivel,
        String cor,
        String urlImagem) {
}
