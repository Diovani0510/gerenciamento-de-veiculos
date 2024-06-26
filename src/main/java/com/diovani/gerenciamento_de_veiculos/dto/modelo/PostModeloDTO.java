package com.diovani.gerenciamento_de_veiculos.dto.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PostModeloDTO(
        @NotNull(message = "Marca [e obrigatpória.") Long marcaId,
        @NotBlank(message = "Nome é obrigatório.") String nome,
        @NotNull(message = "Valor da Fipe é obrigatório")
        @Positive(message = "O valor da Fipe deve ser maior do que 0.")
        BigDecimal valorFipe) {
}
