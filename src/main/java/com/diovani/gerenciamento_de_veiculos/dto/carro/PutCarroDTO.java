package com.diovani.gerenciamento_de_veiculos.dto.carro;

import com.diovani.gerenciamento_de_veiculos.enums.CombustivelEnum;
import jakarta.validation.constraints.NotEmpty;

public record PutCarroDTO(
        CombustivelEnum combustivel,
        @NotEmpty(message = "A cor informada não deve ser vazia.") String cor,
        @NotEmpty(message = "A URL da imagem informada não deve ser vazia.") String urlImagem) {
}
