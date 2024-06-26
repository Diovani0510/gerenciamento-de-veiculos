package com.diovani.gerenciamento_de_veiculos.dto.modelo;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PutModeloDTO(
        String nome,
        @Positive(message = "O valor da Fipe deve ser maior do que 0.") BigDecimal valorFipe) {
}
