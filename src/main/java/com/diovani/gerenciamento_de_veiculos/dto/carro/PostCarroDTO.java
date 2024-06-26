package com.diovani.gerenciamento_de_veiculos.dto.carro;

import com.diovani.gerenciamento_de_veiculos.enums.CombustivelEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostCarroDTO(
        @NotNull(message = "Modelo é obrigatório.") Long modeloId,
        @NotNull(message = "Ano é obrigatório.") @Min(1886) @Max(2025) Integer ano,
        @NotNull(message = "Combustível é obrigatório.") CombustivelEnum combustivel,
        @NotNull(message = "Número de portas é obrigatório.") @Min(1) @Max(4) Integer numeroPortas,
        @NotBlank(message = "Cor é obrigatória.") String cor,
        String urlImagem) {
}
