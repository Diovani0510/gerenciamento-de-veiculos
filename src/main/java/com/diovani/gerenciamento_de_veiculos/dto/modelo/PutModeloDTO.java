package com.diovani.gerenciamento_de_veiculos.dto.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PutModeloDTO(
        @NotEmpty(message = "O nome não deve ser vazio.") String nome,
        @Positive(message = "O valor da Fipe deve ser maior do que 0.") BigDecimal valorFipe) {
}
